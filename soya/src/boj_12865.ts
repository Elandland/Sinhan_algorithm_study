import * as fs from "fs";

const input = fs
  .readFileSync("./dummy/input_12865.txt")
  .toString()
  .trim()
  .split("\n");

function solution() {
  // N K
  // W V * N
  const N = Number(input[0].split(" ")[0]);
  const K = Number(input[0].split(" ")[1]);
  const items = [];
  items[0] = "0 0";
  for (let i = 1; i <= N; i++) {
    items[i] = input[i];
  }
  let dp: number[][] = Array.from(Array(N + 1), () => new Array(K + 1));

  for (let i = 0; i <= N; i++) {
    for (let j = 0; j <= K; j++) {
      dp[i][j] = 0;
    }
  }

  for (let i = 1; i <= N; i++) {
    let item = items[i].split(" "); //꺼내서 각 사이즈 일때 별로 들어가나 dp에 저장 0:무개, 1:가치
    for (let j = 1; j <= K; j++) {
      if (j - Number(item[0]) >= 0) {
        //넣기
        //전의 물건 들어가있는거랑, 그건 빼고, 남은공간(내무게 뺀공간)에 들어가는거 + 내거 넣기
        dp[i][j] = Math.max(
          dp[i - 1][j - Number(item[0])] + Number(item[1]),
          dp[i - 1][j]
        );
      } else {
        // 못넣음
        dp[i][j] = dp[i - 1][j];
      }
    }
  }
  console.log(dp[N][K]);
}

solution();
