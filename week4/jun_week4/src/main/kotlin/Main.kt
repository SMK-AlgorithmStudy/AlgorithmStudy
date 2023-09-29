import java.util.*

fun main() {
    val tree = Tree()
    tree.insert(Employee("Alice", "Manager"))
    tree.insert(Employee("Bob", "Developer"))
    tree.insert(Employee("Cindy", "Designer"))
    tree.insert(Employee("David", "Developer"))
    tree.insert(Employee("Eve", "HR"))

    println("Preorder traversal")
    tree.printPreorder()

    println("Inorder traversal")
    tree.printInorder()

    println("Postorder traversal")
    tree.printPostorder()
}

data class Node(
    val data: Employee,
    var left: Node? = null,
    var right: Node? = null
)

class Tree {
    private var root: Node? = null

    fun insert(data: Employee) {
        val newNode = Node(data)

        if (root == null) {
            root = newNode
            return
        }

        val queue: Queue<Node> = LinkedList<Node>()
        queue.add(root)

        while (queue.isNotEmpty()) {
            val currentNode = queue.poll()

            if (currentNode.left == null) {
                currentNode.left = newNode
                return
            } else if (currentNode.right == null) {
                currentNode.right = newNode
                return
            } else {
                queue.add(currentNode.left)
                queue.add(currentNode.right)
            }
        }
    }

    fun printPreorder() {
        root?.let { printPreorder(it) }
    }

    private fun printPreorder(root: Node) {
        root.data.printInfo()
        root.left?.let { printPreorder(it) }
        root.right?.let { printPreorder(it) }
    }

    fun printInorder() {
        root?.let { printInorder(it) }
    }

    private fun printInorder(root: Node) {
        root.left?.let { printInorder(it) }
        root.data.printInfo()
        root.right?.let { printInorder(it) }
    }

    fun printPostorder() {
        root?.let { printPostorder(it) }
    }

    private fun printPostorder(root: Node) {
        root.left?.let { printPostorder(it) }
        root.right?.let { printPostorder(it) }
        root.data.printInfo()
    }
}

class Employee(
    private val name: String,
    private val position: String
) {
    fun printInfo() {
        println("Name: $name, Position: $position")
    }
}
