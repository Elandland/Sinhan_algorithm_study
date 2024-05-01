import * as fs from "fs";
import { setTimeout } from "timers/promises";
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
/**
 * 도도는 주방장이다. 총 K개의 요리가 준비되는 최소 시간을 구해야 한다.
각각의 요리사는 자신만의 음식 조리 시간이 있다. 음식 조리 시간은 음식 하나를 만들 때 걸리는 시간이다.
도도는 요리사에게 격려를 해줄 수 있다. 격려받은 요리사는 영구적으로 음식 조리 시간이 1초 감소한다.
도도는 한 요리사에게 여러 번 격려할 수 있고, 요리사의 음식 조리 시간을 1초 미만으로 줄일 수는 없다.
도도를 위해 요리에 걸리는 최소 시간을 출력하는 프로그램을 만들어 보자.
 */
// 요리사 수 . 음식의 수 . 격려할수있는 수
const [first_line, inputN] = fs
  .readFileSync("./dummy/input_22953.txt")
  .toString()
  .trim()
  .split("\n");
const [N, K, C] = first_line.split(" "); // 요리사 수, 요리 수, 격려 횟수
let foodCnt = Number(K);
let cookerCnt = Number(N);
let totalEncCnt = Number(C); //격려타임

function solution() {
  let cookers = inputN.split(" ").map(Number); // 요리사의 음식
  let ans = foodCnt * cookers[0];
  // second를 돌면서 k가 되면 완료 .
  encCooker(0, cookers, ans);
}

function incTime(ans, cookers) {
  let secTime = 0;
  while (ans > secTime) {
    secTime++;
    let madeFood = 0;
    for (let i in cookers) {
      console.log(
        `${i}번째 요리사는 ${Math.floor(
          secTime / cookers[i]
        )} 만큼 생성해요. ${secTime}`
      );
      madeFood += Math.floor(secTime / cookers[i]);
    }
    if (madeFood >= foodCnt) break;
  }
  return secTime;
}

function encCooker(encCnt, cookers, ans) {
  if (encCnt == totalEncCnt) {
    let res = incTime(ans, cookers);
    if (res < ans) ans = res;
    return;
  }
  for (let i = 0; i++; i < cookerCnt) {
    if (cookers[i] - 1 > 0) {
      cookers[i]--;
      encCooker(encCnt + 1, cookers, ans);
      cookers[i]++;
    }
  }
}
solution();
