import * as fs from "fs";

// 토마토가 익는 최소 일 수 구하기 1: 익은토마토 0:안익은 토마토 -1 : 빈칸
const [first_line, ...inputArr] = fs
  .readFileSync("./dummy/input_7576.txt")
  .toString()
  .trim()
  .split("\n");
const [col, row] = first_line.split(" ").map(Number);
const tomatoBox: Number[][] = inputArr.map((line) =>
  line.split(" ").map(Number)
);
interface place {
  r: number;
  c: number;
}
function solution() {
  //1. 익은토마토를 찾아서 que에 넣는다.
  //2. que에 있는걸 싹다 빼서 너비탐색.(+1)
  //3. 익힌 토마토는 que에 또 넣는다.
  //4. 2-3 반복하며 더이상 que에 넣을 수 없으면 종료. 시간출력
  //모두 익을 수 없으면 -1, 저장 시 부터 모두 익어있으면 0
  const que: place[] = [];
  let dayCnt = 0;
  for (let i = 0; i < row; i++) {
    for (let j = 0; j < col; j++) {
      if (tomatoBox[i][j] === 1) {
        que.push({ r: i, c: j });
      }
    }
  }
  while (que.length > 0) {
    //해당 날에 익힌토마토가 없으면 종료.
    if (!bfs(que)) {
      break;
    }
    //익힌토마토가 있다면 날짜를 증가시키고 다시 새로익힌토마토들로 탐색(while)
    dayCnt++;
  }
  //모두 익지 않았다면 -1
  if (tomatoBox.toString().includes("0")) {
    dayCnt = -1;
  }
  console.log(dayCnt);
}

//들어온 값의 사방을 조회해서 토마토를 익히고, que에 넣는다.
function bfs(que: place[]): boolean {
  // 오,아,왼,위
  let searchRow = [0, -1, 0, 1];
  let searchCol = [1, 0, -1, 0];
  let changeTomato = false;
  const newGoodTomatoes: place[] = [];
  while (que.length > 0) {
    let tplace = que.pop();
    for (let i = 0; i < 4; i++) {
      let x = tplace.r + searchRow[i];
      let y = tplace.c + searchCol[i];
      if (x >= 0 && x < row && y >= 0 && y < col && tomatoBox[x][y] == 0) {
        tomatoBox[x][y] = 1;
        newGoodTomatoes.push({ r: x, c: y });
        changeTomato = true;
      }
    }
  }
  //새로 익은 토마토들 que에 넣기
  que.push(...newGoodTomatoes);
  //익힌 토마토가 없으면 false
  return changeTomato;
}

solution();
