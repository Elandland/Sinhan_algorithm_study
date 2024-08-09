function solution(land) {
  let answer = 0;
  let n = land.length; // 세로
  let m = land[0].length;
  let oilInfo = [0, 0]; // [position] = 오일사이즈
  let nPosition = 2;
  let amount = 0;

  // oilMap에 석유덩어리를 세팅
  for (let i = 0; i < n; i++) {
    for (let j = 0; j < m; j++) {
      if (land[i][j] == 1) {
        DFS(i, j);
        oilInfo[nPosition] = amount; // 번호에 오일량 저장
        nPosition++;
        amount = 0;
      }
    }
  }

  for (let i = 0; i < m; i++) {
    let mHash = new Set<number>();
    let total = 0;
    for (let j = 0; j < n; j++) {
      //시추 뚫면서 oilMap에 나온값 해시에 저장
      if (land[j][i] !== 0 && !mHash.has(land[j][i])) {
        mHash.add(land[j][i]);
        total += oilInfo[land[j][i]];
      }
    }
    answer = Math.max(total, answer);
  }

  function DFS(x, y) {
    let curX = x;
    let curY = y;

    land[curX][curY] = nPosition;
    amount++;
    let xdir = [0, -1, 0, 1];
    let ydir = [1, 0, -1, 0];

    for (let i = 0; i < 4; i++) {
      let nextX = xdir[i] + curX;
      let nextY = ydir[i] + curY;
      if (
        nextX >= 0 &&
        nextX < n &&
        nextY >= 0 &&
        nextY < m &&
        land[nextX][nextY] == 1
      ) {
        DFS(nextX, nextY);
      }
    }
  }

  return answer;
}

let land = [
  [1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1],
];
const ans = solution(land);
console.log(ans);
