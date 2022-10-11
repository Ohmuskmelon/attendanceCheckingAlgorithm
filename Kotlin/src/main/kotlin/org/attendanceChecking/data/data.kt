package org.attendanceChecking.data

import com.sun.org.apache.xpath.internal.operations.Bool

typealias course = List<List<String>>
typealias record = List<String>

class badStudent(
    val name : String,
    var lastCheck : Boolean = false,
    var allNotAttendance : Int = 0
)

class Data {
    val origin = mutableListOf<course>()
    val checkList = mutableListOf<record>()
    val bad = mutableListOf<badStudent>()
    var wins = 0
    var fails = 0
    var E : Double = 0.0
}