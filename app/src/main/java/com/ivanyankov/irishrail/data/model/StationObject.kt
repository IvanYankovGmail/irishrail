package com.ivanyankov.irishrail.data.model

import android.os.Parcel
import android.os.Parcelable
import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "objStation")
class StationObject() : Parcelable {
    @get:Element(name = "StationDesc", required = false)
    @set:Element(name = "StationDesc", required = false)
    var stationDesc: String? = ""

    @get:Element(name = "StationCode", required = false)
    @set:Element(name = "StationCode", required = false)
    var stationCode: String? = ""

    @get:Element(name = "StationId", required = false)
    @set:Element(name = "StationId", required = false)
    var stationId: String? = ""

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<StationObject> =
            object : Parcelable.Creator<StationObject> {
                override fun createFromParcel(source: Parcel): StationObject = StationObject(source)
                override fun newArray(size: Int): Array<StationObject?> = arrayOfNulls(size)
            }
    }

    constructor(source: Parcel) : this(
    ) {
        this.stationDesc = source.readString();
        this.stationCode = source.readString();
        this.stationId = source.readString();
    }


    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(stationDesc)
        writeString(stationCode)
        writeString(stationId)
    }
}