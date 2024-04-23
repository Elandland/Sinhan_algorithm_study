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
const [n, ...inputArr] = fs
  .readFileSync("./dummy/input_2579.txt")
  .toString()
  .trim()
  .split("\n");

function solution() {
  let stairNum = Number(n);
  let dp: number[][] = Array.from(Array(stairNum), () => new Array());
  // 계단이 한개일때
  if (stairNum == 1) return inputArr[0];
  console.log(inputArr);
  // [i][0] -> i번째 계단을 처음 밟음. [i][1] -> i번째 계단이 두번째로 연속해 밟은 계단
  dp[0][0] = Number(inputArr[0]);
  dp[0][1] = 0;
  dp[1][0] = Number(inputArr[1]);
  dp[1][1] = Number(inputArr[0] + inputArr[1]);
  for (let i = 2; i < stairNum; i++) {
    //첫번째로 밟는 계단일 경우 값 저장
    dp[i][0] = Math.max(dp[i - 2][0], dp[i - 2][1]) + Number(inputArr[i]);
    //두번째로 밟는 계단일 경우 값 저장
    dp[i][1] = dp[i - 1][0] + Number(inputArr[i]);
  }
  return Math.max(dp[stairNum - 1][0], dp[stairNum - 1][1]);
}

console.log(solution());
