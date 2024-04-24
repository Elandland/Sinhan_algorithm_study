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

const input = fs.readFileSync("./dummy/input_17291.txt").toString().trim();

function solution() {
  const n = Number(input);
  let bug_cnt = 1;
  //짝수년도는 4번째에, 홀수년도는 3번째에 분열하고 사망함.
  let stack_year: number[] = [0, 0, 0, 0, 0]; // 0 1 2 3 4
  //i는 년도 . 1년도에는 한마리였고 분열횟수는 0 이나, 홀수년도라 1에다 저장. 분열횟수가 3번(3+1= 4)이 되면 분열하고 사망.
  for (let i = 2; i <= n; i++) {
    // 분열
    const newBugs = bug_cnt;
    bug_cnt = bug_cnt * 2;
    //+1씩 쉬프트. 분열 횟수 증가
    const copy_year = [...stack_year];
    for (let j = 3; j >= 1; j--) {
      stack_year[j] = stack_year[j - 1];
    }
    if (i % 2 === 0) {
      stack_year[0] = bug_cnt / 2; // 분열해서 생긴애들은 올해 탄생한 애들. 짝수년도면 0칸에 저장. 4회때죽으니까. 덮어쓰기.
    } else if (i % 2 !== 0) {
      stack_year[1] += bug_cnt / 2; // 홀수년도면 1칸에 저장. 3회때죽으니까. 작년짝수년도애들에 더해줌.
    }
    const dead_cnt = stack_year[4];
    bug_cnt -= dead_cnt; //년말에 분열스택쌓인애들은 사망.
    console.log(dead_cnt, stack_year);
  }
  return bug_cnt;
}

console.log(solution());
