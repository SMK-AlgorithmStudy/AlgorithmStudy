import java.util.Arrays
import java.util.LinkedList
import java.util.Queue
import kotlin.concurrent.fixedRateTimer

val vertical = arrayOf(2, -2, 1 , -1, 1, -1, -2, 2)
val horizontal = arrayOf(1, -1, 2, -2, -2, 2, 1, -1)
lateinit var resultArray: Array<Int>


fun main() {
    val L = readLine()?.toInt() ?: return
    resultArray = Array(L){ 0 }

    for(i in 0 until L){
        val n = readLine()?.toInt() ?: return
        val chess = Array(n){Array(n){0}}
        val (startX, startY) = readLine()?.split(" ")?.map { it.toInt() } ?: return
        val (endX, endY) = readLine()?. split(" ")?.map { it.toInt() } ?: return

        resultArray[i] = bfs(chess, startX, startY, endX, endY, n)
    }
    resultArray.forEach {it->
        println(it)
    }
}

fun bfs(chess: Array<Array<Int>>, startX: Int, startY: Int, endX: Int, endY: Int, n: Int): Int{
    val queue: Queue<Pair<Int, Int>> = LinkedList<Pair<Int, Int>>()
    queue.offer(Pair(startX, startY))
    chess[startX][startY] = 1
    var cnt = 0

    while (queue.isNotEmpty()) {
        val queueSize = queue.size

        for(i in 0 until queueSize){
            val index = queue.poll()
            if (index.first == endX && index.second == endY) {
                return cnt
            }

            for (j in 0 until 8) {
                val curX: Int = index.first + vertical[j]
                val curY: Int = index.second + horizontal[j]

                if (isValidPosition(n, curX, curY) && chess[curX][curY] == 0) {
                    chess[curX][curY] = 1
                    queue.offer(Pair(curX, curY))
                }
            }
        }
        cnt++
    }
    return -1
}

fun isValidPosition(n: Int, x: Int, y: Int): Boolean{
    return x in 0 until n && y in 0 until n
}
