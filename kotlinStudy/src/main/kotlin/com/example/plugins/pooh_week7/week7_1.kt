package com.example.plugins.pooh_week7

import java.util.*

// 백준 7562 - 나이트의 이동

/*

체스판 위에 한 나이트가 놓여져 있다.
나이트가 한 번에 이동할 수 있는 칸은 아래 그림에 나와있다.
나이트가 이동하려고 하는 칸이 주어진다.
나이트는 몇 번 움직이면 이 칸으로 이동할 수 있을까?

입력의 첫째 줄에는 테스트 케이스의 개수가 주어진다.

각 테스트 케이스는 세 줄로 이루어져 있다.
첫째 줄에는 체스판의 한 변의 길이 l(4 ≤ l ≤ 300)이 주어진다.
체스판의 크기는 l × l이다.
체스판의 각 칸은 두 수의 쌍 {0, ..., l-1} × {0, ..., l-1}로 나타낼 수 있다.
둘째 줄과 셋째 줄에는 나이트가 현재 있는 칸, 나이트가 이동하려고 하는 칸이 주어진다.

각 테스트 케이스마다 나이트가 최소 몇 번만에 이동할 수 있는지 출력한다.

 */

data class Knight (
    val x: Int,
    val y: Int,
    val move: Int,
)
fun main() {
    val testCase = readln().toInt()

    val xList = arrayOf(-2, -1, 1, 2, 2, 1, -1, -2)
    val yList = arrayOf(1, 2, 2, 1, -1, -2, -2, -1)

    repeat(testCase) {
        val size = readln().toInt()
        val (nowX, nowY) = readln().split(" ").map { it.toInt() }
        val (toX, toY) = readln().split(" ").map { it.toInt() }

        val visit = Array(size) { BooleanArray(size) }
        val queue: Queue<Knight> = LinkedList()

        queue.add(Knight(nowX, nowY, 0))
        visit[nowX][nowY] = true

        while (queue.isNotEmpty()) {
            val cur = queue.poll()

            if (cur.x == toX && cur.y == toY) {
                println(cur.move)
                break
            }

            for (i in 0 until 8) {
                val nextX = cur.x + xList[i]
                val nextY = cur.y + yList[i]

                if (nextX in 0 until size && nextY in 0 until size && !visit[nextX][nextY]) {
                    visit[nextX][nextY] = true
                    queue.add(Knight(nextX, nextY, cur.move + 1))
                }
            }
        }
    }
}