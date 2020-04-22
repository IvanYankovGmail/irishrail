package com.ivanyankov.irishrail.ui.dashboard

import com.ivanyankov.irishrail.data.enums.TrainType
import com.ivanyankov.irishrail.ui.MvpContract

interface DashboardContract {

    interface View : MvpContract.View {

        fun openAllStationsActivity()

        fun openTrainActivityWithTypeAll()

        fun openTrainActivityWithTypeMainline()

        fun openTrainActivityWithTypeSuburban()

        fun openTrainActivityWithTypeDart()
    }

    interface Presenter : MvpContract.Presenter<View> {

        fun onStationsAllClicked()

        fun onGoToTrainTypeClicked(type: TrainType)
    }
}