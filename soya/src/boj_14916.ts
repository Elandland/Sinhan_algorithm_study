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

const input = fs.readFileSync("./dummy/input_14916.txt").toString().trim();

function solution() {
  const n = Number(input);
  let five_c = 0;
  let two_c = 0;
  // n이 5보다 작을경우는 2원동전만 주거나, 거슬러줄 수 없다.
  if (n < 5) {
    if (n % 2 == 0) {
      return n / 2;
    }
    return -1;
  }
  //여기서부터는 n이 5보다 큰 경우
  five_c = Math.floor(n / 5);
  //5원을 거슬러주고 남은 돈
  const remain_n = n % 5;

  // 2*3 = 6
  if (remain_n == 1) {
    five_c -= 1;
    two_c = 3;
  } else if (remain_n == 2) {
    two_c = 1;
  } else if (remain_n == 3) {
    //2*4 = 8
    five_c -= 1;
    two_c = 4;
  } else if (remain_n == 4) {
    two_c = 2;
  }
  return five_c + two_c;
}

console.log(solution());
