function solution(fees, records) {
  //fees : 기본시간, 기본 요금, 단위 시간, 단위 시간 당 요금
  var answer = [];
  let map = new Map();
  let ansMap = new Map();
  function getMin(timeStr) {
    let hour = timeStr.split(":")[0];
    let min = timeStr.split(":")[1];
    return Number(hour * 60) + Number(min);
  }

  for (let i of records) {
    let recordValue = i.split(" ");
    if (recordValue[2] === "IN") {
      map.set(recordValue[1], recordValue[0]); // key: 차량번호, value:입차 시간
    } else {
      //OUT
      let st = map.get(recordValue[1]);
      let time = getMin(recordValue[0]) - getMin(st);
      if (ansMap.get(recordValue[1])) {
        ansMap.set(recordValue[1], ansMap.get(recordValue[1]) + time);
        console.log(recordValue[1]);
      } else {
        ansMap.set(recordValue[1], time); // 차량번호 : 누적 주차시간
      }
      map.delete(recordValue[1]);
    }
  }

  if (map.size > 0) {
    //출차 내역이 없으면 23:59 출차로 간주.
    for (let k of map) {
      let st = k[1];
      let id = k[0];
      let time = getMin("23:59") - getMin(st);
      if (ansMap.get(id)) {
        ansMap.set(id, ansMap.get(id) + time);
      } else {
        ansMap.set(id, time); // 차량번호 : 누적 주차시간
      }
    }
  }
  const ans = [...ansMap];
  ans.sort((a, b) => a[0] - b[0]); // 차량번호 기준 정렬
  //let price = fees[1] +  (diffTime >0 ? diffTime : 0 )* fees[3]
  return ans.map(
    v =>
      fees[1] +
      (Math.ceil((v[1] - fees[0]) / fees[2]) > 0
        ? Math.ceil((v[1] - fees[0]) / fees[2])
        : 0) *
        fees[3]
  );
}
