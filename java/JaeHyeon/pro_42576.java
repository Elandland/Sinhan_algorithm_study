import java.util.*;
import java.util.Map.Entry;

class Solution {

  static Map<String, Integer> map = new HashMap<>();

  public String solution(String[] participant, String[] completion) {

    for (String key : participant) {
      map.put(key, map.getOrDefault(key, 1) + 1);
    }

    for (String key : completion) {
      map.put(key, map.get(key) - 1);
    }

    int max = Collections.max(map.values());

    // Entry를 이용해서 출력하려면
    // import java.util.Map.Entry; <- 이걸 해준다.
    for (Entry<String, Integer> entrySet : map.entrySet()) {

      if (entrySet.getValue() == max) {
        return entrySet.getKey();
      }
    }

    return null;
  }
}

// 이전 제출 코드
//import java.util.Arrays;
//class Solution {
//  public String solution(String[] participant, String[] completion) {
//    Arrays.sort(participant);
//    Arrays.sort(completion);
//
//    for (int i = 0; i < completion.length; i++) {
//      if (!completion[i].equals(participant[i]))
//        return participant[i];
//    }
//
//    return participant[participant.length-1];
//  }
//}

  // 예전 거
//    정확성  테스트
//    테스트 1 〉	통과 (0.41ms, 76MB)
//    테스트 2 〉	통과 (0.34ms, 73.3MB)
//    테스트 3 〉	통과 (2.28ms, 71.4MB)
//    테스트 4 〉	통과 (4.27ms, 79.9MB)
//    테스트 5 〉	통과 (3.98ms, 76MB)
//    테스트 6 〉	통과 (0.27ms, 74.7MB)
//    테스트 7 〉	통과 (0.28ms, 78.1MB)
//    효율성  테스트
//    테스트 1 〉	통과 (107.34ms, 80.5MB)
//    테스트 2 〉	통과 (246.20ms, 88.7MB)
//    테스트 3 〉	통과 (292.22ms, 94.2MB)
//    테스트 4 〉	통과 (373.32ms, 95.3MB)
//    테스트 5 〉	통과 (285.62ms, 96.6MB)

//    이번에 한 거
//    정확성  테스트
//    테스트 1 〉	통과 (0.08ms, 84.3MB)
//    테스트 2 〉	통과 (0.17ms, 71.1MB)
//    테스트 3 〉	통과 (1.05ms, 76.3MB)
//    테스트 4 〉	통과 (1.22ms, 72.3MB)
//    테스트 5 〉	통과 (1.39ms, 75.9MB)
//    테스트 6 〉	통과 (0.08ms, 70MB)
//    테스트 7 〉	통과 (0.07ms, 74.5MB)
//    효율성  테스트
//    테스트 1 〉	통과 (41.53ms, 81.5MB)
//    테스트 2 〉	통과 (83.01ms, 89.1MB)
//    테스트 3 〉	통과 (91.98ms, 95.3MB)
//    테스트 4 〉	통과 (92.49ms, 96.5MB)
//    테스트 5 〉	통과 (89.57ms, 95.1MB)