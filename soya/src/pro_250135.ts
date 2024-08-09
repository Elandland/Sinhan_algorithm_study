function solution(h1, m1, s1, h2, m2, s2) {
  //00:00:00 ~ h : m : s
  const getMeetCnt = (h, m, s) => {
    let hDegree = (h * 30 + m * 0.5 + (s * 0.5) / 60) % 360;
    let mDegree = (m * 6 + s * 0.1) % 360;
    let sDegree = s * 6;

    let meet = 0;
    if (sDegree >= mDegree) meet += 1; //지났죠?
    if (sDegree >= hDegree) meet += 1; //지났죠?

    meet += (h * 60 + m) * 2; //분당 2번씩 만난다고 계산
    meet -= h; //59분 -> 0분일때는 분침과 만나지 않음. 00 -> 1분일때 만난걸로칠거
    if (h >= 12) meet -= 2; // 11시59분59초 -> 12시인경우 분,초침과 만나지않고 12시에 2번이아닌 1번만 만나는걸로 처리
    //원래 2+ 2 = 4 여야한다면, 분,시,초가 동시에 만났으니 -1 ,
    // 분,시,초가 동시에 만났으니 2가아닌1이됨.
    return meet;
  };

  let meetCnt = getMeetCnt(h2, m2, s2) - getMeetCnt(h1, m1, s1);

  if ((h1 === 0 || h1 === 12) && m1 === 0 && s1 === 0) meetCnt += 1;
  return meetCnt;
}
