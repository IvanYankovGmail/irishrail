package com.ivanyankov.irishrail.ui.trains.uimodel

import android.content.res.Resources
import com.ivanyankov.irishrail.R
import com.ivanyankov.irishrail.data.model.StationData
import com.ivanyankov.irishrail.data.model.TrainPosition

class TrainUiModelMapper(private val resources: Resources) {

    fun mapTrainUiModel(trainPosition: TrainPosition): TrainUiModel {
        val formattedStatus = when (trainPosition.trainStatus) {
            TrainPosition.STATUS_NOT_YET_RUNNING -> resources.getString(R.string.not_yet_running)
            TrainPosition.STATUS_RUNNING -> resources.getString(R.string.running)
            else -> resources.getString(R.string.status_no_information)
        }
        val formattedMessage = trainPosition.publicMessage.replace("\\n", " ")

        return TrainUiModel(
            trainPosition.trainCode,
            trainPosition.direction,
            formattedStatus,
            formattedMessage,
            trainPosition.trainDate
        )
    }

    fun mapTrainUiModel(stationData: StationData): TrainUiModel =
        TrainUiModel(
            stationData.trainCode,
            stationData.direction,
            resources.getString(R.string.scheduled_arrival, stationData.scheduledArrival),
            resources.getString(R.string.scheduled_departure, stationData.scheduledDepart),
            stationData.trainDate
        )
}