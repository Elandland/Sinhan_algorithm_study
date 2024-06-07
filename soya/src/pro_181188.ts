function solution(targets) {
  let answer = 0;
  targets.sort((a, b) => a[0] - b[0]); //오름차순 정렬
  let curS = targets[0][0];
  let curE = targets[0][1]; //작은걸로 유지

  for (let i of targets) {
    let s = i[0];
    let e = i[1];
    //s 가 변화가 없는 경우
    if (curS === s && curE <= e) continue;
    if (curS === s && curE > e) {
      curE = e;
      continue;
    }
    //s 가 변화하는경우
    curS = s;
    if (curE <= curS) {
      answer++; // 앞에 애들 요격시키기.
      curE = e;
      continue;
    }
    if (curE > e) {
      curE = e;
    }
  }
  answer++;
  return answer;
}
let targets = [
  [4, 5],
  [4, 8],
  [10, 14],
  [11, 13],
  [5, 12],
  [3, 7],
  [1, 4],
];

console.log(solution(targets));
