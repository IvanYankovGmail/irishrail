package com.ivanyankov.irishrail.data.model

import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "ArrayOfObjTrainPositions")
class TrainsPositionResponse() {
    @get:ElementList(required = false, inline = true, name = "objTrainPositions")
    @set:ElementList(required = false, inline = true, name = "objTrainPositions")
    var trainPositionList = mutableListOf<TrainPosition>()
}