// 백준 24444 알고리즘 수업 - 너비 우선 탐색 1

const fs = require('fs');
const INPUT_FILE  = process.platform === 'linux' ? '/dev/stdin' : 'week3/input.txt';
const input = require('fs').readFileSync(INPUT_FILE).toString().trim().split('\n');

// 정점, 간선, 시작정점
const [n,m,r] = input.shift().split(' ').map(Number);

const graph = [...Array(n + 1)].map(() => []);
const visited = new Array(n+1).fill(0);

for(let x of input){
    const [u,v] = x.split(' ').map(Number);
    graph[u].push(v);
    graph[v].push(u);
}

graph.map(i=>i.sort((a,b)=>a-b));

console.log(graph);

let cnt = 1;  // 방문 순서
const queue = [];   // 단순 배열 대신 class 만들어 큐 이용하는 것이 시간복잡도 감소함

bfs(r);

function bfs(curr){
    queue.push(curr);

    while(queue.length!==0){

        var next = queue.shift();
        visited[next] = cnt;

        for(let node of graph[next]){
            if(!visited[node]){
                queue.push(node);
                visited[node] = cnt;
            }
        }
        cnt++;
    }
}

// 배열의 인덱스1부터 개행문자 삽입해서 join 출력
console.log(visited.slice(1).join('\n'));
