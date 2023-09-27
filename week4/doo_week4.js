// 트리구조를 생성하고 전위순회, 중위순회, 후위순회를 출력하시오
// Queue를 사용해 삽입 기능 구현, 재귀함수로 탐색 로직 구현

class TreeNode{
    constructor(data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

const queue = [];

class Tree{
    constructor(){
        this.root = null;
    }
    enqueue(data){
        const newNode = new TreeNode(data);

        while(queue.length!==0){

            currNode = queue[0];

            if(currNode.left===null){
                currNode.left = newNode;
                queue.push(currNode.left);
                return;
            }
            else if(currNode.right==null){
                currNode.right = newNode;
                queue.push(currNode.right);
                return;
            }
            // 자식노드 2개 모두 가지면 
            queue.shift();
        }

        // 큐에 원소 없을 때 = 가장 처음 루트 노드 삽입할 때
        currNode = newNode;
        this.root = currNode;
        queue.push(currNode);
        
    }
}

class Employee{
    constructor(name,position){
        this.name = name;
        this.position = position;
    }
}

const tree = new Tree();
tree.enqueue(new Employee('Alice','Manager'));
tree.enqueue(new Employee("Bob","Developer"));
tree.enqueue(new Employee("Cindy","Designer"));
tree.enqueue(new Employee("David","Developer"));
tree.enqueue(new Employee("Eve","HR"));

let preArr = [];
let inArr = [];
let postArr = [];

// 전위순회
const recursivePreOrder = (node) => {
    if(!node){ return; }
    preArr.push(node.data);
    recursivePreOrder(node.left);
    recursivePreOrder(node.right);
}
// 중위순회
const recursiveInOrder = (node) => {
    if(!node){ return; }
    recursiveInOrder(node.left);
    inArr.push(node.data)
    recursiveInOrder(node.right);
}
// 후위순회
const recursivePostOrder = (node) => {
    if(!node){ return; }
    recursivePostOrder(node.left);
    recursivePostOrder(node.right);
    postArr.push(node.data);
}

console.log("Perorder traversal");
recursivePreOrder(tree.root);
preArr.map(i=>console.log("Name: "+i.name+", Position: "+i.position));

console.log("Inorder traversal");
recursiveInOrder(tree.root);
inArr.map(j=>console.log("Name: "+j.name+", Position: "+j.position));

console.log("Postorder traversal");
recursivePostOrder(tree.root);
postArr.map(k=>console.log("Name: "+k.name+", Position: "+k.position));
