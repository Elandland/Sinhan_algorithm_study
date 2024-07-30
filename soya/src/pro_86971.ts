function solution(n, wires) {
  var answer = n;

  //1번 기준으로 갈곳 없을때까지 탐색
  //탐색 종료 후 두 전력망 송전탑 개수 차이 = n - cnt
  function dfs(curT, cuttedWires, cnt, visited) {
    for (let wire of cuttedWires) {
      if (wire[0] === curT && !visited[wire[1]]) {
        visited[wire[1]] = true;
        dfs(wire[1], cuttedWires, cnt + 1, visited);
      }
      if (wire[1] === curT && !visited[wire[0]]) {
        visited[wire[0]] = true;
        dfs(wire[0], cuttedWires, cnt + 1, visited);
      }
    }
  }

  //하나씩 선을 잘라서 탐색
  for (let i = 0; i < wires.length; i++) {
    let cuttedWires = [...wires];
    let visited = new Array(wires.length + 1).fill(false); //1~n
    cuttedWires.splice(i, 1);
    //1번 송전탑 기준으로 연결된 송전탑 탐색
    visited[1] = true;
    dfs(1, cuttedWires, 1, visited);
    //방문체크된 애들 카운트해서 정답 적기
    let count = 0;
    for (let visit of visited) {
      if (visit) count++;
    }
    answer =
      Math.abs(n - 2 * count) < answer ? Math.abs(n - 2 * count) : answer;
  }

  return answer;
}
