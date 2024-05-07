//import java.util.*;
//class Solution {
//  static Queue<Integer> q1 = new LinkedList<>();
//  static Queue<Integer> q2 = new LinkedList<>();
//  static long q1sum = 0, q2sum = 0;
//  static int count = 0;
//  public int solution(int[] queue1, int[] queue2) {
//    q1sum = Arrays.stream(queue1).sum();
//    q2sum = Arrays.stream(queue2).sum();
//
//    if ((q1sum+q2sum)%2 == 1) {
//      return -1;
//    }
//
//    long goalNum = (q1sum + q2sum) / 2;
//
//    for (int i = 0; i < queue1.length; i++) {
//      q1.offer(queue1[i]);
//      q2.offer(queue2[i]);
//    }
//
//    while (q1sum != q2sum) {
//
//      if (count >= queue1.length * 4) {
//        return -1;
//      }
//
//      int num;
//      if (q1sum > q2sum) {
//
//        if (q1.isEmpty()) {
//          return -1;
//        }
//
//        num = q1.poll();
//
//        if (num > goalNum) {
//          return -1;
//        }
//
//        q1sum -= num;
//        q2sum += num;
//
//        q2.offer(num);
//      } else if (q1sum < q2sum){
//
//        if (q2.isEmpty()) {
//          return -1;
//        }
//
//        num = q2.poll();
//
//        if (num > goalNum) {
//          return -1;
//        }
//
//        q1sum += num;
//        q2sum -= num;
//
//        q1.offer(num);
//      } else {
//        return count;
//      }
//      count++;
//    }
//
//    return count;
//  }
//}

// 위에 로직 틀렸는데 왜 틀린 건지 알게 된 찬솔이 구함...

import java.util.*;

public class pro_118667 {

  static Queue<Integer> q1 = new LinkedList<>();
  static Queue<Integer> q2 = new LinkedList<>();
  static long q1sum = 0, total = 0;
  static int count = 0;
  static private int solution(int[] queue1, int[] queue2) {

    for (int i = 0; i < queue1.length; i++) {
      q1.offer(queue1[i]);
      q2.offer(queue2[i]);
      total += (queue1[i]+queue2[i]);
      q1sum += queue1[i];
    }

//    System.out.println("q1 = " + q1);
//    System.out.println("q2 = " + q2);

    if (total%2 == 1) {
      return -1;
    }

    long goal = total/2;

    while (q1sum != goal) {

      if (count >= queue1.length * 4) {
        return -1;
      }

      if (q1sum > goal) {

        q1sum -= q1.peek();
        q2.offer(q1.poll());
      } else if (q1sum < goal){

        q1sum += q2.peek();
        q1.offer(q2.poll());
      } else {
        return count;
      }

//      System.out.println("q1 = " + q1);
//      System.out.println("q2 = " + q2);
      count++;
    }

    return count;
  }

  public static void main(String[] args) {
    int[] queue1 = {1, 2, 1, 2};
    int[] queue2 = {1, 10, 1, 2};
    System.out.print(solution(queue1, queue2));
  }
}
