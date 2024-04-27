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

// 나무수, 원하는 나무길이, 나무들
// n m
// 2 3 4 5
const [n, input] = fs
  .readFileSync("./dummy/input_2805.txt")
  .toString()
  .trim()
  .split("\n");
const m = n.trim().split(" ")[1];
const inputArr = input.trim().split(" ").map(Number);

function solution() {
  const need: number = Number(m);
  let max: number = inputArr.reduce((acc, cur) => Math.max(acc, cur), 0);
  let min: number = 0;
  let ans: number = max; //초기값을 최대길이로 설정
  while (min <= max) {
    let total_tree_len = 0;
    let pivot = Math.floor((min + max) / 2);
    for (let tree of inputArr) {
      if (tree > pivot) {
        total_tree_len += tree - pivot;
      }
    }
    if (total_tree_len == need) {
      ans = pivot;
      break;
    }
    if (total_tree_len < need) {
      // 조건 미충족시 max를 내린다.
      max = pivot - 1;
    } else {
      //충족시 h를 좀 올려본다.
      ans = ans > pivot ? ans : pivot;
      min = pivot + 1;
    }
  }
  return ans;
}

console.log(solution());
