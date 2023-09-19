import java.util.*
import kotlin.collections.ArrayList

lateinit var visited: Array<Int>
lateinit var connected: Array<ArrayList<Int>>
var cnt = 1

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m, r) = readLine().split(" ").map { it.toInt() }

    visited = Array(n+1){0}
    connected = Array(n+1){ ArrayList<Int>() }

    repeat(m){
        val (u, v) = readLine().split(" ").map { it.toInt() }

        connected[u].add(v)
        connected[v].add(u)
    }

    connected.forEach { it.sort() }

    bfs(r)

    for(i in 1 until visited.size){
        println(visited[i])
    }

}

fun bfs(r: Int){
    val queue: Queue<Int> = LinkedList<Int>()
    queue.add(r)

    while(queue.isNotEmpty()){
        val now = queue.poll()
        if(visited[now] == 0) visited[now] = cnt++

        connected[now].forEach { it->
            if(visited[it] == 0){
                visited[it] = cnt++
                queue.add(it)
            }
        }

    }
}