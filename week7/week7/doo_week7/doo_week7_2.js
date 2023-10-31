// 백준 2667
// [입력]
// 첫 번째 줄에는 지도의 크기 N(정사각형이므로 가로와 세로의 크기는 같으며 5≤N≤25)이 입력되고, 
// 그 다음 N줄에는 각각 N개의 자료(0혹은 1)가 입력된다.

// [출력]
// 첫 번째 줄에는 총 단지수를 출력하시오. 그리고 각 단지내 집의 수를 오름차순으로 정렬하여 한 줄에 하나씩 출력하시오.

const fs = require('fs');
const INPUTFILE = process.platform === 'linux' ? '/dev/stdin' : 'week7/input.txt';
const input = fs.readFileSync(INPUTFILE).toString().trim().split('\n');

const N = Number(input.shift());
const map = Array.from(Array(N), ()=>Array(N)); 
const visited = Array.from(Array(N), ()=>Array(N).fill(0));

for(let i=0;i<N;i++){
    const row = input.shift().split('').map(Number);
    map[i] = row;
}

const dx = [-1,0,1,0];
const dy = [0,-1,0,1];

const answer = [];
let number = 0;

// bfs로도 가능
const dfs = (x,y) => {

    // map범위 내, 방문X, 집 존재O
    if( x>=0 && x<N && y>=0 && y<N &&
        visited[x][y] === 0 &&
        map[x][y] === 1){

        visited[x][y] = 1;
        number++;

        for(let i=0;i<4;i++){   // 주위에 있는지 탐색
            const nx = x + dx[i];
            const ny = y + dy[i];

            dfs(nx,ny);
        }
    }
}

const sol = () => {
    for(let x=0; x<N; x++){
        for(let y=0; y<N; y++){
            if(map[x][y] === 1 && visited[x][y] === 0){ 
                // 더이상 연결된 집 없어서 단지 범위 확정되면 (=dfs재귀함수반복) 끝나면 
                // 그 전 단지와 연결되어있지않은 집 찾아 단지 재탐색
                dfs(x,y);
                answer.push(number);
                number = 0;
            }
        }
    }
    answer.sort((a,b)=>a-b); // 오름차순 정렬
    console.log(answer.length+'\n'+answer.join('\n'));  // 총 단지수, 각 단지내 집의 수
}

sol();
