package com.ivanyankov.irishrail.data.model

import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "ArrayOfObjStation")
class StationObjectResponse() {
    @get:ElementList(required = false, inline = true, name = "objStationFilter")
    @set:ElementList(required = false, inline = true, name = "objStationFilter")
    var stationObjectList = mutableListOf<StationObject>()
}