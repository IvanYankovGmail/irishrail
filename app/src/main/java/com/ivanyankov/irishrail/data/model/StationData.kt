package com.ivanyankov.irishrail.data.model

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "objStationData")
class StationData() {

    @get:Element(name = "Servertime", required = false)
    @set:Element(name = "Servertime", required = false)
    var serverTime: String = ""

    @get:Element(name = "Traincode", required = false)
    @set:Element(name = "Traincode", required = false)
    var trainCode: String = ""

    @get:Element(name = "stationfullname", required = false)
    @set:Element(name = "stationfullname", required = false)
    var stationFullName: String = ""

    @get:Element(name = "Stationcode", required = false)
    @set:Element(name = "Stationcode", required = false)
    var stationCode: String = ""

    @get:Element(name = "Querytime", required = false)
    @set:Element(name = "Querytime", required = false)
    var queryTime: String = ""

    @get:Element(name = "Traindate", required = false)
    @set:Element(name = "Traindate", required = false)
    var trainDate: String = ""

    @get:Element(name = "Origin", required = false)
    @set:Element(name = "Origin", required = false)
    var origin: String = ""

    @get:Element(name = "Destination", required = false)
    @set:Element(name = "Destination", required = false)
    var destination: String = ""

    @get:Element(name = "Origintime", required = false)
    @set:Element(name = "Origintime", required = false)
    var originTime: String = ""

    @get:Element(name = "Destinationtime", required = false)
    @set:Element(name = "Destinationtime", required = false)
    var destinationTime: String = ""

    @get:Element(name = "Status", required = false)
    @set:Element(name = "Status", required = false)
    var status: String = ""

    @get:Element(name = "Duein", required = false)
    @set:Element(name = "Duein", required = false)
    var dueIn: String = ""

    @get:Element(name = "Late", required = false)
    @set:Element(name = "Late", required = false)
    var late: String = ""

    @get:Element(name = "Exparrival", required = false)
    @set:Element(name = "Exparrival", required = false)
    var expectedArrival: String = ""

    @get:Element(name = "Expdepart", required = false)
    @set:Element(name = "Expdepart", required = false)
    var expectedDepart: String = ""

    @get:Element(name = "Scharrival", required = false)
    @set:Element(name = "Scharrival", required = false)
    var scheduledArrival: String = ""

    @get:Element(name = "Schdepart", required = false)
    @set:Element(name = "Schdepart", required = false)
    var scheduledDepart: String = ""

    @get:Element(name = "Direction", required = false)
    @set:Element(name = "Direction", required = false)
    var direction: String = ""

    @get:Element(name = "Traintype", required = false)
    @set:Element(name = "Traintype", required = false)
    var trainType: String = ""

    @get:Element(name = "Locationtype", required = false)
    @set:Element(name = "Locationtype", required = false)
    var locationType: String = ""
}