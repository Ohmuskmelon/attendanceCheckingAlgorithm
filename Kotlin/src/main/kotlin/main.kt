import com.github.doyaaaaaken.kotlincsv.dsl.csvReader
import com.github.doyaaaaaken.kotlincsv.dsl.csvWriter
import java.io.File
import org.attendanceChecking.input.*
import org.attendanceChecking.data.*
import org.attendanceChecking.caculate.*

fun main (){
    val haha = read("data")
    println(caculateE(haha))
    println(haha.Result[0])
}