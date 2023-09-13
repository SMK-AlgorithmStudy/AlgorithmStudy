// [2번문제] 다항식 클래스를 만들기 위해 다항식 A, B 2개를 입력 받아 식을 출력하고, 두
// 다항식을 곱셈하여 새로운 다항식 C를 출력한 뒤에 임의의 x값을 입력 받아 다항식 C
// 에 x를 대입한 결과값을 출력하시오.

// [조건]
// 입력 받을 다항식의 계수와 지수는 1~10까지의 자연수만 고려함
// 출력 조건을 유심히 볼 것

// [입력]
// 다항식 입력 시 계수, 지수 순서로 입력 받음
// 다항식 A와 B는 각각 enter로 구분해 입력 받음
// 입력 받을 x값은 자연수만 고려함

// [출력]
// A, B, C를 출력한 뒤에 X값을 입력받음
// 다항식의 곱셈 결과식은 차수가 높은 것부터 내림차순으로 표현될 것
// 차수가 같은 항은 하나의 항으로 합쳐서 결과를 출력할 것

const fs = require('fs');
const { type } = require('os');
const input = fs.readFileSync('week1/input2.txt').toString().split("\n").map(item => item.split(" ").map(Number));

// 입력값을 [계수,지수] pair 형태로 변환저장
let aArr = [];
for(let i=0; i<input[0].length; i++){
    if(i%2==0){
        aArr.push([input[0][i],input[0][i+1]]);
    }
}
let bArr = [];
for(let i=0; i<input[1].length; i++){
    if(i%2==0){
        bArr.push([input[1][i],input[1][i+1]]);
    }
}
// x 값
let x_arr;
x_arr = input[2];
x = input[2][0]

let cArr = [];
let cObj = {};

console.log("A:"+print_poly(aArr));
console.log("B:"+print_poly(bArr));
console.log("C:"+print_poly(calculate_poly(aArr,bArr)));
console.log("x = "+x);
console.log(x_calculate(cArr,x));

function calculate_poly(arr1,arr2){
    for(let j=0; j<arr1.length; j++){
        for(let k=0; k<arr2.length; k++){
            
            var key = arr1[j][1]+arr2[k][1]; // 지수
            var new_value = arr1[j][0]*arr2[k][0]; // 계수

            if(Object.keys(cObj).includes(key.toString())) {
                var key = Number(key);
                var value = Number(value);

                value = Number(cObj[key]);
                var update_value = value + new_value;
                cObj[key] = update_value;
            }
            else {
                cObj[key]=new_value;
            }
            cArr = Object.keys(cObj).map((key) => [cObj[key], key]);
            cArr.sort((a,b)=> b[1]-a[1]); // 내림차순 정렬   
        }
    }
    return cArr;
}

function print_poly(arr){
    let poly = '';
    for(let k=0; k<arr.length; k++){
        if(k==0){
            poly = poly.concat(arr[k][0],'x^',arr[k][1]);
        }
        else{
            poly = poly.concat('+',arr[k][0],'x^',arr[k][1]);
        }
    }
    return poly;
}

function x_calculate(arr,x){
    var res=0;
    arr.forEach(it => {
        res += it[0]*x**it[1];
    });
    return res;
}
