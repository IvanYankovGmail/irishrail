package com.ivanyankov.irishrail.data.model

import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "ArrayOfObjTrainMovements")
class TrainMovementResponse() {
    @get:ElementList(required = false, inline = true, name = "objTrainMovements")
    @set:ElementList(required = false, inline = true, name = "objTrainMovements")
    var trainMovementList = mutableListOf<TrainMovements>()
}