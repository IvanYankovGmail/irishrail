package com.ivanyankov.irishrail.ui.trains.all

import android.content.res.Resources
import com.ivanyankov.irishrail.data.enums.TrainType
import com.ivanyankov.irishrail.ui.MvpContract
import com.ivanyankov.irishrail.ui.trains.uimodel.TrainUiModel

interface TrainsContract {

    interface View : MvpContract.View {
        fun displayTrains(trainsPositions: List<TrainUiModel>)
    }

    interface Presenter : MvpContract.Presenter<View> {
        fun loadTrains(trainType: TrainType, resources: Resources)
    }
}