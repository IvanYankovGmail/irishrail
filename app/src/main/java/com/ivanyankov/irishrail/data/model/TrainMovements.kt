package com.ivanyankov.irishrail.data.model

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "objTrainMovements")
class TrainMovements() {

    @get:Element(name = "TrainCode", required = false)
    @set:Element(name = "TrainCode", required = false)
    var trainCode: String = ""

    @get:Element(name = "TrainDate", required = false)
    @set:Element(name = "TrainDate", required = false)
    var trainDate: String = ""

    @get:Element(name = "LocationCode", required = false)
    @set:Element(name = "LocationCode", required = false)
    var locationCode: String = ""

    @get:Element(name = "LocationFullName", required = false)
    @set:Element(name = "LocationFullName", required = false)
    var locationFullName: String = ""

    @get:Element(name = "LocationOrder", required = false)
    @set:Element(name = "LocationOrder", required = false)
    var locationOrder: String = ""

    @get:Element(name = "LocationType", required = false)
    @set:Element(name = "LocationType", required = false)
    var locationType: String = ""

    @get:Element(name = "TrainOrigin", required = false)
    @set:Element(name = "TrainOrigin", required = false)
    var trainOrigin: String = ""

    @get:Element(name = "TrainDestination", required = false)
    @set:Element(name = "TrainDestination", required = false)
    var trainDestination: String = ""

    @get:Element(name = "ScheduledArrival", required = false)
    @set:Element(name = "ScheduledArrival", required = false)
    var scheduledArrival: String = ""

    @get:Element(name = "ScheduledDeparture", required = false)
    @set:Element(name = "ScheduledDeparture", required = false)
    var scheduledDeparture: String = ""

    @get:Element(name = "ExpectedArrival", required = false)
    @set:Element(name = "ExpectedArrival", required = false)
    var expectedArrival: String = ""

    @get:Element(name = "ExpectedDeparture", required = false)
    @set:Element(name = "ExpectedDeparture", required = false)
    var expectedDeparture: String = ""

    @get:Element(name = "Arrival", required = false)
    @set:Element(name = "Arrival", required = false)
    var arrival: String = ""

    @get:Element(name = "Departure", required = false)
    @set:Element(name = "Departure", required = false)
    var departure: String = ""

    @get:Element(name = "AutoArrival", required = false)
    @set:Element(name = "AutoArrival", required = false)
    var autoArrival: String = ""

    @get:Element(name = "AutoDepart", required = false)
    @set:Element(name = "AutoDepart", required = false)
    var autoDepart: String = ""

    @get:Element(name = "StopType", required = false)
    @set:Element(name = "StopType", required = false)
    var stopType: String = ""
}