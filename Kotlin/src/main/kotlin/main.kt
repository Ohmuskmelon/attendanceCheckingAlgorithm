import com.github.doyaaaaaken.kotlincsv.dsl.csvReader
import com.github.doyaaaaaken.kotlincsv.dsl.csvWriter
import java.io.File
import org.attendanceChecking.input.*
import org.attendanceChecking.data.*
import org.attendanceChecking.caculate.*
import org.attendanceChecking.ouput.*

fun main (){
    println("Please enter the directory where the data is stored:")
    println("(enter 0 to use the default directory)")
    var readPath = readLine()
    if (readPath == "0")
        readPath = "data"
    assert(readPath != null)
    val data = read(readPath as String)
    println("Please enter the directory where the results are stored:")
    println("(enter 0 to use the default directory)")
    var outPath = readLine()
    if (outPath == "0")
        outPath = "result"
    assert(outPath != null)
    output(outPath as String, data)
    println("Results are stored in $outPath")
}