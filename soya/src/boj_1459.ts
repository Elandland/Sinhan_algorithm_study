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

const input = fs
  .readFileSync("./dummy/input_1459.txt")
  .toString()
  .trim()
  .split(" ");

function solution() {
  let x = Number(input[0]);
  let y = Number(input[1]);
  let w = Number(input[2]); // 한 블록
  let s = Number(input[3]); // 대각선
  let ans = 0;
  if (w * 2 < s) {
    // 그냥 도로로 가는게 이득
    ans = (x + y) * w;
  } else {
    // 대각선으로 이동하는게 이득
    //짝수칸은 s로 가는게 이득, 홀수일땐 w
    let diff = Math.abs(x - y);
    let cross = (x > y ? y : x) * s; //가로질러 가는 시간
    if (w > s) {
      //그냥 line이동도 대각선으로 가는게 나은 경우
      let line = (diff % 2) * w + (diff - (diff % 2)) * s;
      ans = line + cross;
    } else {
      //(1,1)은 대각선으로이동, (0,1) (1,0)은 도보 이동
      ans = diff * w + cross;
    }
  }
  console.log(ans);
}

solution();
