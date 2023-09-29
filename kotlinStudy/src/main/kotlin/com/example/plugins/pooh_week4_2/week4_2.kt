package com.example.plugins.pooh_week4_2

import java.util.LinkedList
import java.util.Queue


data class Node(
    var value: String,
    var left: Node? = null,
    var right: Node? = null
)

class Tree {
    var root: Node? = null

    fun insert(value: String, left: Node?, right: Node?) {
        val newNode = Node(value, left, right)

        if (root == null) {
            root = newNode
            return
        }

        val queue: Queue<Node> = LinkedList()
        queue.add(root)

        while (queue.isNotEmpty()) {
            val nowNode = queue.poll()

            if (nowNode != null) {
                if (nowNode.value == value) {
                    nowNode.left = left
                    nowNode.right = right
                    return
                }

                queue.add(nowNode.left)
                queue.add(nowNode.right)
            }
        }
    }

    fun preorderSearch(node: Node?) {
        if (node != null) {
            print(node.value)
            preorderSearch(node.left)
            preorderSearch(node.right)
        }
    }

    fun inorderSearch(node: Node?) {
        if (node != null) {
            inorderSearch(node.left)
            print(node.value)
            inorderSearch(node.right)
        }
    }


    fun postorderSearch(node: Node?) {
        if (node != null) {
            postorderSearch(node.left)
            postorderSearch(node.right)
            print(node.value)
        }
    }
}



fun main() {
    val tree = Tree()
    val n = readln().toInt()
    repeat(n) {
        val (value, left, right) = readln().split(" ")
        val leftNode = if (left == ".") null else Node(left)
        val rightNode = if (right == ".") null else Node(right)
        tree.insert(value, leftNode, rightNode)
    }

    tree.preorderSearch(tree.root)
    println()

    tree.inorderSearch(tree.root)
    println()

    tree.postorderSearch(tree.root)
    println()
}


