package com.ivanyankov.irishrail.data.model

import android.os.Parcel
import android.os.Parcelable
import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "objTrainPositions")
class TrainPosition() : Parcelable {
    @get:Element(name = "TrainStatus", required = false)
    @set:Element(name = "TrainStatus", required = false)
    var trainStatus: String = ""

    @get:Element(name = "TrainDate", required = false)
    @set:Element(name = "TrainDate", required = false)
    var trainDate: String = ""

    @get:Element(name = "TrainLatitude", required = false)
    @set:Element(name = "TrainLatitude", required = false)
    var trainLatitude: String = ""

    @get:Element(name = "TrainLongitude", required = false)
    @set:Element(name = "TrainLongitude", required = false)
    var trainLongitude: String = ""

    @get:Element(name = "TrainCode", required = false)
    @set:Element(name = "TrainCode", required = false)
    var trainCode: String = ""

    @get:Element(name = "PublicMessage", required = false)
    @set:Element(name = "PublicMessage", required = false)
    var publicMessage: String = ""

    @get:Element(name = "Direction", required = false)
    @set:Element(name = "Direction", required = false)
    var direction: String = ""

    companion object {
        const val STATUS_NOT_YET_RUNNING = "N"

        const val STATUS_RUNNING = "R"

        @JvmField
        val CREATOR: Parcelable.Creator<TrainPosition> =
            object : Parcelable.Creator<TrainPosition> {
                override fun createFromParcel(source: Parcel): TrainPosition = TrainPosition(source)
                override fun newArray(size: Int): Array<TrainPosition?> = arrayOfNulls(size)
            }
    }

    constructor(source: Parcel) : this(
    ) {
        this.trainStatus = source.readString()!!;
        this.trainDate = source.readString()!!;
        this.trainLatitude = source.readString()!!;
        this.trainLongitude = source.readString()!!;
        this.trainCode = source.readString()!!;
        this.publicMessage = source.readString()!!;
        this.direction = source.readString()!!;
    }


    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(trainStatus)
        writeString(trainDate)
        writeString(trainLatitude)
        writeString(trainLongitude)
        writeString(trainCode)
        writeString(publicMessage)
        writeString(direction)
    }
}