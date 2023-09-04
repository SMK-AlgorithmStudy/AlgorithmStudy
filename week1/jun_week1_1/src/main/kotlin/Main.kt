import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())

    val n = st.nextToken().toInt()
    val x = st.nextToken().toInt()

    val arr = createArr()
    BinarySearch(arr, x, n)
}

// 수열 생성 및 버블정렬
fun createArr(): ArrayList<Int>{
    val br = BufferedReader(InputStreamReader(System.`in`))
    val arr = ArrayList<Int>()
    val st = StringTokenizer(br.readLine())

    while(st.hasMoreTokens()){
        arr.add(st.nextToken().toInt())
    }

    for(i in 0 until arr.size - 1){
        for(j in 0 until arr.size - i - 1){
            if(arr[j] > arr[j+1]){
                val tmp = arr[j]
                arr[j] = arr[j+1]
                arr[j+1] = tmp
            }
        }
    }

    return arr
}

// 이원탐색
fun BinarySearch(arr: ArrayList<Int>, x: Int, n: Int){
    var left = 0
    var right = n-1
    var tmp = 0

    if(x > arr[n-1]){
        println("ERROR")
    }else{
        while(left <= right){
            val middle = (left+right) / 2
            if(x < arr[middle]){
                right = middle -1
            }else if(x > arr[middle]){
                left = middle + 1
            }else{
                tmp = middle
                break
            }
        }

        for(i in tmp+1 until n){
            if(arr[i] != arr[tmp]){
                print(arr[i])
                print(" ")
            }
        }
    }
}