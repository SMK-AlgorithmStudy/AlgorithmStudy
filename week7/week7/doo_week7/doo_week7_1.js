// 백준 7562
// [입력]
// 입력의 첫째 줄에는 테스트 케이스의 개수가 주어진다.
// 각 테스트 케이스는 세 줄로 이루어져 있다. 
// 첫째 줄에는 체스판의 한 변의 길이 l(4 ≤ l ≤ 300)이 주어진다. 체스판의 크기는 l × l이다. 
// 체스판의 각 칸은 두 수의 쌍 {0, ..., l-1} × {0, ..., l-1}로 나타낼 수 있다. 
// 둘째 줄과 셋째 줄에는 나이트가 현재 있는 칸, 나이트가 이동하려고 하는 칸이 주어진다.

// [출력]
// 각 테스트 케이스마다 나이트가 최소 몇 번만에 이동할 수 있는지 출력한다.

const fs = require('fs');
const INPUTFILE = process.platform === 'linux' ? '/dev/stdin' : 'week7/input.txt';
const input = fs.readFileSync(INPUTFILE).toString().trim().split('\n');

//console.log(typeof(input[0]),typeof(input[1]));
//map(Number)했는데 왜 object임?? 숫자요소로 배열만들었는데.....ㅠㅠ

const direction = [[1,2],[-1,2],[1,-2],[-1,-2],[2,1],[2,-1],[-2,1],[-2,-1]];
let start,end,size,visited;

// 최단길이 탐색이므로 bfs 사용
function bfs(){
    queue = [[start[0],start[1],0]];
    while(!!queue.length){
        const [x,y,move] = queue.shift();

        if(x == end[0] && y == end[1]) return move;

        for(let i=0;i<8;i++){
            const next_x = x + direction[i][0];
            const next_y = y + direction[i][1];

            if(next_x>=0 && next_x<size && next_y>=0 && next_y<size && !visited[next_x][next_y]){   // 좌표 범위 제한 + 방문여부 조사
                visited[next_x][next_y] = 1;
                queue.push([next_x,next_y,move+1]);
            }
        }
    }
}

const n = input.shift(); // 테스크케이스 개수
for(let j=1;j<=n;j++){
    size = Number(input.shift());
    start = input.shift().split(' ').map(Number);
    end = input.shift().split(' ').map(Number);
    visited = Array.from(Array(size),()=>Array(size).fill(0));

    console.log(bfs());
}