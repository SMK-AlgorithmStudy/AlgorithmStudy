// 백준 24479 알고리즘 수업 - 깊이 우선 탐색 1

const fs = require('fs');
const INPUT_FILE  = process.platform === 'linux' ? '/dev/stdin' : 'week3/input.txt';
const input = require('fs').readFileSync(INPUT_FILE).toString().trim().split('\n');

const [n,m,r] = input.shift().split(' ').map(Number);

const graph = [...Array(n+1)].map(()=>[]);
const visited = new Array(n).fill(0); 
const answer = new Array(n+1).fill(0);
let cnt = 1;

for(let x of input){
    let [u,v] = x.split(' ').map(Number);
    graph[u].push(v);
    graph[v].push(u);
}

// 오름차순 정렬
graph.map((item)=> item.sort((a,b)=>a-b));

// dfs (재귀함수로 구현)
function dfs(cur){
    visited[cur] = true;
    answer[cur-1]=cnt++;

    for(let i of graph[cur]){  
        if(!visited[i]) {
            dfs(i);
        }
    }
}

dfs(r);

let result = "";
for (let i=0;i<n;i++){
    result+=answer[i]+"\n";
}

console.log(result);
