import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val answer = LinkedList<Queue<Int>>()

    for(i in 0 until 2){
        val st = StringTokenizer(br.readLine())
        val queue: Queue<Int> = LinkedList<Int>()

        while(st.hasMoreTokens()){
            queue.add(st.nextToken().toInt())
        }

        answer.add(solve(queue))
    }

    printSolve(answer)
}

fun solve(queue: Queue<Int>): Queue<Int>{
    var i = 1

    while(true){
        val addElement =
            if(queue.peek() - i < 0) {
                queue.poll()
                0
            }
            else queue.poll() - i

        queue.add(addElement)
        if(addElement == 0) break

        i++
        if(i == 6) i = 1
    }

    return queue
}

fun printSolve(answer: LinkedList<Queue<Int>>){
    for(i in 0 until answer.size){
        print("#$i ")
        answer[i].forEach { it->
            print("$it ")
        }
        println()
    }
}