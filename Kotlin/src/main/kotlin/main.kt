import com.github.doyaaaaaken.kotlincsv.dsl.csvReader
import com.github.doyaaaaaken.kotlincsv.dsl.csvWriter
import java.io.File
import org.attendanceChecking.input.*
import org.attendanceChecking.data.*
import org.attendanceChecking.caculate.*
import org.attendanceChecking.ouput.output

fun main (){
    val haha = read("data")
    println(caculateE(haha))
    output("result", haha)
}