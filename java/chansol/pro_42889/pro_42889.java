package chansol.pro_42889;

import java.util.*;
public class pro_42889 {

    class Solution {
        public int[] solution(int N, int[] stages) {

            int[] answer = new int[N] ;
            int stage_len = stages.length;
            int[] temp = new int[N];
            float[] fail_rate = new float[N];
            float[] fail = new float[N];
            boolean[] visited = new boolean[N];

            int challenger = stage_len;
            int user;

            for(int i=1; i<=N; i++){
                visited[i-1] = false;
                user =0;
                for(int j=0; j<stage_len; j++){
                    if(stages[j]==i){
                        user++;
                    }
                    temp[i-1]=user;       // temp[0]에는 1단계에 머물고 있는 사람.

                }
                if(challenger!=0){          //아니 이거 왜 0으로 나눠도 에러가 아니라 NaN이 뜨는거야;; 70.4->100
                    fail_rate[i-1] = (float)user/challenger;
                    fail[i-1] = fail_rate[i-1];
                    challenger -= user;
                }
            }

            Arrays.sort(fail_rate);

            for (int i = 0; i < N / 2; i++) {               //내림차순 정렬안하고 그냥 화나서 제출했더니 33.3, 정렬하고 33.3->70.4
                float temp2 = fail_rate[i];
                fail_rate[i] = fail_rate[N - i - 1];
                fail_rate[N - i - 1] = temp2;
            }

            for(int i=0; i<N; i++){
                System.out.println(fail[i]);
                System.out.println(fail_rate[i]);
                for(int j=0; j<N; j++){
                    if((fail_rate[i]==fail[j])&&!visited[j]){
                        answer[i] = j+1;
                        visited[j] = true;
                        break;
                    }
                }
            }


            return answer;
        }
    }
}
