import * as fs from "fs";

const input = fs
  .readFileSync("./dummy/input_2239.txt")
  .toString()
  .trim()
  .split("\n");
const sudoku: number[][] = input.map((v) => Array.from(v).map(Number));

function solution() {
  let ans: number[][] = [...sudoku];

  const answer = solve(ans);
  let arrToText = ans.map((v) => v.toString().replace(/,/g, ""));
  arrToText.forEach((v) => console.log(v));
}
// 되는지 안되는지 확인
function check(
  x: number, //i
  y: number, //j
  ans,
  num
): boolean {
  // 행 체크
  for (let i = 0; i < 9; i++) {
    const value = ans[x][i];
    if (value == num) return false;
  }
  //열 체크
  for (let i = 0; i < 9; i++) {
    const value = ans[i][y];
    if (value == num) return false;
  }

  //블럭 체크 0~2 / 3~5 / 6~8
  const blockX = Math.floor(x / 3); // 0,1,2
  const blockY = Math.floor(y / 3); // 0,1,2
  //blockX * 3 + i , blockY * 3 + i
  for (let i = 0; i < 3; i++) {
    for (let j = 0; j < 3; j++) {
      const bx = blockX * 3 + i;
      const by = blockY * 3 + j;
      const value = ans[bx][by];
      if (value == num) return false;
    }
  }
  return true;
}

function solve(ans: number[][]) {
  for (let i = 0; i < 9; i++) {
    for (let j = 0; j < 9; j++) {
      if (ans[i][j] === 0) {
        for (let num = 1; num <= 9; num++) {
          if (check(i, j, ans, num)) {
            ans[i][j] = num;
            if (solve(ans)) {
              return true;
            }
            ans[i][j] = 0;
          }
        }
        return false;
      }
    }
  }
  return true;
}

solution();
