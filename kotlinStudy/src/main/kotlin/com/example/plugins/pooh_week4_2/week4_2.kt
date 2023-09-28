package com.example.plugins.pooh_week4_2



data class Node(
    var value: String,
    var left: Node? = null,
    var right: Node? = null
)

data class Tree(
    val root: Node = Node("A")
)

fun main() {
    val tree = Tree()
    val n = readln().toInt()
    repeat(n) {
        val (value, left, right) = readln().split(" ")
        val newNode = Node(value)
        val leftNode = Node(left)
        val rightNode = Node(right)
        if (leftNode != Node(".")) {
            newNode.left = leftNode
        }
        if (rightNode != Node(".")) {
            newNode.right = rightNode
        }
        println(newNode)

        insert(tree, newNode)
    }

}


fun insert(tree: Tree, newNode: Node) {
    var nowNode = tree.root

    while (true) {
        if (nowNode.left == null) {
            nowNode.left = newNode.left
            break
        } else {
            nowNode = nowNode.left!!
        }
        if (nowNode.right == null) {
            nowNode.right = newNode.right
            break
        } else {
            nowNode = nowNode.right!!
        }

        println(tree)
    }
}

fun preorderSearch() {

}

fun inorderSearch() {

}

fun postorderSearch() {

}