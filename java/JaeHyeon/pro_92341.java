import java.time.*;
import java.util.*;

class Solution {

  static int defaultTime, defaultFee, unitTime, unitFee;
  static Map<String, int[]> map = new HashMap<>();
  static Map<String, Integer> cars = new LinkedHashMap<>();
  static LocalTime finalTime = LocalTime.of(23, 59);

  static public int[] solution(int[] fees, String[] records) {

    // 요금표 세팅
    defaultTime = fees[0];
    defaultFee = fees[1];
    unitTime = fees[2];
    unitFee = fees[3];

    for (String r : records) {

      String[] record = r.split(" ");

      if (record[2].equals("IN")) {

        String[] time = record[0].split(":");

        map.put(record[1], new int[]{Integer.parseInt(time[0]), Integer.parseInt(time[1])});
      } else {

        // 입차 시간 기록
        int[] inTime = map.get(record[1]);
        LocalTime inLocalTime = LocalTime.of(inTime[0], inTime[1]);

        // 출차 시간 기록
        String[] outT = record[0].split(":");
        int[] outTime = {Integer.parseInt(outT[0]), Integer.parseInt(outT[1])};
        LocalTime outLocalTime = LocalTime.of(outTime[0], outTime[1]);

        // 해당 차량 시간 기록
        Duration duration = Duration.between(inLocalTime, outLocalTime);

        String timeValue = String.valueOf(duration.toMinutes());

        cars.put(record[1], cars.getOrDefault(record[1], 0) + Integer.parseInt(timeValue));

        map.remove(record[1]);
      }
    }

    // 혹시 map에 남은 것이 있으면 시간 추가 계산
    map.forEach((key, value) -> {
      LocalTime inTime = LocalTime.of(value[0], value[1]);

      String dur = String.valueOf(Duration.between(inTime, finalTime).toMinutes());
      cars.put(key, cars.getOrDefault(key, 0) + Integer.parseInt(dur));
    });

    // 총 요금 계산
    int[] result = new int[cars.size()];
    int idx = 0;

    List<Map.Entry<String, Integer>> entries = new ArrayList<>(cars.entrySet());

    Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
      @Override
      public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
        return o1.getKey().compareTo(o2.getKey());
      }
    });

    for (Map.Entry<String, Integer> car : entries) {
      if (car.getValue() <= defaultTime) {
        result[idx++] = defaultFee;
      } else {
        double cal = ((double) (car.getValue() - defaultTime) / unitTime);

        int realCal = 0;
        if (!isInteger(cal)) {
          realCal = changeDouble(cal);
        } else {
          realCal = (int) cal;
        }

        result[idx++] = defaultFee + (realCal * unitFee);
      }
    }

    return result;
  }

  static private boolean isInteger(double num) {
    return num % 1 == 0.0;
  }

  static private int changeDouble(double cal) {
    double a = cal + 1;
    double b = Math.round(a);
    return cal < b && b < a ? (int) b : (int) b-1;
  }
}
