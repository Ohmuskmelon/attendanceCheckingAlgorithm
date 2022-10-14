package org.attendanceChecking.caculate

import org.attendanceChecking.data.*

// 计算E的值，返回E的值，并且记录结果，结果记录在data.result中
fun caculateE (data : Data) : Double {
    val title = mutableListOf("Day", "Student", "isAttendance")
    for (currentCourse in 0 .. 4){
        val temCourse = mutableListOf<record>()
        temCourse.add(title)
        for (currentDay in 1 .. 20) {
            val temResult = caculateACourse(data, currentDay, currentCourse)
            temCourse.add(temResult)
        }
        data.Result.add(temCourse)
        data.checkList.clear()
        data.bad.clear()
        // 清空临时表单：点名表以及惯犯名单表
    }
    data.E = data.wins.toDouble() / (data.fails+data.wins)
    return data.E
}

// 计算一门课程的其中一次点名的情况，返回结果记录
fun caculateACourse (data: Data, currentDay : Int, currentCourse : Int) : MutableList<String> {
    val temRecord = mutableListOf<String>()
    temRecord.add("day$currentDay")
    // 第1天点后20%的人，第2-20天利用惯犯名单更新，同时更新惯犯名单
    when (currentDay) {
        1 -> {
            for (it in 1 .. 18){
                val isIn = data.origin[currentCourse][it][currentDay + 3]
                val currentRecord = data.origin[currentCourse][it]
                val currentName = currentRecord[0]
                temRecord.add(currentName)
                temRecord.add(isIn)
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
        in 2 .. 3 -> {
            for (currentBad in data.bad){
                val currentLine = data.checkList.indexOfFirst{ it[0] == currentBad.name}
                val isIn = data.checkList[currentLine][currentDay+3]
                temRecord.add(currentBad.name)
                temRecord.add(isIn)
                if (isIn == "1") {
                    data.fails++
                    if(currentBad.lastCheck)
                        currentBad.allNotAttendance++
                    else {
                        currentBad.lastCheck = true
                        currentBad.allNotAttendance++
                    }
                } else{
                    data.wins++
                    currentBad.lastCheck = false
                    currentBad.allNotAttendance = 0
                }
            }
        }
        else -> {
            for (i in data.bad.size-1 downTo 0){
                val currentBad = data.bad[i]
                val currentLine = data.checkList.indexOfFirst{ it[0] == currentBad.name}
                val isIn = data.checkList[currentLine][currentDay+3]
                temRecord.add(currentBad.name)
                temRecord.add(isIn)
                if (isIn == "1"){
                    data.fails++
                    if (currentBad.lastCheck && currentBad.allNotAttendance < 2)
                        currentBad.allNotAttendance++
                    else if (currentBad.lastCheck && currentBad.allNotAttendance >= 2) {
                        data.bad.removeAt(i)
                    } else{
                        currentBad.lastCheck = true
                        currentBad.allNotAttendance++
                    }
                } else {
                    data.wins++
                    currentBad.lastCheck = false
                    currentBad.allNotAttendance = 0
                }
            }
        }
    }
    return temRecord
}