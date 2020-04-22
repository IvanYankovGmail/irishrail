package com.ivanyankov.irishrail.data.service

import com.ivanyankov.irishrail.data.model.StationDataResponse
import com.ivanyankov.irishrail.data.model.StationObjectResponse
import com.ivanyankov.irishrail.data.model.TrainMovementResponse
import com.ivanyankov.irishrail.data.model.TrainsPositionResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface IrishRailService {

    @GET("getAllStationsXML")
    fun getAllStations(): Single<StationObjectResponse>

    @GET("getStationDataByCodeXML")
    fun getStationsByCode(@Query("StationCode") stationCode: String): Single<StationDataResponse>

    @GET("getCurrentTrainsXML_WithTrainType")
    fun getTrainsByType(@Query("TrainType") type: String): Single<TrainsPositionResponse>

    @GET("getTrainMovementsXML")
    fun getTrainInformation(
        @Query("TrainId") trainId: String,
        @Query("TrainDate") trainDate: String
    ): Single<TrainMovementResponse>
}