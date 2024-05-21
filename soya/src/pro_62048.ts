function solution(w, h) {
  var answer = 1;
  let totalSqure = w * h;
  let W = w > h ? h : w;
  let H = w > h ? w : h; // 긴쪽을 H로.
  let hp = 1; // h의 위치
  let flag = 1;
  let startHp = 0; // 체크한곳 위치
  let trashBlock = 0;
  for (let i = 1; i <= H; i++) {
    let w = (W / H) * i;
    //console.log(w);
    if (w === Math.floor((W / H) * i)) {
      //자연수
      trashBlock += i - startHp;
      //console.log(trashBlock)
      trashBlock = trashBlock * (W / w);
      break;
    }
    if (w >= flag) {
      trashBlock += i - startHp + 1;
      startHp = i;
      flag++;
    }
  }
  return totalSqure - trashBlock;
}

solution(8, 12);
