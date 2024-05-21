function solution(dartResult) {
  var answer = 0;
  let scoreArr = [0, 0, 0];
  //문자 하나씩 보기
  let flag = 0;
  let isOne = -1;
  dartResult.split("").forEach((s) => {
    //숫자인경우
    if (!isNaN(s)) {
      //10인경우
      if (Number(s) === 0 && isOne === 1) {
        scoreArr[flag - 1] = 10;
        return;
      }
      scoreArr[flag] = +s;
      flag++; // 0 => 1 , 1=>2 , 2=>3
      if (Number(s) === 1) {
        isOne = 1;
      }
      return;
    }
    isOne = -1;
    //문자인경우
    if (s === "S") {
      return;
    } else if (s === "D") {
      scoreArr[flag - 1] = Math.pow(scoreArr[flag - 1], 2);
      return;
    } else if (s === "T") {
      scoreArr[flag - 1] = Math.pow(scoreArr[flag - 1], 3);
      return;
    }
    //보너스 옵션인경우
    if (s === "*") {
      scoreArr[flag - 1] = scoreArr[flag - 1] * 2;
      if (flag - 2 >= 0) {
        scoreArr[flag - 2] = scoreArr[flag - 2] * 2;
      }
      return;
    } else if (s === "#") {
      scoreArr[flag - 1] = -scoreArr[flag - 1];
      return;
    }
  });
  return scoreArr[0] + scoreArr[1] + scoreArr[2];
}
solution("1S2D*3T");
