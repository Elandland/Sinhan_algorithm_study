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

const inputs = fs
  .readFileSync("./dummy/input_2578.txt")
  .toString()
  .trim()
  .split("\n"); //[ "1 2 3 4 5", "6 7 8 9 10" ...]

function solution() {
  const MAX = 3;
  let bingoCnt = 0; //MAX값이 되면 빙고!
  let bingo: string[][] = inputs.slice(0, 5).map((str) => str.split(" "));
  let call: string[][] = inputs.slice(5, 10).map((str) => str.split(" "));
  //세로, 가로 배열은 0~4, 를 갖고 cnt가 5가 되면 bingoCnt가 올라간다. 대각선은 leftToRight = x,y가 같을때 +1  RightToLeft = x+y =4면  +1
  let lineCol = Array(5).fill(0);
  let lineRow = Array(5).fill(0);
  let leftToRight = 0;
  let rightToLeft = 0;

  //사회자가 숫자를 부릅니다.
  let cnt = 0;
  for (let i = 0; i < 5; i++) {
    for (let j = 0; j < 5; j++) {
      cnt++;
      let calledNum = call[i][j];
      //빙고판에서 해당 숫자를찾고 해당숫자의
      checkNum(calledNum);
      if (isBingo()) return cnt;
    }
  }
  //부른 숫자를 체킹해서 각 빙고를위한 라인 카운트를 더해준다.
  function checkNum(num: string) {
    //col , row
    let row;
    let col = bingo.findIndex((v) => {
      let idx = v.findIndex((f) => f === num);
      if (idx !== -1) {
        row = idx;
        return true;
      } else return false;
    });
    lineCol[col]++;
    lineRow[row]++;
    if (col + row === 4) rightToLeft++;
    if (col === row) leftToRight++;
  }
  //줄긋기 여부 체크하고 줄그으면 값 리셋
  function isBingo() {
    if (leftToRight === 5) {
      bingoCnt++;
      leftToRight = 0;
    }
    if (rightToLeft === 5) {
      bingoCnt++;
      rightToLeft = 0;
    }
    lineCol = lineCol.map((v) => {
      if (v === 5) {
        bingoCnt++;
        return 0;
      }
      return v;
    });
    lineRow = lineRow.map((v) => {
      if (v === 5) {
        bingoCnt++;
        return 0;
      }
      return v;
    });
    if (bingoCnt >= 3) return true;
    return false;
  }
}

console.log(solution());
