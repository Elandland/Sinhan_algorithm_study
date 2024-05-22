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
  .readFileSync("./dummy/input_14916.txt")
  .toString()
  .trim()
  .split(" ");

function solution() {
  let n = Number(input[0]); //1~N
  let m = Number(input[1]); //M 개
  let arr = [];
  function recursion(dept) {
    if (dept >= m) {
      console.log(arr.toString().replace(/,/g, " "));
      return;
    }
    for (var i = 1; i <= n; i++) {
      arr.push(i); //넣고
      recursion(dept + 1);
      arr.pop(); //빼기
    }
  }
  recursion(0);
}
solution();
