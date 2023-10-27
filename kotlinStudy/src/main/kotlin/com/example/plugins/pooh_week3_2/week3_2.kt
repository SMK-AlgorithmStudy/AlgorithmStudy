package com.example.plugins.pooh_week3_2

import java.util.*
import kotlin.collections.ArrayList

private lateinit var list : Array<MutableList<Int>>
private lateinit var visited : Array<Int>
var count = 1

fun main() {
    var (v, e, r) = readln().split(" ").map { it.toInt() }

    list = Array(v + 1) { ArrayList() }
    visited = Array(v + 1) { 0 }

    repeat(e) {
        val (u, w) = readln().split(" ").map { it.toInt() }
        list[u].add(w)
        list[w].add(u)
    }

    list.forEach {
        it.sort()
    }

    // 시작 정점 방문 표시
    visited[r] = count++

    bfs(r)

    // 정점 번호에 따라 방문 순서를 출력
    for (i in 1..v) {
        println(visited[i])
    }
}

fun bfs(i: Int) {
    val queue: Queue<Int> = LinkedList()
    queue.add(i)

    // queue 안의 원소가 빌 때까지 반복
    while(queue.isNotEmpty()) {
        // queue 안에 있는 원소를 빼는 poll 활용
        val now = queue.poll()
        list[now].forEach {
            if (visited[it] == 0) {
                visited[it] = count++
                queue.add(it)
            }
        }
    }
}

