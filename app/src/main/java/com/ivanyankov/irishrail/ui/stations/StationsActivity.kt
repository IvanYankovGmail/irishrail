package com.ivanyankov.irishrail.ui.stations

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.ivanyankov.irishrail.R
import com.ivanyankov.irishrail.data.model.StationObject
import com.ivanyankov.irishrail.databinding.ActivityStationsBinding
import com.ivanyankov.irishrail.ui.BaseActivity
import com.ivanyankov.irishrail.ui.stations.information.StationInformationActivity
import com.ivanyankov.irishrail.ui.stations.recyclerviews.StationsAdapter

class StationsActivity :
    BaseActivity<StationsContract.View, StationsContract.Presenter>(),
    StationsContract.View, StationsAdapter.StationAdapterClickListener {

    private lateinit var binding: ActivityStationsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =
            DataBindingUtil.setContentView(this, R.layout.activity_stations)
        presenter =
            StationsPresenter()
        presenter.apply {
            attachView(this@StationsActivity)
            loadStations()
        }
    }

    override fun displayStations(stations: List<StationObject>) {
        val linerLayoutManager = LinearLayoutManager(this)
        val trainAdapter = StationsAdapter(stations, this)
        binding.apply {
            rvStations.apply {
                layoutManager = linerLayoutManager
                adapter = trainAdapter
            }
            svStation.setOnQueryTextListener(
                object : SearchView.OnQueryTextListener {
                    override fun onQueryTextSubmit(newText: String?): Boolean {
                        trainAdapter.filter.filter(newText)
                        return false
                    }

                    override fun onQueryTextChange(newText: String?): Boolean {
                        trainAdapter.filter.filter(newText)
                        return false
                    }

                })
        }
    }

    override fun onStationClicked(stationObject: StationObject) {
        StationInformationActivity.start(this, stationObject)
    }

    companion object {

        fun start(activity: Activity) {
            Intent(activity, StationsActivity::class.java)
                .also { activity.startActivity(it) }
        }
    }
}