package com.ivanyankov.irishrail.ui.trains.information

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.ivanyankov.irishrail.R
import com.ivanyankov.irishrail.data.model.TrainMovements
import com.ivanyankov.irishrail.databinding.ActivityTrainInformationBinding
import com.ivanyankov.irishrail.ui.BaseActivity
import com.ivanyankov.irishrail.ui.trains.recyclerviews.TrainStationsAdapter
import com.ivanyankov.irishrail.ui.trains.uimodel.TrainUiModel

class TrainInformationActivity :
    BaseActivity<TrainInformationContract.View, TrainInformationContract.Presenter>(),
    TrainInformationContract.View {

    private lateinit var binding: ActivityTrainInformationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =
            DataBindingUtil.setContentView(this, R.layout.activity_train_information)
        presenter = TrainInformationPresenter()
        presenter.attachView(this)

        val trainPosition = intent.extras?.get(EXTRA_KEY_TRAIN_UI_MODEL) as TrainUiModel

        binding.apply {
            tvCode.text = trainPosition.trainCode
            tvDirection.text = trainPosition.direction
            tvStatus.text = trainPosition.status
            tvMessage.text = trainPosition.message
        }

        presenter.loadTrainInformation(trainPosition.trainCode, trainPosition.trainDate)
    }

    override fun displayTrainInformation(trainsMovements: List<TrainMovements>) {
        val linerLayoutManager = LinearLayoutManager(this)
        val trainStationsAdapter = TrainStationsAdapter(trainsMovements)
        binding.rvTrainStops.apply {
            layoutManager = linerLayoutManager
            adapter = trainStationsAdapter
        }
    }

    companion object {
        private const val EXTRA_KEY_TRAIN_UI_MODEL = "EXTRA_KEY_TRAIN_UI_MODEL"

        fun start(activity: Activity, trainUiModel: TrainUiModel) {
            Intent(activity, TrainInformationActivity::class.java)
                .apply {
                    putExtra(EXTRA_KEY_TRAIN_UI_MODEL, trainUiModel)
                }
                .also { activity.startActivity(it) }
        }
    }
}