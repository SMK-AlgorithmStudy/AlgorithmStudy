import java.util.LinkedList
import java.util.Queue
import java.util.Scanner
import java.util.StringTokenizer
import kotlin.properties.Delegates

lateinit var connected: Array<Array<Int>>
lateinit var dfsVisited: Array<Boolean>
lateinit var visited: Array<Array<Boolean>>
lateinit var apart: Array<Int>
val dx = arrayOf(0, 0, 1, -1)
val dy = arrayOf(1, -1, 0, 0)
var appartNum = 0
var N = 0


fun main() {
    N = readLine()?.toInt() ?: return
    val scanner = Scanner(System.`in`)
    connected = Array(N){ Array(N) { 0 } }
    visited = Array(N){ Array(N) { false } }
    apart = Array(N*N){ 0 }

    for(i in 0 until N){
        val input = readLine()
        for(j in 0 until N){
            connected[i][j] = input?.get(j)?.toString()?.toInt() ?: 0
        }
    }

    for(i in 0 until N){
        for(j in 0 until N){
            if(connected[i][j] == 1 && !visited[i][j]){
                appartNum++
                BFS(i, j)
            }
        }
    }

    apart.sort()
    println("$appartNum")

    apart.forEach { v->
        if(v != 0) println(v)
    }

}

fun BFS(x : Int, y : Int){
    val q: Queue<IntArray> = LinkedList()
    q.add(intArrayOf(x, y))
    visited[x][y] = true
    apart[appartNum]++

    while(!q.isEmpty()){
        val curX = q.peek()[0]
        val curY = q.peek()[1]
        q.poll()

        for(i in 0 until 4){
            val nx = curX + dx[i]
            val ny = curY + dy[i]

            if(nx >= 0 && ny >= 0 && nx < N && ny < N){
                if(connected[nx][ny] == 1 && !visited[nx][ny]){
                    q.add(intArrayOf(nx, ny))
                    visited[nx][ny] = true
                    apart[appartNum]++
                }
            }
        }
    }
}
fun DFS(s : Int){
    if(dfsVisited[s]) return
    dfsVisited[s] = true
    print("$s ")

    connected[s].forEach { next->
        DFS(next)
    }

}