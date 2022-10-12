package org.attendanceChecking.ouput

import com.github.doyaaaaaken.kotlincsv.dsl.csvWriter
import java.io.File
import org.attendanceChecking.data.*

fun output (Path :String, data : Data){
    var name = Path
    for (it in 1 .. 5){
        name += "/result$it.csv"
        csvWriter().writeAll(data.Result[it-1], name)
        name = Path
    }
}