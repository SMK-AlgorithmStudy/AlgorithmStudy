// [1번 문제] 정수 N개로 주어진 수열 A와 정수 X가 주어질때, A에서 X보다 큰 수를 모두 출력하는 프로그램을 작성하시오.

// [조건]
// 선택정렬(or 버블정렬)과 이원탐색 원리를 필수로 사용할 것
// X보다 큰 수 가 없을 경우 Error를 출력

// [입력]
// 첫 줄에 공백을 기준으로 A배열의 크기 N과 X가 주어진다.
// 둘째줄에 공백을 기준으로 수열의 첫번째 원소부터 차례로 주어진다.
// N과 X 그리고 수열의 각 원소는 10000보다 작거나 같은 자연수다.

// [출력]
// X보다 큰 자연수를 공백을 기준으로 출력
// 언급한 예외사항을 제외한 어떠한 예외사항도 고려하지 않는다.

const fs = require('fs');
const input = fs.readFileSync('input.txt').toString().split("\n");

// 배열크기 N, 정수X
const [N,X] = input[0].split(" ");
const arr_size = Number(N); const find_num = Number(X);

// 배열A
for(let i = 0; i<arr_size; i++) {
    var input_arr = input[1].split(" ").map((item)=> +item);
}

input_arr.push(find_num); // 주어진 배열A에 정수X를 삽입
const result = selection_sort(input_arr); // 오름차순 정렬
console.log(binary_search(result,0,arr_size,find_num)); // 출력

// 이진탐색
function binary_search(arr,start,end,key){
    while(start<=end){
        var mid = Math.floor((start+end)/2); // 나누기 몫은 정수로 반환

        if(arr[mid]==key){
            break;
        }
        else if (arr[mid]<key){
            start = mid+1;
        }
        else{
            end = mid-1;
        }
    }

    let res = '';
    for(let k=mid; k<=arr_size; k++){
        if (arr[k]!=key)
        res += arr[k]+' ';
    }

    // X보다 큰 수 가 없을 경우 예외 처리
    if(res==''){
        console.log("error");
    }

    return res;
}

// 선택 정렬
function selection_sort(arr){
    let minIndex, temp;
    for(let i=0; i<arr_size; i++){
        minIndex = i // 초기 최솟값 설정
        for (let j=i+1; j<=arr_size; j++){
            if(arr[j]<arr[minIndex]){
                minIndex = j; // 최솟값 갱신
            }
        }
        temp = arr[minIndex];
        arr[minIndex] = arr[i];
        arr[i] = temp; // swap(arr[minIndex],arr[i])
    }
    return arr;
}
