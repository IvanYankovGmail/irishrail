package com.ivanyankov.irishrail.ui.trains.all

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.ivanyankov.irishrail.R
import com.ivanyankov.irishrail.data.enums.TrainType
import com.ivanyankov.irishrail.databinding.ActivityTrainsBinding
import com.ivanyankov.irishrail.ui.BaseActivity
import com.ivanyankov.irishrail.ui.trains.information.TrainInformationActivity
import com.ivanyankov.irishrail.ui.trains.recyclerviews.TrainsAdapter
import com.ivanyankov.irishrail.ui.trains.uimodel.TrainUiModel

class TrainsActivity : BaseActivity<TrainsContract.View, TrainsContract.Presenter>(),
    TrainsContract.View, TrainsAdapter.TrainAdapterClickListener {

    private lateinit var binding: ActivityTrainsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =
            DataBindingUtil.setContentView(this, R.layout.activity_trains)

        val type = intent.extras?.get(EXTRA_KEY_TYPE) as TrainType?
        presenter = TrainsPresenter()
        presenter.apply {
            attachView(this@TrainsActivity)
            type?.let { presenter.loadTrains(it, resources) }
                ?: throw IllegalArgumentException("Type is missing")
        }
    }

    override fun displayTrains(trainsPositions: List<TrainUiModel>) {
        val linerLayoutManager = LinearLayoutManager(this)
        val trainAdapter = TrainsAdapter(trainsPositions, this)
        binding.rvTrains.apply {
            layoutManager = linerLayoutManager
            adapter = trainAdapter
        }
    }

    companion object {
        private const val EXTRA_KEY_TYPE = "type"

        fun start(activity: Activity, type: TrainType) {
            Intent(activity, TrainsActivity::class.java)
                .apply {
                    putExtra(EXTRA_KEY_TYPE, type)
                }
                .also { activity.startActivity(it) }
        }
    }

    override fun onTrainClicked(trainUiModel: TrainUiModel) {
        TrainInformationActivity.start(this, trainUiModel)
    }
}