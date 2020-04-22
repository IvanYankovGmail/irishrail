package com.ivanyankov.irishrail.ui.trains.uimodel

import android.os.Parcel
import android.os.Parcelable

data class TrainUiModel(
    val trainCode: String,
    val direction: String,
    val status: String,
    val message: String,
    val trainDate: String
) : Parcelable {
    constructor(source: Parcel) : this(
        source.readString()!!,
        source.readString()!!,
        source.readString()!!,
        source.readString()!!,
        source.readString()!!
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(trainCode)
        writeString(direction)
        writeString(status)
        writeString(message)
        writeString(trainDate)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<TrainUiModel> = object : Parcelable.Creator<TrainUiModel> {
            override fun createFromParcel(source: Parcel): TrainUiModel = TrainUiModel(source)
            override fun newArray(size: Int): Array<TrainUiModel?> = arrayOfNulls(size)
        }
    }
}