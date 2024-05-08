package chansol.pro_118667;

import java.util.*;

public class pro_118667 {

    //두 큐의 합 비교해서 큰쪽에서 작은쪽으로 계속 하나씩 넘겨주면 될듯?
//근데 최소 작업 횟수를 묻는걸 보니까 위에 거 대로 안해도 나오는게 있을거다.
//당장 예시 보니까 바로 그런경우다.
//전체 합을 2로 나눠서 한 큐에 대해서만 만족하는 값을 구하고 이 친구가 만족할때
//다른 큐도 만족하는지 확인 -> 이거에 대해 최솟값을 구하자.(연산을 1번만 해도됨.)
// -1이 될때는 어떻게 할까? ->몇번 했을 때 까지 결과가 안나오면 -1을 출력해야할까
    class Solution {

        public int solution(int[] queue1, int[] queue2) {

            Queue<Integer> que1 = new LinkedList<>();
            Queue<Integer> que2 = new LinkedList<>();

            int answer = 0;         //얘가 0이 아니면 가만히 있어도 똑같을때 -2나옴 90=>96.7
            long queue1_sum = 0;
            long queue2_sum = 0;
            int que_len = queue1.length;
            int value;
            int cnt = 0;
            int max = que_len * 2;


            for (int i = 0; i < que_len; i++) {
                que1.offer(queue1[i]);
                que2.offer(queue2[i]);
                queue1_sum += queue1[i];
                queue2_sum += queue2[i];
            }

            long need_queSum = (queue1_sum + queue2_sum) / 2; //이거 위치를 for문위에 둠 10->90

            while (queue1_sum != queue2_sum) {

                if (queue1_sum > need_queSum) {
                    value = que1.poll();
                    que2.offer(value);
                    queue1_sum -= value;
                    queue2_sum += value;
                    cnt++;
                } else if (queue2_sum > need_queSum) {
                    value = que2.poll();
                    que1.offer(value);
                    queue1_sum += value;
                    queue2_sum -= value;
                    cnt++;
                }

                answer = cnt;
                if (cnt > max * 2) {          //얘 범위를 max에서 max*2로 둠 96->100
                    answer = -1;
                    break;
                }
            }

            return answer;
        }


    }

}