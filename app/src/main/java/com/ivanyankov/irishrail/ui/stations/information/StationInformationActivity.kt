package com.ivanyankov.irishrail.ui.stations.information

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.ivanyankov.irishrail.R
import com.ivanyankov.irishrail.data.model.StationObject
import com.ivanyankov.irishrail.databinding.ActivityStationInformationBinding
import com.ivanyankov.irishrail.ui.BaseActivity
import com.ivanyankov.irishrail.ui.trains.information.TrainInformationActivity
import com.ivanyankov.irishrail.ui.trains.recyclerviews.TrainsAdapter
import com.ivanyankov.irishrail.ui.trains.uimodel.TrainUiModel

class StationInformationActivity :
    BaseActivity<StationInformationContract.View, StationInformationContract.Presenter>(),
    StationInformationContract.View, TrainsAdapter.TrainAdapterClickListener {

    private lateinit var binding: ActivityStationInformationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =
            DataBindingUtil.setContentView(this, R.layout.activity_station_information)

        val stationObject = intent.extras?.get(EXTRA_KEY_STATION_OBJECT) as StationObject?
        presenter = StationInformationPresenter()
        presenter.apply {
            attachView(this@StationInformationActivity)
            stationObject?.let {
                it.stationCode?.let { stationCode ->
                    presenter.loadStationData(
                        stationCode,
                        resources
                    )
                }
            }
                ?: throw IllegalArgumentException("StationObject is missing")
        }

        binding.tvStationName.text = stationObject?.stationDesc ?: ""
    }

    override fun displayTrains(trainsPositions: List<TrainUiModel>) {
        val linerLayoutManager = LinearLayoutManager(this)
        val trainAdapter = TrainsAdapter(trainsPositions, this)
        binding.rvTrainStops.apply {
            layoutManager = linerLayoutManager
            adapter = trainAdapter
        }
    }

    companion object {
        private const val EXTRA_KEY_STATION_OBJECT = "EXTRA_KEY_STATION_OBJECT"

        fun start(activity: Activity, stationObject: StationObject) {
            Intent(activity, StationInformationActivity::class.java)
                .apply {
                    putExtra(EXTRA_KEY_STATION_OBJECT, stationObject)
                }
                .also { activity.startActivity(it) }
        }
    }

    override fun onTrainClicked(trainUiModel: TrainUiModel) =
        TrainInformationActivity.start(this, trainUiModel)

}