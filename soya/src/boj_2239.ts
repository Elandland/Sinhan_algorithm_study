import * as fs from "fs";

const input = fs
  .readFileSync("./dummy/input_2239.txt")
  .toString()
  .trim()
  .split("\n");
const sudoku: number[][] = input.map((v) => Array.from(v).map(Number));

function solution() {
  let ans: number[][] = [...sudoku];
  let sudoMemo: number[][][] = Array.from(Array(9), () => Array(9).fill([]));
  //1. 가능성이 하나인곳은 답지를 적는다.
  findEmpty(sudoMemo, ans);
  //2. 앞쪽의 0인값에 정답이 될 수 있는 경우의 수를 돌려본다.
  let testAns = [...ans];
  const answer = findAnswer(sudoMemo, testAns);

  // let arrToText = answer.map((v) => v.toString().replace(/,/g, ""));
  // arrToText.forEach((v) => console.log(v));
}

function findEmpty(memo: number[][][], ans: number[][]) {
  //0인곳을 찾아 메모하기.
  for (let i = 0; i < 9; i++) {
    for (let j = 0; j < 9; j++) {
      if (ans[i][j] == 0) {
        const res = check(i, j, memo, ans);
        if (res.isRight == false) return false;
        if (res.isUpdate) {
          findEmpty(memo, ans); // 답지를 적었으면 바로 한번더 새로 체킹해야함.
        }
      }
    }
  }
  return true;
}
// 행,렬, 블럭단위 체크해서 메모에 사용 가능한 숫자를 적거나, 한개일경우 정답지에 적는다.
// 메모하거나 정답인게 있으면 true를, 막혔으면 false를 리턴한다.
function check(
  x: number, //i
  y: number, //j
  memo: number[][][],
  ans: number[][]
): { isRight: boolean; isUpdate: boolean } {
  // 1~ 9 방문체크: 이미 있는 숫자면 false로 변경
  let writePossible: boolean[] = Array(10).fill(true);
  writePossible[0] = false;
  let curMemo: number[] = [];
  // 행 체크
  for (let i = 0; i < 9; i++) {
    const value = ans[x][i];
    if (value == 0) continue;
    writePossible[value] = false;
  }
  //열 체크
  for (let i = 0; i < 9; i++) {
    const value = ans[i][y];
    if (value == 0) continue;
    writePossible[value] = false;
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
      writePossible[value] = false;
    }
  }

  for (let i = 1; i <= 9; i++) {
    if (writePossible[i] == true) {
      curMemo.push(i);
    }
  }
  if (curMemo.length == 0) {
    return { isRight: false, isUpdate: false };
  }
  // 답지 업데이트!
  if (curMemo.length == 1) {
    const memoingNumber = curMemo.pop();
    ans[x][y] = memoingNumber;
    return { isRight: true, isUpdate: true };
  }
  // 메모 덮어쓰기

  if (curMemo.length > 1) {
    // console.log(`${x},${y} mem: `, curMemo);
    memo[x][y] = [...curMemo];
    return { isRight: true, isUpdate: false };
  }
}

function findAnswer(curMemo: number[][][], curAns: number[][]): boolean {
  console.log(
    curAns
      .map((v) => v.toString().replace(/,/g, ""))
      .forEach((v) => console.log(v))
  );
  if (![...curAns].toString().includes("0")) {
    console.log("ans", curAns);
    return true;
  }

  for (let i = 0; i < 9; i++) {
    for (let j = 0; j < 9; j++) {
      if (curAns[i][j] == 0) {
        for (let k in curMemo[i][j]) {
          //꺼내서 넣기 아 여기서 넣을때 이미 중복으로 채워넣은걸 확인안하고 넣는구나.
          const backup = [...curAns.map((row) => [...row])];
          const backupmemo = curMemo.map((row) => [...row]);
          curAns[i][j] = curMemo[i][j][k];
          // 값을 하나 채워 답지를 새로 작성해본다.
          if (findEmpty(curMemo, curAns)) {
            findAnswer(curMemo, curAns);
          } else {
            continue;
          }
          if (![...curAns].toString().includes("0")) {
            console.log("ans", curAns);
            return true;
          }
          // let result = findAnswer(curMemo, curAns);
          // if (result) return result; // 정상적인 반환값이 있으면 반환

          //답지를 지워야함.
          curAns = backup;
          curMemo = backupmemo;
        }
      }
      return false;
    }
  }
}

solution();
