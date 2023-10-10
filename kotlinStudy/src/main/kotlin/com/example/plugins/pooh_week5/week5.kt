package com.example.plugins.pooh_week5

// n개의 정점을 갖는 이진 트리의 정점에 1부터 n까지의 번호가 중복 없이 매겨져 있다.
// 이와 같은 이진 트리의 인오더와 포스트오더가 주어졌을 때, 프리오더를 구하는 프로그램을 작성하시오.

// 입력
// 첫째 줄에 n(1 ≤ n ≤ 100,000)이 주어진다.
// 다음 줄에는 인오더를 나타내는 n개의 자연수가 주어지고, 그 다음 줄에는 같은 식으로 포스트오더가 주어진다.

// 출력
// 첫째 줄에 프리오더를 출력한다.


private lateinit var inorder : List<Int>
private lateinit var postorder : List<Int>

private val index = mutableMapOf<Int, Int>()



fun main() {
    val n = readln().toInt()

    inorder  = readln().split(" ").map { it.toInt() }
    postorder = readln().split(" ").map { it.toInt() }

    inorder.forEachIndexed { idx, i ->
        index[i] =  idx
    }
    preOrder(0, n-1, 0, n-1)
}


fun preOrder(inLeft: Int, inRight: Int, postLeft: Int, postRight: Int) {
    if (inLeft > inRight || postRight < postLeft) {
        return
    }
    val rootIdx = index[postorder[postRight]]!!
    val left = rootIdx - inLeft
    print("${postorder[postRight]} ")

    preOrder(inLeft, rootIdx - 1, postLeft, postLeft + left - 1)
    preOrder(rootIdx + 1, inRight, postLeft + left, postRight - 1)
}


