function solution(k, dungeons) {
  // a:최소 피로도, b:소모 피로도
  let answer = -1;
  let visited = new Array(dungeons.length).fill(false);

  function checkAll(remain, count) {
    //remain: 남은 피로도
    if (count >= dungeons.length) {
      answer = count > answer ? count : answer;
      return;
    }
    for (let i = 0; i < dungeons.length; i++) {
      let dungeon = dungeons[i];
      //방문한적없음 && 피로도 방문 가능
      if (!visited[i] && remain >= dungeon[0]) {
        visited[i] = true;
        checkAll(remain - dungeon[1], count + 1);
        visited[i] = false;
      }
    }
    answer = count > answer ? count : answer;
  }
  checkAll(k, 0);

  return answer;
}
