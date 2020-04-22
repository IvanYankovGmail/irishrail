package com.ivanyankov.irishrail.ui.stations.information

import android.content.res.Resources
import com.ivanyankov.irishrail.ui.MvpContract
import com.ivanyankov.irishrail.ui.trains.uimodel.TrainUiModel

interface StationInformationContract {

    interface View : MvpContract.View {
        fun displayTrains(trainsPositions: List<TrainUiModel>)
    }

    interface Presenter : MvpContract.Presenter<View> {
        fun loadStationData(stationCode: String, resources: Resources)
    }
}