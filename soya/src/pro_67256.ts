function solution(numbers, hand) {
  var answer = ""; // 1,4,7 => L 3,6,9 => R , 2,5,8,0 =>L,R
  let positionL = 10;
  let positionR = 12;
  numbers.forEach(n => {
    if (n == 1 || n == 4 || n == 7) {
      answer += "L";
      positionL = n;
      return;
    }
    if (n == 3 || n == 6 || n == 9) {
      answer += "R";
      positionR = n;
      return;
    }
    let disL = distance(n === 0 ? 11 : n, positionL === 0 ? 11 : positionL);
    let disR = distance(n === 0 ? 11 : n, positionR === 0 ? 11 : positionR);
    if (disL === disR) {
      answer += hand.slice(0, 1).toUpperCase();
      if (hand === "right") {
        positionR = n;
      } else {
        positionL = n;
      }
    } else if (disL > disR) {
      answer += "R";
      positionR = n;
    } else if (disL < disR) {
      answer += "L";
      positionL = n;
    }
  });
  //n : 도착지점, position: 출발지점
  //position to n 거리가 얼만큼인지 리턴해줌
  function distance(n, position) {
    let start = position;
    let cnt = 0;
    if (start % 3 === 1) {
      start += 1;
      cnt += 1;
    }
    if (start % 3 === 0) {
      start -= 1;
      cnt += 1;
    }

    cnt = cnt + Math.abs(start - n) / 3;
    return cnt;
  }

  return answer;
}
