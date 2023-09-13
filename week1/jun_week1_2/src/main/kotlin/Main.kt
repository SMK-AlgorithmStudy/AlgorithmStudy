import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val d1 = getNum()
    val d2 = getNum()

    val sortedAnswer = getAnswer(d1, d2).sortedByDescending { it.second }
    println("A:${getModify(d1)}")
    println("B:${getModify(d2)}")
    println("C:${getModify(sortedAnswer)}")
    println(getX(sortedAnswer))
}

// 다항식 저장
fun getNum(): ArrayList<Pair<Int, Int>>{
    val arr = ArrayList<Pair<Int, Int>>()
    val br = BufferedReader(InputStreamReader(System.`in`))

    val st = StringTokenizer(br.readLine())

    while(st.hasMoreTokens()){
        arr.add(Pair(st.nextToken().toInt(), st.nextToken().toInt()))
    }

    return arr
}
// 다항식 수식 표현
fun getModify(arr: List<Pair<Int, Int>>): String{
    var result = ""

    for(i in arr.indices){
        result +=
            if(i == arr.size-1){
                arr[i].first.toString() + "x^" + arr[i].second
            }else{
                arr[i].first.toString() + "x^" + arr[i].second + "+"
            }
    }

    return result
}

// 다항식 계산
fun getAnswer(d1: ArrayList<Pair<Int, Int>>, d2: ArrayList<Pair<Int, Int>>): ArrayList<Pair<Int, Int>>{
    val answer = ArrayList<Pair<Int, Int>>()

    for(i in d1){
        for(j in d2){
            val exp = i.second + j.second
            val coef = i.first * j.first
            var found = false

            // 동일한 계수가 있는지 확인
            for(k in answer.indices){
                if(answer[k].second == exp){
                    answer[k] = Pair(answer[k].first + coef, exp)
                    found = true
                    break
                }
            }

            if(!found){
                answer.add(Pair(coef, exp))
            }
        }
    }
    return answer
}

// x값 대입
fun getX(arr: List<Pair<Int, Int>>): Int{
    var result = 0
    print("x = ")
    val x = readln().toInt()

    arr.forEach { it ->
        result += it.first*(Math.pow(x.toDouble(), it.second.toDouble()).toInt())
    }

    return result
}