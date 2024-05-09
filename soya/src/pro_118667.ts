function solution(queue1, queue2) {
  let MaxCnt = queue1.length * 3;
  let que1 = new Que(queue1);
  let que2 = new Que(queue2);
  let maxNum = 0;
  let ans = -1;
  let sum1 = queue1.reduce((sum, q) => {
    if (q > maxNum) maxNum = q;
    return q + sum;
  }, 0);
  let sum2 = queue2.reduce((sum, q) => {
    if (q > maxNum) maxNum = q;
    return q + sum;
  }, 0);
  //total is odd or one of num is over than total/2 => -1
  if ((sum1 + sum2) % 2 === 1 || maxNum > Math.floor((sum1 + sum2) / 2)) {
    return -1;
  }
  if (sum1 === sum2) ans = 0;
  let cnt = 0;
  console.log(que1.storage);
  console.log(que2.storage);
  // cnt : if cnt is over than qu1.len + que2.len its done. return -1
  while (sum1 !== sum2) {
    console.log("sum1:", sum1, "sum2", sum2);
    if (cnt >= MaxCnt) {
      break;
    }
    // console.log(cnt, totalCnt, sum1, sum2)
    if (sum1 > sum2) {
      let que1pop = que1.pop();
      que2.add(que1pop);
      sum1 -= que1pop;
      sum2 += que1pop;
    } else if (sum2 > sum1) {
      let que2pop = que2.pop();
      que1.add(que2pop);
      sum2 -= que2pop;
      sum1 += que2pop;
    }
    cnt++;
    if (sum1 === sum2) {
      ans = cnt;
    }
  }
  return ans;
}
// 시간초과 뜸
class Que {
  storage: any[];
  front: number;
  rear: number;
  constructor(arr) {
    this.storage = [...arr]; // 값을 저장할 배열
    this.front = 0; // 첫 원소를 가리키는 포인터
    this.rear = this.storage.length; // 마지막원소+1을 가리킬 포인터
  }
  size() {
    return this.rear - this.front;
  }
  add(value) {
    this.storage[this.rear++] = value;
  }
  pop() {
    let temp;
    if (this.size() > 0) {
      temp = this.storage[this.front];
      this.front += 1;
    } else {
      return "empty";
    }
    return temp;
  }
}
let que1 = [4, 6, 5, 1];
let que2 = [3, 2, 7, 2];
console.log(solution(que1, que2));
