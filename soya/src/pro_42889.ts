function solution(N, stages) {
  let answer = new Array(N + 1).fill([0, 0]);
  //실패율 = 스테이지 진행중인유저 / 스테이지도달한유저(깬유저) 유저스테이지 > 보는 스테이지
  // N =전체 스테이지 갯수, stages = 유저들이 도달한 위치
  // 분모가 0 이면 1
  //내림차순으로 서칭
  stages.sort((a, b) => b - a);
  for (let i = 1; i <= N; i++) {
    let denominator = 0; //분모
    let numerator = 0; //분자
    for (let s of stages) {
      if (s === i) {
        numerator++;
        denominator++;
      } else if (s > i) {
        denominator++;
      } else if (s < i) {
        break;
      }
    }
    if (denominator === 0) {
      answer[i] = [i, 0];
      continue;
    }
    answer[i] = [i, numerator / denominator];
  }
  let ans = answer.slice(1, N + 1);
  // console.log(ans);
  ans.sort((a, b) => b[1] - a[1]);
  let result = ans.map((e) => e[0]);
  return result;
}
const N = 5;
const stages = [2, 1, 2, 6, 2, 4, 3, 3];
