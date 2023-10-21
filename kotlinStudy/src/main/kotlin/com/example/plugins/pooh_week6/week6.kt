package com.example.plugins.pooh_week6

import java.util.LinkedList
import java.util.Queue

private lateinit var nodeList : Array<MutableList<Int>>
private lateinit var visitedDFS : Array<Int>
private lateinit var visitedBFS : Array<Int>

var count = 0

fun main() {
    val (n, m, v) = readln().split(" ").map { it.toInt() }

    nodeList = Array(n+1) { ArrayList() }
    visitedDFS = Array(n+1) { 0 }
    visitedBFS = Array(n+1) { 0 }

    repeat(m) {
        val (u, w) = readln().split(" ").map { it.toInt() }
        nodeList[u].add(w)
        nodeList[w].add(u)
    }

    nodeList.forEach {
        it.sort()
    }

    visitedDFS[v] = count++
    dfs(v)
    println()

    count = 1

    bfs(v)
}

// 깊이 우선 탐색
fun dfs(start: Int) {
    if (visitedDFS[start] != 0) return

    visitedDFS[start] = count++
    print("$start ")

    nodeList[start].forEach {
        dfs(it)
    }
}

// 너비 우선 탐색
fun bfs(start: Int) {
    val queue: Queue<Int> = LinkedList()
    queue.add(start)
    visitedBFS[start] = count++

    while (queue.isNotEmpty()) {
        val node = queue.poll()
        print("$node ")

        nodeList[node].forEach {
            if (visitedBFS[it] == 0) {
                queue.add(it)
                visitedBFS[it] = count++
            }
        }
    }
}