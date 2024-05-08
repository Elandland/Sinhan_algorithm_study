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
  .readFileSync("./dummy/input_14888.txt")
  .toString()
  .trim()
  .split("\n");
// 첫째 줄에 수의 개수 N(2 ≤ N ≤ 11)가 주어진다.
// 둘째 줄에는 A1, A2, ..., AN이 주어진다. (1 ≤ Ai ≤ 100)
// 셋째 줄에는 합이 N-1인 4개의 정수가 주어지는데, 차례대로 덧셈(+)의 개수, 뺄셈(-)의 개수, 곱셈(×)의 개수, 나눗셈(÷)의 개수이다.
//res: 최댓값, 최솟값
function solution() {
  let N = Number(input[0]);
  let nums = input[1].split(" ").map(Number);
  let cal = input[2].split(" ").map(Number); // +,-,x,% 갯수
  let calArr = [];
  let ans: number[] = [];
  for (let i = 0; i < 4; i++) {
    let cnt = cal[i];
    for (let j = 0; j < cnt; j++) {
      if (i === 0) calArr.push("+");
      if (i === 1) calArr.push("-");
      if (i === 2) calArr.push("*");
      if (i === 3) calArr.push("%");
    }
  }
  let visited: boolean[] = new Array(calArr.length).fill(false);
  dfs(1, nums[0]);

  console.log(Math.max(...ans));
  console.log(Math.min(...ans));
  function dfs(n: number, sum: number) {
    if (n === N) {
      ans.push(sum);
      return;
    }
    for (let i = 0; i < calArr.length; i++) {
      if (!visited[i]) {
        visited[i] = true;
        if (calArr[i] === "+") dfs(n + 1, sum + nums[n]);
        if (calArr[i] === "-") dfs(n + 1, sum - nums[n]);
        if (calArr[i] === "*") dfs(n + 1, sum * nums[n]);
        if (calArr[i] === "%")
          dfs(
            n + 1,
            sum / nums[n] > 0
              ? Math.floor(sum / nums[n])
              : Math.ceil(sum / nums[n])
          );
        visited[i] = false;
      }
    }
  }
}

solution();
