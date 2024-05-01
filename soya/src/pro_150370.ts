//개인정보 수집 유효기간
//url: https://school.programmers.co.kr/learn/courses/30/lessons/150370
//today날짜에 파기해야할 개인정보. 모든 달은 28일까지 존재 .
//ex) 3달 보관 가능하면 05.19~ 08.18 동안 보관

function solution150370(today: string, terms: string[], privacies: string[]) {
  let answer = [];
  const todayInfo = today.split(".").map(Number); // 0: year 1: month 2: day

  for (let i in privacies) {
    const privacyStartDay = privacies[i].split(" ")[0]; // yyyy.mm.dd
    const privacyTerm: string = privacies[i].split(" ")[1]; // A B C
    let termMonth: string = terms.find((e) => e.includes(privacyTerm));
    const privaciesLastDate = findLastPrivacyDay(
      Number(termMonth.split(" ")[1]),
      privacyStartDay
    );
    if (isOverDate(todayInfo, privaciesLastDate)) {
      answer.push(Number(i) + 1);
    }
  }
  //privacyDate: yyyy.mm.dd
  function findLastPrivacyDay(
    termMonth: number,
    privacyStartDate: string
  ): number[] {
    let prYear = Number(privacyStartDate.split(".")[0]);
    let prMonth = Number(privacyStartDate.split(".")[1]);
    let prDay = Number(privacyStartDate.split(".")[2]);
    let newYear = prYear;
    let newMonth = prMonth + termMonth;
    let newDay = prDay - 1;
    if (newDay === 0) {
      newDay = 28;
      newMonth--;
    }
    if (newMonth > 12) {
      newYear += Math.floor(newMonth / 12);
      newMonth = newMonth - Math.floor(newMonth / 12) * 12;
    }
    return [newYear, newMonth, newDay];
  }

  function isOverDate(
    todayInfo: number[],
    privaciesLastDateInfo: number[]
  ): boolean {
    //year
    if (todayInfo[0] > privaciesLastDateInfo[0]) return true;
    if (todayInfo[0] < privaciesLastDateInfo[0]) return false;
    //month
    if (todayInfo[1] > privaciesLastDateInfo[1]) return true;
    if (todayInfo[1] < privaciesLastDateInfo[1]) return false;
    //day
    if (todayInfo[2] > privaciesLastDateInfo[2]) return true;

    return false;
  }

  return answer;
}

const today = "2022.05.19";
const terms = ["A 6", "B 12", "C 3"];
const privacies = [
  "2021.05.02 A",
  "2021.07.01 B",
  "2022.02.19 C",
  "2022.02.20 C",
];
console.log(solution150370(today, terms, privacies));
