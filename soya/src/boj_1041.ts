import * as fs from "fs";
//1. 입력값이 한개
// const input = fs.readFileSync("/dev/stdin").toString().trim();
//2. 입력값이 여러개
// const input = fs.readFileSync("/dev/stdin").toString().trim().split(" ");
//3. 입력값이 여러줄
// const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
//4. 입력값이 첫 번째 줄에는 입력 값의 길이(n), 두 번째 줄에 공백으로 구분된 입력값이 주어질 때
// const [n, input] = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
// const inputArr = input.trim().split(" ")
// 5. 입력값이 첫 번째 줄에는 입력 값의 길이(n), n개의 줄에 걸쳐서 한 줄에 하나의 입력값이 주어질 때
// const [n, ...input] = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const [n, input] = fs
  .readFileSync("./dummy/input_1041.txt")
  .toString()
  .trim()
  .split("\n");

function solution() {
  let answer = 0; // 면의 합을 더해 저장
  let nums = input.split(" ").map((v) => +v); // A,B,C,D,E,F => 0,1,2,3,4,5

  const N = Number(n);
  if (N === 1) {
    let maxFace: number = Math.max(...nums);
    let maxFaceIdx = nums.findIndex((v) => v === maxFace);
    let sum = 0;
    for (let i = 0; i < nums.length; i++) {
      if (i === maxFaceIdx) {
        continue;
      } else {
        sum += nums[i];
      }
    }
    return sum;
  }
  // 3면의 조합은 총 7개. 작은거 하나 선택하고

  let smallestFace: number = Math.min(...nums);
  let smallestFaceIdx = nums.findIndex((v) => v === smallestFace);
  // 2면의 조합은 제일작은수 1개 + 걔 건너편 빼고중에 작은거 // 건너편간엔 합이 5임 . [A,F] [B,E] [C,D]
  let smallest2Face: number = 100;
  nums.forEach((v, idx) => {
    if (smallestFaceIdx + idx !== 5 && idx !== smallestFaceIdx) {
      smallest2Face = Math.min(smallestFace + v, smallest2Face);
    }
  });
  //7가지 경우 다 봐야하나?
  let smallest3Face: number = Math.min(
    nums[0] + nums[1] + nums[2], //A,B,C
    nums[0] + nums[1] + nums[3], //A,B,D
    nums[0] + nums[2] + nums[4], // A,C,E
    nums[0] + nums[3] + nums[4], //A.D.E
    nums[1] + nums[2] + nums[5], // B,C,F
    nums[1] + nums[3] + nums[5], // B,D,F
    nums[2] + nums[4] + nums[5], // C.E.F
    nums[3] + nums[4] + nums[5] //D.E.F
  );
  //총 면의 개수
  let totalFace = N * N * 5;
  let face3Dice = 4;
  let face2Dice = 4 + (N - 2) * 8;
  let face1Dice = totalFace - face3Dice * 3 - face2Dice * 2;

  answer += smallest3Face * 4;
  answer += smallest2Face * face2Dice;
  answer += smallestFace * face1Dice;
  return answer;
}

console.log(solution());
