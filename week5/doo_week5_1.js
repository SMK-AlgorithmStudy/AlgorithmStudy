// 백준 2263 트리의 순회
// 첫째 줄에 n(1 ≤ n ≤ 100,000)이 주어진다. 
// 다음 줄에는 인오더를 나타내는 n개의 자연수가 주어지고, 
// 그 다음 줄에는 같은 식으로 포스트오더가 주어진다.

// 첫째 줄에 프리오더를 출력한다.

const fs = require('fs');
const INPUTFILE = process.platform === 'linux' ? '/dev/stdin' : 'week5/input.txt';
const input = fs.readFileSync(INPUTFILE).toString().trim().split('\n');

const n = Number(input.shift()); // 노드 개수
const inorder = input.shift().split(' ').map(Number); // 인오더 = 중위순회
const postorder = input.shift().split(' ').map(Number); // 포스트오더 = 후위순회

const result = [];  // 프리오더 = 전위순회 결과

// 중위순회 시작노드 ,끝노드, 후위순회 시작노드, 끝노드
function preorder(instart, inend, poststart, postend) {
    if(instart>inend || poststart>postend) return;

    let root = postorder[postend];  // 후위순회(왼-오-루트)의 마지막 요소
    let rootIndex = inorder.indexOf(root); // 후위순회 내용을 바탕으로 중위순회에서 루트노드 검색

    let leftsize = rootIndex - instart;
    let rightsize = inend - rootIndex;

    result.push(root);
    
    // 루트를 기준으로 왼쪽 트리 탐색
    preorder(instart,instart+leftsize-1,poststart,poststart+leftsize-1);
    // 루트를 기준으로 오른쪽 트리 탐색
    preorder(inend-rightsize+1,inend,postend-rightsize,postend-1);
}

preorder(0,n-1,0,n-1);

console.log(result.join(' '));