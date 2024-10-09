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

const input = fs.readFileSync("./dummy/input_20310.txt").toString().trim();

function solution() {
  let inputArr = input.split("");
  let zeroCnt = 0;
  let oneCnt = 0;
  inputArr.forEach((v) => {
    if (v === "1") oneCnt++;
    if (v === "0") zeroCnt++;
  });

  zeroCnt = zeroCnt / 2;
  oneCnt = oneCnt / 2;
  let len = inputArr.length;
  //0은 뒤에서부터 절반
  //1은 앞에서부터 절반 지워야함
  for (let i = 0; i < len; i++) {
    if (zeroCnt === 0 && oneCnt === 0) break; //다 제거함
    if (oneCnt > 0 && inputArr[i] === "1") {
      oneCnt--;
      inputArr[i] = "";
    }
    if (zeroCnt > 0 && inputArr[len - 1 - i] === "0") {
      zeroCnt--;
      inputArr[len - 1 - i] = "";
    }
  }

  //다시 문자열로만들어서 보내기
  return inputArr.join("");
}

console.log(solution());
