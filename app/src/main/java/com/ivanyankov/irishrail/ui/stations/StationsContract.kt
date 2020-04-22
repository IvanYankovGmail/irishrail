package com.ivanyankov.irishrail.ui.stations

import com.ivanyankov.irishrail.data.model.StationObject
import com.ivanyankov.irishrail.ui.MvpContract

interface StationsContract {

    interface View : MvpContract.View {

        fun displayStations(stations: List<StationObject>)
    }

    interface Presenter : MvpContract.Presenter<View> {

        fun loadStations()
    }
}