import java.util.*;

public class Solution {

  static Deque<Integer> q = new LinkedList<>();

  /**
   * 이전 코드와 현재 코드의 효율성 비교를 보여주자!
   */

  public int[] solution(int []arr) {

    q.offer(arr[0]);

    for (int i = 1; i < arr.length; i++) {

      if (q.peekLast() != arr[i]) {
        q.offer(arr[i]);
      }
    }

    // intValue: Integer 객체의 값을 정수로 변환하기 위함으로 사용
    return q.stream().mapToInt(Integer::intValue).toArray();
  }
}
