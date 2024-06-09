function solution(arr) {
  var answer = [];
  let last = -1;
  for (let value of arr) {
    if (value !== last) {
      answer.push(value);
    }
    last = value;
  }

  return answer;
}
