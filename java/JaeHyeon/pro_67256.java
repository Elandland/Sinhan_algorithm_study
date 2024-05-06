import java.io.*;
import java.util.*;

public class ppp {

  // [ 1차 풀이 ]
  // DFS로 풀 수 있지 않을까 싶다
  // 엄지손가락마다 가운데 열의 거리를 DFS로 나타내고 (얼마 안 걸릴테니까...?)
  // 나온 값들을 비교

  // [ 2차 풀이 ]
  // 위와 같이 생각했었는데,
  // 내가 숫자 '0'으로만 이루어진 이차원 배열을 이용해서 거리를 잰다고 하면,
  // 거리를 잴 때, 누르려는 키의 위치...
  // 이건 나중에 말로 설명해야겠당 ㅎㅎ
  // 아무튼 BFS로 풀어야겠다고 생각함

  // 키패드
  static String[][] keypad = {
      {"1", "2", "3"},
      {"4", "5", "6"},
      {"7", "8", "9"},
      {"*", "0", "#"}
  };

  // 거리를 재기 위한 배열
  static int[][] check;

  // 각 엄지손가락의 좌표 (초기)
  static int[] leftThumb = {3, 0};
  static int[] rightThumb = {3, 2};

  // 상하좌우
  static int[] x = {0, 0, 1, -1};
  static int[] y = {1, -1, 0, 0};

  // 결과 출력을 위한 스트링빌더
  static StringBuilder sb = new StringBuilder();

  static public String solution(int[] numbers, String hand) {

    // 3가지 경우로 나누었음

    // 1, 4, 7일 때는 무조건 왼쪽
    // 3, 6, 9일 때는 무조건 오른쪽
    // 그 외엔 '거리값'과 '어느 손잡이'냐에 따라 비교

    for (int i = 0; i < numbers.length; i++) {

      if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {

        // 결과를 출력할 sb에 "L"을 붙여주고,
        // 제시된 숫자의 좌표를 반환해주는 함수를 호출하여
        // 왼손 엄지손가락에 그 좌표를 넣어주면서 갱신
        sb.append("L");
        leftThumb = returnCoordinate(numbers[i]);

      } else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {

        // 1, 4, 7일 때의 설명과 마찬가지로
        // 오른쪽도 똑같이 ㅇㅇ
        sb.append("R");
        rightThumb = returnCoordinate(numbers[i]);

      } else {

        // bfs를 두 번 호출해서 값을 비교하기로 함. 더 좋은 방법이 떠오르지 않았음 ㅜ
        // 해당 숫자와 엄지손가락의 값을 인자로 받아 넘겨서
        int leftDistance = bfs(leftThumb, numbers[i]);
        int rightDistance = bfs(rightThumb, numbers[i]);

        // 그렇게 나온 두 값을 비교
        if (leftDistance > rightDistance) {
          rightThumb = returnCoordinate(numbers[i]);
          sb.append("R");

        } else if (leftDistance < rightDistance) {
          leftThumb = returnCoordinate(numbers[i]);
          sb.append("L");

        } else {

          // 만약 같은 거리값이면 어떤 손잡이냐에 따라서 또 비교.
          // 그리고 좌표 갱신
          if (hand.equals("right")) {
            sb.append("R");
            rightThumb = returnCoordinate(numbers[i]);
          } else {
            sb.append("L");
            leftThumb = returnCoordinate(numbers[i]);
          }
        }
      }
    }

    // 값 출력
    return sb.toString();
  }

  // 숫자가 키패드 배열에서 어디 좌표인지 반환하기 위한 함수
  // 숫자는 int 배열이지만, 내가 만든 keypad 배열은 String.
  // 그래서 String.valueOf로 형변환을 해서 값 비교 후,
  // 같으면 그에 맞는 좌표 반환
  // return null은 걍 써놓은 것. 이 코드가 실행될 일은 없음.
  static private int[] returnCoordinate(int number) {

    for (int i = 0; i < keypad.length; i++) {
      for (int j = 0; j < keypad[i].length; j++) {
        if (keypad[i][j].equals(String.valueOf(number))) {
          return new int[]{i, j};
        }
      }
    }

    return null;
  }

  // 현재 엄지손가락의 좌표와 검사하고 있는 숫자를 받아서 탐색하는 bfs
  static private int bfs(int[] thumb, int number) {

    // 함수가 호출될 때 check 배열이 초기화가 들어감
    check = new int[4][3];

    // 넘겨 받은 숫자의 좌표를 받아 놓음
    // 탐색하다가 이 좌표와 같으면 반복문 탈출
    int[] findCoordinate = returnCoordinate(number);

    // 밑에 조건문에서 '0'일 때, 참이 되도록 해놓았기 때문에,
    // 우선적으로 넘겨 받은 엄지손가락의 좌표에 해당하는 칸에 1을 박고 시작
    check[thumb[0]][thumb[1]] = 1;

    // 큐에다가 넘겨 받은 엄지손가락의 좌표를 넣어주면서 탐색 ㄱㄱ
    Queue<int[]> queue = new LinkedList<>();
    queue.offer(thumb);

    // 탐색 이후 값을 반환할 변수
    int distance = 0;

    while (!queue.isEmpty()) {

      int[] start = queue.poll();

      // 처음에 조건문에 냅다 'start == findCoordinate' 라고 썼었는데
      // 이렇게 하면 Heap 영역의 주소 값을 비교하기 때문에
      // 같다고 나오지 않는다고 함 ㅇㅇ.
      // 두 배열이 같은 지를 확인하고 싶다면,
      // Arrays.equals(arr1, arr2); 이렇게 해주면 된다고 함 ㅇㅇ

      // 아무튼 좌표가 서로 같으면 'distance'변수에 해당 좌표에 있는 값을 넣어주고 반복문 탈출
      if (start[0] == findCoordinate[0] && start[1] == findCoordinate[1]) {
        distance = check[start[0]][start[1]];
        break;
      }

//      if (Arrays.equals(start, findCoordinate)) {
//        distance = check[start[0]][start[1]];
//        break;
//      }

      // 상하좌우로 탐색하는 과정
      // 지난번, 토마토 문제 풀 때처럼, 1을 더해주면서 풀었음.
      for (int i = 0; i < 4; i++) {

        int newX = start[0] + x[i];
        int newY = start[1] + y[i];

        if (newX >= 0 && newX < 4 && newY >= 0 && newY < 3 && check[newX][newY] == 0) {

          queue.offer(new int[]{newX, newY});
          check[newX][newY] = check[start[0]][start[1]] + 1;
        }
      }
    }

    // 거리값 반환
    return distance;
  }

  public static void main(String[] args) throws IOException {

    // 예제 2번
    int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
    String hand = "left";

    System.out.println(solution(numbers, hand));
  }
}
