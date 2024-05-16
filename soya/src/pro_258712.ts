//friends = [] "A,B,C ..." 2<= n<= 50
//gifts = [] "A B" (A ->B)
//answer = 다음달 가장 선물을 많이 받을 친구의 선물의 수
// A > B 면 A+=1
// 서로 선물기록이 없거나 주고받은 수가 같다면 선물지수가 더 큰사람에게 더 작은사람이 준다. (이마저도 같으면 안주고받음)
// 선물지수 = 내가 준 선물수 - 내가 받은 선물수
// 다음달 선물 젤 많이 받은 사람의 받은 개수 리턴
function pro258712(friends, gifts) {
  //이번달 ,다음달 선물지수
  const giftScore = new Array(friends.length).fill(0);
  const nextGiftScore = new Array(friends.length).fill(0);
  // 2차 배열 0으로 초기화
  let giftMap: number[][] = Array.from(Array(friends.length), () =>
    new Array(friends.length).fill(0)
  );
  //선물장표 보고 이달 선물지수 결정
  for (let gift of gifts) {
    let a = friends.indexOf(gift.split(" ")[0]);
    let b = friends.indexOf(gift.split(" ")[1]);
    giftScore[a]++;
    giftScore[b]--;
    giftMap[a][b]++;
    giftMap[b][a]--;
  }
  for (let g of giftMap) {
    console.log(g);
  }
  //선물맵 보고 다음달 선물지수 결정
  for (let i = 0; i < friends.length; i++) {
    for (let j = i + 1; j < friends.length; j++) {
      console.log(i, j);
      let iScore = giftMap[i][j];
      let jScore = giftMap[j][i];
      if (iScore == 0 && jScore == 0) {
        if (giftScore[i] > giftScore[j]) nextGiftScore[i]++;
        if (giftScore[i] < giftScore[j]) nextGiftScore[j]++;
        continue;
      }
      if (iScore > jScore) {
        nextGiftScore[i]++;
      } else if (jScore > iScore) {
        nextGiftScore[j]++;
      }
    }
  }
  console.log("next :", nextGiftScore);
  let ans = Math.max(...nextGiftScore);
  console.log(ans);
  return ans;
}

let friends = ["muzi", "ryan", "frodo", "neo"];
let gifts = [
  "muzi frodo",
  "muzi frodo",
  "ryan muzi",
  "ryan muzi",
  "ryan muzi",
  "frodo muzi",
  "frodo ryan",
  "neo muzi",
];
pro258712(friends, gifts);
