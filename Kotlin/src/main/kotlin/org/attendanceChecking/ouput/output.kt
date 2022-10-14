package org.attendanceChecking.ouput

import com.github.doyaaaaaken.kotlincsv.dsl.csvWriter
import org.attendanceChecking.caculate.caculateE
import java.io.File
import org.attendanceChecking.data.*

// 将结果通过命令行以及文件输出
fun output (Path :String, data : Data){
    val e = caculateE(data)
    println("E = $e")
    var name = Path
    for (it in 1 .. 5){
        name += "/result$it.csv"
        csvWriter().writeAll(data.Result[it-1], name)
        name = Path
    }
}