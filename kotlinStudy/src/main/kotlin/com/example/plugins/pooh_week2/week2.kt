package com.example.plugins.pooh_week2

//1.암호 만들기
//
//[입력]
//
//8개의 숫자를 입력받는다.
//첫 번째 숫자를 1 감소한 뒤, 맨 뒤로 보낸다. 다음 첫 번째 수는 2감소한 뒤 맨 뒤로, 첫 번째 수는 3을 감소하고 맨 뒤로, 그 다음 수는 4, 그 다음 수는 5를 감소해 다음 오는 첫 번째 수는 다시 1을 감소한 후 맨 뒤로 보낸다. 이와 같은 작업을 반복한다.
//숫자가 감소할 때 0보다 작아지는 경우 0이 되며, 맨 뒤로 보내는 숫자가 0일 경우에도 수를 맨 뒤로 보낸 이후 한 과정이 종료된다. 이 때의 8자리의 숫자 값이 암호가 된다.
//[조건]
//
//문제는 queue를 사용해 해결해야 한다.
//마지막 암호 배열은 모두 한 자리 수로 구성되어 있다.
//주어지는 수는 0이상 10000 이하의 수이다.
//한 차레 암호 만드는 과정이 완료되면, 프로그램을 종료하지 않고 다음 입력을 기다린다.
//[출력]
//
//#부호와 함께 테스트 케이스의 번호를 출력한 뒤, 테스트 케이스의 답을 출력한다.
//모든 입력이 종료된 후에 한번에 출력해야한다.

import java.util.*

fun main() {
    var test = 0
    while (true) {
        var queueList : Queue<Int>

        inputTest().let {
            queueList = it?.let { it1 -> toQueue(it1) }!!
        }

        printKey(test, queueList)
        test++
    }


    println()

}

fun toQueue(list: List<String>): Queue<Int> {

    val queue: Queue<Int> = LinkedList()
    for (i in 0..7) {
        queue.add(list[i].toInt())
    }

    toKey(queue)

    return queue
}


fun inputTest(): List<String>? {
    // 입력 받기
    var a = readLine()
    var A = a?.split(" ")

    if (A?.size != 8) {
        print("8개의 정수를 입력해야 합니다.")
    }

    return A
}

fun toKey(queue: Queue<Int>) {
    var minus = 1

    while (queue.element() != 0) {
        var new = queue.poll()
        new -= minus
        if(new > 0) {
            queue.add(new)
        } else {
            new = 0
            queue.add(new)
            break
        }
        minus++
        if (minus == 6) {
            minus = 1
        }
    }
}

fun printKey(test : Int, queue: Queue<Int>) {
    print("#${test} ")
    for (i in 0..7) {
        print(queue.poll())
        print(" ")
    }
    println()
}