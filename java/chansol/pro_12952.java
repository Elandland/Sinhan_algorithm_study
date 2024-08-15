package chansol;

public class pro_12952 {

    class Solution {

        private boolean visit[];
        private int answer = 0;
        private int queen_seat[];


        public int solution(int n) {

            visit = new boolean[n];
            queen_seat = new int[n];      //이차원 배열로 할랬는데 그냥 index , value로 행,열 표현 하면 될 듯?

            check(n,0);

            return answer;
        }



        public void check(int n, int queen_count){
            if(n == queen_count){
                answer++;           //퀸이 다 정상적으로 들어갔을 때
                return;
            }

            for(int i=0; i<n; i++){
                if(!visit[i]){
                    visit[i]=true;
                    queen_seat[queen_count] = i;     //queen_count로 인덱스 해서 퀸이 들어갈때 마다 index올려주기   value+1 이 칸임.
                    if(queen_check(queen_count)){
                        check(n,queen_count+1);
                    }
                    visit[i]=false;
                }
            }
        }
        public boolean queen_check(int queen_count){
            for(int j=0; j<queen_count; j++){           //방금 넣은 퀸이랑 0번째 부터 지금 들어간 queen까지 체크
                if(queen_seat[j]==queen_seat[queen_count]){         //같은 열
                    return false;
                }
                if(Math.abs(queen_count-j) == Math.abs(queen_seat[queen_count]-queen_seat[j])){     //같은 대각선
                    return false;
                }
            }
            return true;
        }

    }
}
