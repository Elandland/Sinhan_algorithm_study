import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

class Solution {

  static Map<String, Integer> map = new HashMap<>();

  public int solution(String[][] clothes) {
    AtomicInteger answer = new AtomicInteger(1);

    for (String[] cloth : clothes) {
      map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);
    }

    map.forEach((key, value) -> {
      answer.updateAndGet(v -> v * (value + 1));
    });

    return answer.get()-1;
  }
}
