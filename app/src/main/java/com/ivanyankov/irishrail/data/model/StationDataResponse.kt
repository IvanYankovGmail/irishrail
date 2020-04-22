package com.ivanyankov.irishrail.data.model

import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "ArrayOfObjStationData")
class StationDataResponse() {
    @get:ElementList(required = false, inline = true, name = "objStationData")
    @set:ElementList(required = false, inline = true, name = "objStationData")
    var stationDataList = mutableListOf<StationData>()
}