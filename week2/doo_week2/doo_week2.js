// [입력]
// 8개의 숫자를 입력받는다.
// 첫 번째 숫자를 1 감소한 뒤, 맨 뒤로 보낸다. 다음 첫 번째 수는 2감소한 뒤 맨 뒤로, 
// 첫 번째 수는 3을 감소하고 맨 뒤로, 그 다음 수는 4, 그 다음 수는 5를 감소해 
// 다음 오는 첫 번째 수는 다시 1을 감소한 후 맨 뒤로 보낸다. 이와 같은 작업을 반복한다.
// 숫자가 감소할 때 0보다 작아지는 경우 0이 되며, 맨 뒤로 보내는 숫자가 0일 경우에도 수를 맨 뒤로 보낸 이후 한 과정이 종료된다. 
// 이 때의 8자리의 숫자 값이 암호가 된다.

// [조건]
// 문제는 queue를 사용해 해결해야 한다.
// 마지막 암호 배열은 모두 한 자리 수로 구성되어 있다.
// 주어지는 수는 0이상 10000 이하의 수이다.
// 한 차레 암호 만드는 과정이 완료되면, 프로그램을 종료하지 않고 다음 입력을 기다린다.

// [출력]
// #부호와 함께 테스트 케이스의 번호를 출력한 뒤, 테스트 케이스의 답을 출력한다.
// 모든 입력이 종료된 후에 한번에 출력해야한다.

// [입력예시 (복붙해서 테스트 해보세요!!) ]
// 670 667 669 671 670 670 668 671
// 1709 1707 1712 1712 1714 1710 1706 1712

const fs = require('fs');
const input = fs.readFileSync('week2/input.txt').toString().split("\n").map(item => item.split(" ").map(Number));

// enqueue는 push(), dequeue는 shift(), 배열 형태로 queue구현 가능하지만, 시간복잡도 O(n)>O(1)
// 따라서, 연결리스트 형태로 queue 구현
// class 와 function 구현 둘 다 가능하지만 class가 재사용성 더 좋음

class Node {
    constructor(data){
        this.data = data;
        this.next = null;
    }
}

class Queue {
    constructor() {
        this.front = null;
        this.back = null;
    }
    isEmpty() {
        return this.front == null && this.back == null;
    }
    enqueue(data) {
        const newNode = new Node(data);
        if (this.isEmpty()) { this.front = newNode; }
        else { this.back.next = newNode; }  // 새로운 노드 추가
        this.back = newNode; // 마지막 요소 재지정
    }
    dequeue() {
        if(this.isEmpty()) return;
        const value = this.front.data;
        this.front = this.front.next;
        return value;
    }
    print() {
        let r = "";
        if (this.isEmpty()) return;
        let curr = this.front;
        while(curr!=this.back){
            r+=" "+curr.data;
            curr = curr.next;
        }
        r+=" "+curr.data;
        return r;
    }  
}    

for (let i=0; i<input.length; i++){
    var queue = new Queue();

    // 입력받은 8개의 숫자 한 줄씩 큐 생성
    for(let j=0; j<8; j++){
        queue.enqueue(input[i][j]);
    }
    pw_queue = create_password(queue);
    console.log(print_password(pw_queue,i));
}

function create_password(que){
    var k=1; // 인덱스

    while(true){
        let x = que.dequeue(); // 첫번째 원소 추출
        
        if(k%5==1){
            x -= 1; 
        }
        else if(k%5==2){
            x -= 2; 
        }
        else if(k%5==3){
            x -= 3; 
        }
        else if(k%5==4){
            x -= 4; 
        }
        else{
            x -= 5; 
        }

        if(x<=0){
            x = 0;
            que.enqueue(x); // 맨 뒤로 보내기
            break;
        }
        
        que.enqueue(x); // 맨 뒤로 보내기 
        k++;
        if(k==6) { k=1; } // 5씩 로테이션
    }
    
    return que;
}

function print_password(que,i){
    let pw ="";
    pw += "#"+i+que.print();
    return pw;
}

