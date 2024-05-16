import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

class pro_258712 {

  static Map<String, Map<String, Integer>> map = new HashMap<>();
  static Map<String, Integer> score = new HashMap<>();
  static Map<String, Integer> result = new HashMap<>();
  static private int solution(String[] friends, String[] gifts) {
    for (String s : friends) {
      map.put(s, new HashMap<>());
      score.put(s, 0);
      result.put(s, 0);
    }

    for (String s : gifts) {
      String[] character = s.split(" ");
      String giver = character[0];
      String receiver = character[1];

      Map<String, Integer> receivers = map.get(giver);

      // receivers가 null인 경우에 대비하여 새로운 Map을 생성
      if (receivers == null) {
        receivers = new HashMap<>();
      }

      // receivers에 수신자와 선물 수를 저장
      if (receivers.isEmpty()) {
        receivers.put(receiver, 1);
      } else {
        receivers.put(receiver, receivers.getOrDefault(receiver, 0) + 1);
      }

      // map에 업데이트된 receivers를 다시 저장
      map.put(giver, receivers);
    }

    System.out.println(map);

    // 선물 지수
    // vlaue도 Map
    map.forEach((key, value) -> value.forEach((k, v) -> {
      //maxScore = Math.max(maxScore, v);
      score.put(key, score.get(key) + v);
      score.put(k, score.get(k) - v);
    }));

    // 결과
    for (int i = 0; i < friends.length; i++) {

      String friend = friends[i];

      for (int j = 0; j < friends.length; j++) {

        // 같은 건 검사 X
        if (friend.equals(friends[j])) {
          continue;
        }

        if (map.get(friend).containsKey(friends[j])) {

          int give = map.get(friend).get(friends[j]);
          int receive = 0;

          if (map.get(friends[j]).containsKey(friend)) {
            receive = map.get(friends[j]).get(friend);
          }

          if (give > receive) {
            result.put(friend, result.get(friend)+1);

            System.out.println("s" + friend + " / " + friends[j]);

          } else if (give == receive) {

            if (score.get(friend) > score.get(friends[j])) {
              result.put(friend, result.get(friend)+1);
              System.out.println("s" + friend + " / " + friends[j]);
            }
          }

        } else {

          if (!map.get(friends[j]).containsKey(friend) && score.get(friend) > score.get(friends[j])) {
            result.put(friend, result.get(friend)+1);
            System.out.println("s" + friend + " / " + friends[j]);
          }
        }
      }
    }

    System.out.println(score);

    System.out.println("res: " + result);

    return Collections.max(result.values());
  }
  public static void main(String[] args) {
    String[] a = {"joy", "brad", "alessandro", "conan", "david"};
    String[] b = {"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"};
    System.out.println(solution(a, b));
  }
}