package com.example.plugins.pooh_week4

import com.example.plugins.pooh_week4_2.postorderSearch
import java.util.LinkedList
import java.util.Queue


// 각 노드 데이터 클래스
data class Node(
    var value: Employee,
    var left: Node? = null,
    var right: Node? = null,
)

// 트리 클래스
class Tree {
    private var root: Node? = null

    fun insert(value: Employee) {
        // 새로운 노드 생성
        val newNode = Node(value)

        // 루트 노드가 null 이면 새로운 노드를 루트 노드에 넣고 반환
        if (root == null) {
            root = newNode
            return
        }

        // 큐를 생성하고, 루트 노드 추가
        val queue: Queue<Node> = LinkedList()
        queue.add(root)

        // 큐가 빈 값이 아닐 동안 노드를 넣을 곳을 탐색한다
        while (queue.isNotEmpty()) {
            // 맨 앞의 queue 값을 꺼내서 현재 노드로 설정
            val nowNode = queue.poll()

            if (nowNode.left == null) {
                // 현재 노드의 왼쪽 값이 없으면 새로운 노드를 왼쪽 값으로 설정
                nowNode.left = newNode
                return
            } else if (nowNode.right == null) {
                // 현재 노드의 오른쪽 값이 없으면 새로운 노드를 오른쪽 값으로 설정
                nowNode.right = newNode
                return
            } else {
                // 둘다 값이 있으면 queue에 왼쪽, 오른쪽 노드를 추가해서 재탐색
                queue.add(nowNode.left)
                queue.add(nowNode.right)
            }
//            // 현재 노드가 값과 같으면 반환한다
//            if (nowNode.value == value) break
//

//            // 현재 노드가 새로운 노드 값보다 작을 떄
//            if (nowNode.value.name < value.name) {
//                // 현재 노드의 오른쪽 노드가 null인지 확인
//                if (nowNode.right == null) {
//                    // null이면 현재 노드의 오른쪽에 새로운 노드 삽입
//                    nowNode.right = newNode
//                    break
//                } else {
//                    // null이 아니면 오른쪽 노드로 이동
//                    nowNode = nowNode.right!!
//                }
//            } else {
//                // 현재 노드가 새로운 노드 값보다 클 때
//                if (nowNode.left == null) {
//                    // null이면 현재 노드의 왼쪽에 새로운 노드 삽입
//                    nowNode.left = newNode
//                    break
//                } else {
//                    // null이 아니면 왼쪽 노드로 이동
//                    nowNode = nowNode.left!!
//                }
//            }
        }
    }


    // 전위
    fun preOrder() {
        fun preOrderInternal(node: Node) {
            // 재귀 함수로 순회, 일단 루트 노드 출력
            printEmployee(node.value.name, node.value.position)
            // 왼쪽 노드가 있으면 왼쪽 노드로 재귀함수 호출해서 전위 순회
            if (node.left != null) {
                preOrderInternal(node.left!!)
            }
            // 오른쪽 노드가 있으면 오른쪽 노드로 재귀함수 호출해서 전위 순회

            if (node.right != null) {
                preOrderInternal(node.right!!)
            }
        }
        root?.let { preOrderInternal(it) }
    }


    // 중위
    fun inOrder() {
        fun inOrderInternal(node: Node) {
            if (node.left != null) {
                inOrderInternal(node.left!!)
            }
            printEmployee(node.value.name, node.value.position)
            if (node.right != null) {
                inOrderInternal(node.right!!)
            }
        }
        root?.let { inOrderInternal(it) }
    }

    // 후위
    fun postOrder() {
        fun postOrderInternal(node: Node) {
            if (node.left != null) {
                postOrderInternal(node.left!!)
            }
            if (node.right != null) {
                postOrderInternal(node.right!!)
            }
            printEmployee(node.value.name, node.value.position)
        }
        root?.let { postOrderInternal(it) }

    }
}


data class Employee(
    val name: String,
    val position: String,
)

fun main() {
    val tree = Tree()
    tree.insert(Employee("Alice", "Manager"))
    tree.insert(Employee("Bob", "Developer"))
    tree.insert(Employee("Cindy", "Designer"))
    tree.insert(Employee("David", "Developer"))
    tree.insert(Employee("Eve", "HR"))


    // 전위 순회
    println("Preorder traversal")
    tree.preOrder()


    // 중위 순회
    println("Inorder traversal")
    tree.inOrder()


    // 후위 순회
    println("Postorder traversal")
    tree.postOrder()

}

//
//fun search(value: String): Node? {
//    // 루트 노드가 null이면 null을 반환
//    if (root == null) return null
//
//    // 현재 노드가 루트 노드를 향하도록 설정
//    var nowNode = root
//    println(nowNode)
//
//    // 현재 노드가 null이면 null을 반환하고 탐색 중단
//    while (nowNode != null) {
//        // 현재 노드가 탐색 값과 같으면 현재 노드 반환
//        if (nowNode.value.name == value)
//            println(nowNode.value.name)
//            return nowNode
//        // 현재 노드가 탐색 값보다 작으면
//        if (nowNode.value.name < value) {
//            println(nowNode.value.name)
//            // 현재 노드의 오른쪽 노드로 이동
//            nowNode = nowNode.right
//        } else {
//            println(nowNode.value.name)
//            // 현재 노드가 탐색 값보다 크면 현재 노드의 왼쪽 노드로 이동
//            nowNode = nowNode.left
//        }
//    }
//    return null
//}

fun printEmployee(name: String, position: String) {
    println("Name: $name, Position: $position")
}

