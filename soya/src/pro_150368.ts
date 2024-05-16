//user [[40,10000],[25,10000],...]
//emoticons [4000,10000,...]
function solution(users, emoticons) {
  let answer = [0, 0];
  let emoticonRate = new Array(emoticons.length).fill(0);
  //가장 많이 플러스 서비스를 가입하게하려면, 모두를 일정금액이상 구매하게만들어야함.
  //할인율이 높아야 구매율이 증가하지만, 할인율이 너무 높아지면 서비스에 가입할 필요없는사람도 생김.
  //적은할인율 부터 확인하면서 서비스가입자가 늘어나는걸 확인하다가, 일정 할인율이상부터 서비스가입자가 감소하면 종료.
  function setEmoticonRate(dept) {
    if (dept === 4) {
      return buyEmoticon();
    }
    for (let i = 10; i <= 40; i += 10) {
      emoticonRate[dept] = i;
      setEmoticonRate(dept + 1);
    }
  }

  //해당 할인율일때의 플러스구매자,판매금액 파악.
  function buyEmoticon() {
    let plusUsers = 0;
    let sales = 0;
    // console.log("rate :",emoticonRate);
    for (let user of users) {
      //한 유저의 총구매금액
      let totalPrice = 0;
      for (let i in emoticons) {
        let emt = emoticons[i];
        let rate = emoticonRate[i];
        if (user[0] > rate) continue;
        let price = emt - emt * (rate / 100);

        totalPrice += price;
        if (totalPrice >= user[1]) {
          plusUsers++;
          totalPrice = 0;
          break;
        }
      }
      console.log(`${user} , price : ${totalPrice}`);
      //한유저의 총구매금액을 전체매출에더해준다.
      sales += totalPrice;
    }
    if (plusUsers > answer[0]) {
      answer[0] = plusUsers;
      answer[1] = sales;
    } else if (plusUsers === answer[0] && sales > answer[1]) {
      answer[1] = sales;
    }
  }
  setEmoticonRate(0);
  return answer;
}
