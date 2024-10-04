import * as fs from "fs";
//1. 입력값이 한개
// const input = fs.readFileSync("/dev/stdin").toString().trim();
//2. 입력값이 여러개
// const input = fs.readFileSync("/dev/stdin").toString().trim().split(" ");
//3. 입력값이 여러줄
// const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
//4. 입력값이 첫 번째 줄에는 입력 값의 길이(n), 두 번째 줄에 공백으로 구분된 입력값이 주어질 때
// const [n, input] = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
// const inputArr = input.trim().split(" ")
// 5. 입력값이 첫 번째 줄에는 입력 값의 길이(n), n개의 줄에 걸쳐서 한 줄에 하나의 입력값이 주어질 때
// const [n, ...input] = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const [n, ...input] = fs
  .readFileSync("./dummy/input_14501.txt")
  .toString()
  .trim()
  .split("\n");

function solution(): Number {
  let arrT = [];
  let arrP = [];
  let N: number = +n;
  for (let values of input) {
    let valueList = values.split(" ");
    arrT.push(+valueList[0]);
    arrP.push(+valueList[1]);
  }
  let memo = Array(N + 1).fill(0);
  //뒤집어서 1일남았을때 부터 ->  N일남았을때.. 로 조회
  arrT.push(0);
  arrP.push(0);
  arrT.reverse();
  arrP.reverse();

  for (let i = 1; i <= N; i++) {
    //i는 남은날
    //걸리는날이 남은날보다 작거나 같으면
    if (arrT[i] <= i) {
      memo[i] = Math.max(memo[i - arrT[i]] + arrP[i], memo[i - 1]); //그 일정을 잡는경우(일정잡고 여유 일정의 최대값과 더함)랑 안잡는 경우를 비교해서 저장
    } else {
      memo[i] = memo[i - 1];
    }
  }
  return memo[N];
}

console.log(solution());
