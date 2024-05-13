function solution3(survey, choices) {
  let ans1 = "R"; //T
  let ans2 = "C"; //F
  let ans3 = "J"; //M
  let ans4 = "A"; //N
  let scoreObj = { R: 0, T: 0, C: 0, F: 0, J: 0, M: 0, A: 0, N: 0 }; // RT CF JM AN
  //1 ~ 7 1,2,3=> 첫글자 5,6,7=>두번째글자 4= 중립
  for (let i in survey) {
    let surv = survey[i];
    let choice = choices[i];
    let score = 4 - choice;
    if (score === 0) continue;
    let isFirst = score < 0 ? true : false; // 음수면 첫글자유형. 양수면 두번째글자유형
    if (isFirst) {
      // 첫글자에 점수
      scoreObj[surv[0]] += Math.abs(score);
    } else {
      //두번째 글자에 점수
      scoreObj[surv[1]] += Math.abs(score);
    }
  }
  if (scoreObj["R"] < scoreObj["T"]) {
    ans1 = "T";
  }
  if (scoreObj["C"] < scoreObj["F"]) {
    ans2 = "F";
  }
  if (scoreObj["J"] < scoreObj["M"]) {
    ans3 = "M";
  }
  if (scoreObj["A"] < scoreObj["N"]) {
    ans4 = "N";
  }

  return ans1 + ans2 + ans3 + ans4;
}

const survey = ["AN", "CF", "MJ", "RT", "NA"];
const choices = [5, 3, 2, 7, 5];
solution3(survey, choices);
