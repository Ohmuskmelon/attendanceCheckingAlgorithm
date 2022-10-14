package org.attendanceChecking.data

import com.sun.org.apache.xpath.internal.operations.Bool

typealias record = MutableList<String>
typealias course = MutableList<record>

class badStudent(
    val name : String,
    var lastCheck : Boolean = false,
    var allNotAttendance : Int = 0
)

// 利用一个Data类存储所有数据
class Data {
    val origin = mutableListOf<course>()
    val checkList = mutableListOf<record>()
    val bad = mutableListOf<badStudent>()
    val Result = mutableListOf<course>()
    var wins = 0
    var fails = 0
    var E : Double = 0.0
}
