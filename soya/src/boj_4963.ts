import * as fs from "fs";

const input = fs
  .readFileSync("./dummy/input_4963.txt")
  .toString()
  .trim()
  .split("\n");

function solution() {
  // W H
  // H줄 만큼 섬 정보 1: 땅, 0:바다
  //섬 개수 출력
  let landInfo = input.shift();
  while (landInfo !== "0 0") {
    let W: number = Number(landInfo.split(" ")[0]);
    let H: number = Number(landInfo.split(" ")[1]);

    //섬 배열 받고 bfs돌리기
    let visitArr: boolean[][] = Array.from(Array(H), () => new Array());
    let landMap: number[][] = Array.from(Array(H), () => new Array());
    for (let i = 0; i < H; i++) {
      landMap[i] = input.shift().split(" ").map(Number);
      visitArr[i] = Array(W).fill(false);
    }
    // 섬 bfs돌리고 나온 섬 개수 찍기.
    getLandNum(W, H, visitArr, landMap);
    landInfo = input.shift();
  }
}
interface IPosition {
  w: number;
  h: number;
}
function getLandNum(
  W: number,
  H: number,
  visitArr: boolean[][],
  landMap: number[][]
) {
  let landCnt = 0;
  let stack: IPosition[] = [];
  for (let i = 0; i < H; i++) {
    for (let j = 0; j < W; j++) {
      if (!visitArr[i][j] && landMap[i][j] === 1) {
        stack.push({ w: j, h: i });
        visitArr[i][j] = true;
        bfs();
        landCnt++;
      }
    }
  }
  function bfs() {
    let dh: number[] = [0, 0, 1, 1, 1, -1, -1, -1];
    let dw: number[] = [1, -1, 0, 1, -1, 0, 1, -1];
    while (stack.length > 0) {
      let startP = stack.pop();
      for (let i = 0; i < dh.length; i++) {
        let ndh = startP.h + dh[i];
        let ndw = startP.w + dw[i];
        if (
          ndw >= 0 &&
          ndh >= 0 &&
          ndh < H &&
          ndw < W &&
          !visitArr[ndh][ndw] &&
          landMap[ndh][ndw] === 1
        ) {
          visitArr[ndh][ndw] = true;
          stack.push({ w: ndw, h: ndh });
        }
      }
    }
  }

  console.log(landCnt);
}
solution();
