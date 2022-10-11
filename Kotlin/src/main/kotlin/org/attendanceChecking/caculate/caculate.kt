package org.attendanceChecking.caculate

import org.attendanceChecking.data.*

fun caculateE (data : Data) : Double {
    for (currentCourse in 0 .. 4){
        for (currentDay in 1 .. 20)
            caculateACourse(data, currentDay, currentCourse)
        data.checkList.clear()
        data.bad.clear()
    }
    data.E = data.wins.toDouble() / (data.fails+data.wins)
    return data.E
}

fun caculateACourse (data: Data, currentDay : Int, currentCourse : Int) : Unit {
    if (currentDay == 1){
        for (it in 1 .. 12){
            val isIn = data.origin[currentCourse][it][currentDay + 3]
            val currentRecord = data.origin[currentCourse][it]
            val currentName = currentRecord[0]
            if (isIn == "1")
                data.fails++
            else{
                data.wins++
                data.checkList.add(currentRecord)
                val currentBad = badStudent(currentName, false)
                data.bad.add(currentBad)
            }
        }
    }
    else if (currentDay in 2 .. 3){
        for (currentBad in data.bad){
            val currentLine = data.checkList.indexOfFirst{ it[0] == currentBad.name}
            val isIn = data.checkList[currentLine][currentDay+3]
            if (isIn == "1") {
                data.fails++
                if(currentBad.lastCheck)
                    currentBad.allNotAttendance++
                else {
                    currentBad.lastCheck = true
                    currentBad.allNotAttendance++
                }
            }
            else{
                data.wins++
                currentBad.lastCheck = false
                currentBad.allNotAttendance = 0
            }
        }
    }
    else {
        for (i in data.bad.size-1 downTo 0){
            val currentBad = data.bad[i]
            val currentLine = data.checkList.indexOfFirst{ it[0] == currentBad.name}
            val isIn = data.checkList[currentLine][currentDay+3]
            if (isIn == "1"){
                data.fails++
                if (currentBad.lastCheck && currentBad.allNotAttendance < 2)
                    currentBad.allNotAttendance++
                else if (currentBad.lastCheck && currentBad.allNotAttendance >= 2) {
                    data.bad.removeAt(i)
                }
                else{
                    currentBad.lastCheck = true
                    currentBad.allNotAttendance++
                }
            }
            else{
                data.wins++
                currentBad.lastCheck = false
                currentBad.allNotAttendance = 0
            }
        }
    }

}