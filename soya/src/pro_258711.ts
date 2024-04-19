//도넛과 막대그래프 문제
//url : https://school.programmers.co.kr/learn/courses/30/lessons/258711

function solution(edges) {
  let createNode = 0;
  let donut = 0;
  let stick = 0;
  let eight = 0;
  let nodeMax = 0; //가장 큰 노드번호가 노드 갯수
  let totalGraph = 0;
  //노드길이구하기 , 이차배열 1차로만들고 Math 써도될듯
  for (let i in edges) {
    if (edges[i][0] > nodeMax) {
      nodeMax = edges[i][0];
    }
    if (edges[i][1] > nodeMax) {
      nodeMax = edges[i][1];
    }
  }

  //각 nodes 인덱스는 start 노드번호이고 보유한값(배열) is end노드다.
  const nodes = Array.from(Array(nodeMax + 1), () => Array());
  const nodes_reverse = Array.from(Array(nodeMax + 1), () => Array());
  const visitedArr = new Array(nodeMax + 1).fill(0);

  for (let i in edges) {
    const sNode = edges[i][0];
    const eNode = edges[i][1];
    nodes[sNode].push(eNode); //간선추가
    nodes_reverse[eNode].push(sNode);
  }
  //아무도 방문하지않으나 간선은 1개이상이면 생성노드.
  for (let i = 1; i <= nodeMax; i++) {
    if (nodes[i].length == 0 && nodes_reverse[i].length >= 1) {
      stick++;
      continue;
    }
    if (nodes[i].length >= 2 && nodes_reverse[i].length >= 2) {
      eight++;
      continue;
    }
    if (nodes[i].length >= 2 && nodes_reverse[i].length == 0) {
      createNode = i;
      totalGraph = nodes[i].length;
      continue;
    }
  }
  donut = totalGraph - eight - stick;
  //visitedArr.fill(0);
  //생성노드에 연결된 간선으로 그래프노드로 이동하여 해당그래프가 뭔지 찾기

  return [createNode, donut, stick, eight];
}

const edges = [
  [2, 3],
  [4, 3],
  [1, 1],
  [2, 1],
];
console.log(solution(edges));
