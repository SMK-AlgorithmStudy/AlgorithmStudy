import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private lateinit var inOrder: List<Int>
private lateinit var postOrder: List<Int>
private val inOrderIndex = mutableMapOf<Int, Int>()
fun main(args: Array<String>) {
    val N = readln().toInt()

    inOrder = readln().split(" ").map { it.toInt() }
    postOrder = readln().split(" ").map { it.toInt() }

    inOrder.forEachIndexed { index, element ->
        inOrderIndex[element] = index
    }

    preOrder(0, N-1, 0, N-1)
}

fun preOrder(inStart: Int, inEnd: Int, postStart: Int, postEnd: Int){
    if(inStart > inEnd || postStart > postEnd){
        return
    }

    val rootIndex = inOrderIndex[postOrder[postEnd]]
    rootIndex?.let {
        val leftSize = it - inStart
        val rightSize = inEnd - it

        print("${inOrder[it]} ")

        preOrder(inStart, rootIndex-1, postStart, postStart+leftSize-1)
        preOrder(rootIndex+1, inEnd, postEnd-rightSize, postEnd-1)
    }
}