package org.attendanceChecking.input

import com.github.doyaaaaaken.kotlincsv.dsl.csvReader
import java.io.File
import org.attendanceChecking.data.*

internal fun read(Path : String) : Data
{
    var name : String = Path
    val originData = Data()
    for (it in 1 .. 5) {
        name += "/course$it.csv"
        val file = File(name)
        val data = csvReader().readAll(file)
        originData.origin.add(data as course)
        name = Path
    }
    return originData
}