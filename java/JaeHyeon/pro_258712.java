import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

// AtomicInteger
// 이건 왜 임포트 헤놓았었냐?
// map.forEach()를 사용하고,
// 그 안에서 또 Map.forEach()를 사용했더니,
// 두 개의 스레드 안에서 변수를 다룰 때,
// 스레드의 실행 및 종료를 순차적으로 돕는 것이 아니라,
// 동시 스레드 상황에서도 안전하게 값을 증가 시키는 것이
// AtomicInteger (클래스) 라는 것!
// 즉, 다중 스레드 환경에서 안전하게 값을 변경할 수 있으며,
// 동시 스레드 상황에서도 안전하게 값을 증가시키는 데 사용된다고 함.

// 근데 결국 안 씀ㅋ

class pro_258712 {

  // Map 안에 Map...
  // 그 내용을 출력해보면
  // {joy={}, alessandro={joy=1, conan=1, david=1, brad=1},
  // conan={}, david={alessandro=1}, brad={}}
  // 요로코롬 나오는 걸 볼 수 있음
  // "alessandro" 가 "joy" 한테 1개, "conan" 에게 한 개... 를 선물을 줬다는 뜻
  static Map<String, Map<String, Integer>> map = new HashMap<>();

  // 이것은 선물 지수를 나타내기 위한 Map
  // {joy=-1, alessandro=3, conan=-1, david=0, brad=-1}
  static Map<String, Integer> score = new HashMap<>();

  // 이것은 결과
  // {joy=0, alessandro=4, conan=0, david=3, brad=0}
  // Collections.max(result.value())를 사용하면 최댓값을 받을 수 있음.
  static Map<String, Integer> result = new HashMap<>();
  static private int solution(String[] friends, String[] gifts) {

    // 초기화 작업
    for (String s : friends) {
      map.put(s, new HashMap<>());
      score.put(s, 0);
      result.put(s, 0);
    }

    for (String s : gifts) {

      // 문자열을 공백을 기준으로 나누어
      // 누가 주고 받았는 지를 판별해놓음
      String[] character = s.split(" ");
      String giver = character[0];
      String receiver = character[1];

      // Map 안에 Map이 있었기 때문에,
      // 안에 있는 Map을 받아 줄 Map을 만듦
      Map<String, Integer> receivers = map.get(giver);

      // receivers에 수신자와 선물 수를 저장
      if (receivers.isEmpty()) {

        // 선물을 받은 수신자가 없다면, "1"로 생성
        // ...
        // 라고 생각했었다가 그냥 비어있으면 넣어 주는,
        // 딱히 의미가 없는 코드였다.
        receivers.put(receiver, 1);
      } else {

        // 키 값에 따른 value 값을 수정하고 싶을 땐,
        // replace()를 써도 가능하지만,
        // 그냥 put으로 해도 수정할 수 있음.
        receivers.put(receiver, receivers.getOrDefault(receiver, 0) + 1);

        // getOrDefault 는 무엇이냐?
        // 처음엔 코드를 receivers.put(receiver, receivers.get(receiver) + 1);
        // 이렇게 짰었는데, NullPointerException 에러가 나와서 실행할 수 없었음.
        // NullPointerException이 대체 왜 나오는 지를 몰랐는데
        // if문에서 receivers(Map)에 receiver(선물을 받는 String)으로
        // key 값이 없으면 "receiver": 1 이런 식으로 값을 넣어주도록 했어야 했는데
        // 그냥 비어만 있으면 값을 넣도록 코드를 짜 놓아서
        // receivers.put(receiver, receivers.get(receiver) + 1);
        // 이렇게만 쓰면 receiver(특정 수신자)에 대한 키 값이 없을 수 있다.

        // 깨닫고 나니까
        // if 문을 쓸 필요 없이
        // receivers.put(receiver, receivers.getOrDefault(receiver, 0) + 1);
        // 이 코드 하나만 써주면 되는 문제였다!
      }

      // map에 업데이트된 receivers를 다시 저장
      map.put(giver, receivers);
    }

    System.out.println(map);

    // 선물 지수
    // value도 Map
    // 이 코드는 말, 그림으로 설명하는 게 나을듯
    map.forEach((key, value) -> value.forEach((k, v) -> {

      score.put(key, score.get(key) + v);
      score.put(k, score.get(k) - v);
    }));

    // 결과
    // 음.. 이것도 할 수 있을지 모르겠지만,
    // 말과 그림으로 설명 해야할듯
    for (int i = 0; i < friends.length; i++) {

      // 한 명씩 어떤 지를 검사하기 위해서
      String friend = friends[i];

      for (int j = 0; j < friends.length; j++) {

        // 같은 건 검사 X
        if (friend.equals(friends[j])) {
          continue;
        }

        // 첫 번째가 두 번째한테 선물을 줬다면
        if (map.get(friend).containsKey(friends[j])) {

          // 몇 개를 주었는 지
          int give = map.get(friend).get(friends[j]);

          // 두 번째 또한, 선물을 첫 번째한테 줬다면 몇 개를 줬는 지
          int receive = 0;
          if (map.get(friends[j]).containsKey(friend)) {
            receive = map.get(friends[j]).get(friend);
          }

          // 주고 받은 선물 개수 비교
          if (give > receive) {
            result.put(friend, result.get(friend)+1);

            System.out.println("s" + friend + " / " + friends[j]);

          } else if (give == receive) {

            // 둘이 주고 받은 선물 개수가 같다면
            // 선물 지수를 비교
            if (score.get(friend) > score.get(friends[j])) {
              result.put(friend, result.get(friend)+1);
              System.out.println("s" + friend + " / " + friends[j]);
            }
          }

        } else { // 첫 번째가 두 번째한테 선물을 주지 않았다면

          // 만약 두 번째 또한, 첫 번째한테 선물을 주지 않았는데,
          // 첫 번째가 두 번째 보다 선물지수가 높다면?
          // ...
          // 어차피 한 명 씩 다 돌면서 값을 증가 시켜주기 때문에,
          // 반대의 경우는 생략
          if (!map.get(friends[j]).containsKey(friend) && score.get(friend) > score.get(friends[j])) {
            result.put(friend, result.get(friend)+1);
            System.out.println("s" + friend + " / " + friends[j]);
          }
        }
      }
    }

    System.out.println(score);

    System.out.println("res: " + result);

    // 출력
    return Collections.max(result.values());
  }
  public static void main(String[] args) {
    String[] a = {"joy", "brad", "alessandro", "conan", "david"};
    String[] b = {"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"};
    System.out.println(solution(a, b));
  }
}