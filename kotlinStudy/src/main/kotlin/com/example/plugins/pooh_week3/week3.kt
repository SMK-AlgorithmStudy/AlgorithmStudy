package com.example.plugins.pooh_week3

//오늘도 서준이는 깊이 우선 탐색(DFS) 수업 조교를 하고 있다. 아빠가 수업한 내용을 학생들이 잘 이해했는지 문제를 통해서 확인해보자.
//N개의 정점과 M개의 간선으로 구성된 무방향 그래프(undirected graph)가 주어진다. 정점 번호는 1번부터 N번이고 모든 간선의 가중치는 1이다. 정점 R에서 시작하여 깊이 우선 탐색으로 노드를 방문할 경우 노드의 방문 순서를 출력하자.
//깊이 우선 탐색 의사 코드는 다음과 같다. 인접 정점은 오름차 순으로 방문한다.


private lateinit var list: Array<MutableList<Int>>
private lateinit var visited: Array<Int>
var count = 1 // 시작 정점을 1로 초기화

fun main() {
    // v: 정점 번호, e: 간선 번호, r: 스타트 정점
    val (v, e, r) = readln().split(" ").map { it.toInt() }

    // 간선
    list = Array(v + 1) { ArrayList() }
    // 모든 정점 0으로 초기화
    visited = Array(v + 1) { 0 }

    // 간선의 수 만큼 반복
    repeat(e) {
        // 양 방향 간선 정보 입력하기
        val (u, w) = readln().split(" ").map { it.toInt() }
        list[u].add(w)
        list[w].add(u)
    }

    // 간선 정보 정렬
    list.forEach {
        it.sort()
    }

    // 스타트 정점에서 깊이 우선 탐색
    dfs(r)

    // 정점 번호에 따라 방문 순서를 출력
    for (i in 1..v) {
        println(visited[i])
    }
}

fun dfs(i: Int) {
    // 만약 visited의 값이 0이 아니면, 즉 1번 방문해서 값이 더해졌으면 탐색하지 않고 return
    if (visited[i] != 0) return

    // 이번 정점에서 방문했으면 count에서 1을 더하고 그 값을 대입
    visited[i] = count++

    list[i].forEach {
        dfs(it)
    }
}
