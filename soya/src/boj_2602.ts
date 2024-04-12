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

const [n, m, ...inputArr] = fs
  .readFileSync("../dummy/input_2602.txt")
  .toString()
  .trim()
  .split("\n");

let ans = 0;
function solution() {
  const computer_cnt: number = Number(n);

  const graph: number[][] = Array.from(
    Array(computer_cnt + 1),
    () => new Array()
  );
  const visited: boolean[] = new Array(computer_cnt + 1);
  inputArr.forEach((v) => {
    const line: string[] = v.split(" "); // 2 3
    graph[Number(line[0])].push(Number(line[1]));
    graph[Number(line[1])].push(Number(line[0]));
  });

  //1번 컴퓨터 방문처리
  visited[1] = true;
  dfs(1, graph, visited);
  console.log(ans);
}
//현재 노드, 현재노드와 연결된 것들
function dfs(cur: number, graph: number[][], visited: boolean[]) {
  const arr = graph[cur];
  for (let i in arr) {
    if (visited[arr[i]] === true) continue;
    visited[arr[i]] = true;
    ans++;
    dfs(arr[i], graph, visited);
  }
}

solution();
