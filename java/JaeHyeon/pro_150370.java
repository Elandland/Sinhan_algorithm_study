import java.time.LocalDate;
import java.util.*;
import java.time.format.DateTimeFormatter;
public class pro_150370 {

  static Map<String, Integer> map = new HashMap<>();
  static StringBuilder sb = new StringBuilder();

  public static int[] solution(String today, String[] terms, String[] privacies) {

    for (String i : terms) {
      String[] term = i.split(" ");

      map.put(term[0], Integer.parseInt(term[1]));
    }

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
    LocalDate Today = LocalDate.parse(today, formatter);

    System.out.println("Today = " + Today);

    for (int i = 0; i < privacies.length; i++) {

      String[] privacy = privacies[i].split(" ");

      LocalDate date = LocalDate.parse(privacy[0], formatter).plusMonths(map.get(privacy[1])).minusDays(1);

      System.out.println("date = " + date);

      if (date.isBefore(Today)) {
        sb.append(i+1).append(" ");
      }
    }

    return Arrays.stream(sb.toString().split(" "))
        .mapToInt(Integer::parseInt).toArray();
  }

  public static void main(String[] args) {
    String today = "2022.05.19";
    String[] terms = {"A 6", "B 12", "C 3"};
    String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
    System.out.println(Arrays.toString(solution(today, terms, privacies)));
  }
}




// 이전 코드
//import java.time.LocalDate;
//    import java.time.format.DateTimeFormatter;
//
//class Solution {
//  public int[] solution(String today, String[] terms, String[] privacies) {
//    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
//    LocalDate date = LocalDate.parse(today, formatter);
//
//    int[] result = new int[privacies.length];
//
//    int count = 0;
//
//    for (int i = 0; i < privacies.length; i++) {
//      String[] p = privacies[i].split(" ");
//      LocalDate pDate = LocalDate.parse(p[0], formatter);
//
//      for (String term : terms) {
//        String[] t = term.split(" ");
//
//        if (p[1].equals(t[0])) {
//          if (date.isBefore(pDate.plusMonths(Integer.parseInt(t[1])))) {
//            result[i] = i + 1;
//            count++;
//            break;
//          }
//        }
//      }
//    }
//
//    int[] r = new int[privacies.length-count];
//    int c = 0;
//    for (int i = 0; i < result.length; i++) {
//      if (result[i] == 0)
//        r[c++] = i+1;
//    }
//    return r;
//  }
//}