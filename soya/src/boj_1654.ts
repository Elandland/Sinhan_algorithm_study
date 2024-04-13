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

const [first_line, ...inputArr] = fs
  .readFileSync("./dummy/input_1654.txt")
  .toString()
  .trim()
  .split("\n");

let ans = 0;
function solution() {
  const k: number = Number(first_line.split(" ")[0]); // 랜선 개수
  const n: number = Number(first_line.split(" ")[1]); // 필요한 랜선 수
  const arr: number[] = inputArr.map(Number); // 랜선들 배열
  const total_len: number = arr.reduce((acc, cur) => acc + Number(cur), 0);
  let rightLen = Math.floor(total_len / n);
  let leftLen = 1;
  while (leftLen <= rightLen) {
    let cnt = 0;
    let mid = Math.floor((leftLen + rightLen) / 2);
    for (let i in arr) {
      let cutting_line_cnt = Math.floor(arr[i] / mid);
      cnt += cutting_line_cnt;
    }
    if (cnt >= n) {
      //조건 충족
      ans = mid;
      leftLen = mid + 1;
    } else {
      // 조건 미충족
      rightLen = mid - 1;
    }
  }

  console.log(ans);
}

solution();
