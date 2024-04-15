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

const [n, input] = fs
  .readFileSync("./dummy/input_11053.txt")
  .toString()
  .trim()
  .split("\n");
const inputArr: number[] = input.split(" ").map((v) => Number(v));

function solution() {
  const arrLen = Number(n);
  const dp: number[] = Array(arrLen).fill(1); //dp[i] =  i번째 수열까지 있다할때, 수열의 최대길이
  for (let i = 1; i < arrLen; i++) {
    for (let j = 0; j < i; j++) {
      if (Number(inputArr[i]) > Number(inputArr[j])) {
        dp[i] = Math.max(dp[i], dp[j] + 1);
      }
    }
  }
  console.log(Math.max(...dp));
}
solution();
