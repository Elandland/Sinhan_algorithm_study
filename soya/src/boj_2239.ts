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
  .readFileSync("./dummy/input_2239.txt")
  .toString()
  .trim()
  .split("\n");
const sudoku: number[][] = input.map((v) => Array.from(v).map(Number));

function solution() {
  let ans: number[][] = [...sudoku];
  let sudoMemo: number[][][] = Array.from(Array(9), () => Array(9).fill([]));

  checkAndMemo(sudoMemo, ans);
  // let ans = sudoku.map((v) => v.toString().replace(/,/g, ""));
  console.log(ans);
}

function checkAndMemo(memo: number[][][], ans: number[][]) {
  let isUpdate = false;
  //0인곳을 찾아 메모하기.
  for (let i = 0; i < 9; i++) {
    for (let j = 0; j < 9; j++) {
      if (ans[i][j] == 0) {
        check(i, j, memo, ans, isUpdate);
      }
    }
  }
  // 메모 도중 답지 업데이트가 있으면 한번더 메모!
  if (isUpdate) checkAndMemo(memo, ans);
}
// 행,렬, 블럭단위 체크해서 메모에 사용 가능한 숫자를 적거나, 한개일경우 정답지에 적는다.
// 메모하거나 정답인게 있으면 true를, 막혔으면 false를 리턴한다.
function check(
  x: number,
  y: number,
  memo: number[][][],
  ans: number[][],
  isUpdate: boolean
): boolean {
  // 1~ 9 방문체크: 방문시 false
  let possible: boolean[] = Array(10).fill(true);
  possible[0] = false;
  let curMemo: number[] = [];
  // 행 체크
  for (let i = 0; i < 9; i++) {
    const value = ans[x][i];
    if (value == 0) continue;
    possible[value] = false;
  }

  //열 체크
  for (let i = 0; i < 9; i++) {
    const value = ans[i][y];
    if (value == 0) continue;
    possible[value] = false;
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
      if (value == 0) continue;
      possible[value] = false;
    }
  }

  for (let i = 1; i <= 9; i++) {
    if (possible[i] == true) {
      curMemo.push(i);
    }
  }
  // 메모할게 없음 오답인 경우.
  if (curMemo.length == 0) {
    return false;
  }
  // 답지 업데이트!
  if (curMemo.length == 1) {
    isUpdate = true;
    const memoingNumber = curMemo.pop();
    ans[x][y] = memoingNumber;
    return true;
  }
  // 메모 덮어쓰기
  if (curMemo.length > 1) {
    memo[x][y] = [...curMemo];
  }
}

solution();
