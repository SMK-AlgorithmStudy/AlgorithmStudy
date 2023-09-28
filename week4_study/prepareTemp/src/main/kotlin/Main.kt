import java.util.*

data class Node(
    var data: String = "",
    var left: Node? = null,
    var right: Node? = null
)

fun main() {
    val tree = Tree()
    val N = readln().toInt()

    repeat(N) {
        var (root, left, right) = readln().split(" ")
        val leftNode = if(left == ".") null else Node(left, null, null)
        val rightNode = if(right == ".") null else Node(right, null, null)

        tree.insert(root, leftNode, rightNode)
    }

    tree.preorderPrint()
    println()
    tree.inorderPrint()
    println()
    tree.postorderPrint()
}

class Tree{
    var root: Node? = null

    fun insert(data: String, left: Node?, right: Node?){
        val newNode = Node(data, left, right)

        if(root == null){
            root = newNode
            return
        }

        val queue: Queue<Node> = LinkedList<Node>()
        queue.add(root)

        while(queue.isNotEmpty()){
            val nowNode = queue.poll()

            if(nowNode?.left?.data == newNode.data){
                nowNode.left?.left = newNode.left
                nowNode.left?.right = newNode.right
                return
            }else if(nowNode?.right?.data == newNode.data){
                nowNode.right?.left = newNode.left
                nowNode.right?.right = newNode.right
                return
            }else{
                if(nowNode.left != null){
                    queue.add(nowNode.left)
                }
                if(nowNode.right != null){
                    queue.add(nowNode.right)
                }
            }
        }
    }

    fun preorderPrint(){
        preorderPrint(root)
    }
    fun preorderPrint(n: Node?){
        if(n != null){
            print(n.data)
            preorderPrint(n.left)
            preorderPrint(n.right)
        }
    }

    fun inorderPrint(){
        inorderPrint(root)
    }
    fun inorderPrint(n: Node?){
        if(n != null){
            inorderPrint(n.left)
            print(n.data)
            inorderPrint(n.right)
        }
    }

    fun postorderPrint(){
        postorderPrint(root)
    }
    fun postorderPrint(n: Node?){
        if(n != null){
            postorderPrint(n.left)
            postorderPrint(n.right)
            print(n.data)
        }
    }
}

