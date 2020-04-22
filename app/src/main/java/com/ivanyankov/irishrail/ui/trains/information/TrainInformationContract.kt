package com.ivanyankov.irishrail.ui.trains.information

import com.ivanyankov.irishrail.data.model.TrainMovements
import com.ivanyankov.irishrail.ui.MvpContract

interface TrainInformationContract {

    interface View : MvpContract.View {

        fun displayTrainInformation(trainsMovements: List<TrainMovements>)
    }

    interface Presenter : MvpContract.Presenter<View> {

        fun loadTrainInformation(trainCode: String, trainDate: String)
    }
}