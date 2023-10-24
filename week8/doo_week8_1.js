// 백준 1012
// [입력]
// 입력의 첫 줄에는 테스트 케이스의 개수 T가 주어진다. 
// 그리고 배추가 심어져 있는 위치의 개수 K(1 ≤ K ≤ 2500)이 주어진다. 
// 그 다음 K줄에는 배추의 위치 X(0 ≤ X ≤ M-1), Y(0 ≤ Y ≤ N-1)가 주어진다. 두 배추의 위치가 같은 경우는 없다.

// [출력]
// 각 테스트 케이스에 대해 필요한 최소의 배추흰지렁이 마리 수를 출력한다.

// 아파트, 단지문제에서 단지 수 구하는 것과 같다!

const fs = require("fs");
const INPUTFILE = process.platform === 'linux' ? '/dev/stdin' : 'week8/input.txt';
const input = fs.readFileSync(INPUTFILE).toString().trim().split('\n');

let map, cnt, visited, result;
let [m,n,k] = [0,0,0];
const dx=[-1,0,1,0]; 
const dy=[0,-1,0,1];

function sol(){
    const t = Number(input.shift());    // T 테스트 케이스의 개수
    result = [];    // 테케별 필요한 최소의 배추흰지렁이 마리 수 저장할 배열
    for (let i=0; i<t; i++){    // 각각 테스트 케이스에 대해
        [m,n,k] = input.shift().split(' ').map(Number);   // M,N,K 가로길이,세로길이,배추가 심어져 있는 위치의 개수
        map = Array.from(Array(m), ()=>Array(n).fill(0)); // M*N 크기 배추밭map
        visited = Array.from(Array(m), ()=>Array(n).fill(0)); // M*N 크기 방문여부 확인용 배열 

        // map[x][y] = 1로 세팅
        for(let j=0; j<k; j++){
            const [x,y] = input.shift().split(' ').map(Number); // 배추가 심어져 있는 x,y 좌표 값
            map[x][y] = 1;  
        }
        cnt = 0;    // 해당 테케에 대해 배추흰지렁이 마리 수 cnt 값 초기화

        // 이중 반복문으로 모든 좌표 조건부 bfs탐색!
        for(let p=0; p<m; p++){
            for(let q=0; q<n; q++){
                if(map[p][q] == 1 && visited[p][q] == 0){
                    bfs(p,q);
                }
            }
        }
        result.push(cnt);
    }
    console.log(result.join("\n"));
}

function bfs(sx,sy){
    queue = [[sx,sy]];    // 탐색시작하는 좌표로 큐 요소 초기화

    while(!!queue.length){
        const [x,y] = queue.shift();

        for (let z=0;z<4;z++){
            const nx = x + dx[z];
            const ny = y + dy[z];
    
            if(nx>=0 && nx<m && ny>=0 && ny<n && !visited[nx][ny] && map[nx][ny]){
                visited[nx][ny] = 1;    // 방문 여부 업데이트
                queue.push([nx,ny]);
            }
        }
    }
    return cnt++;
}

sol();