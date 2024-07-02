package chansol;
import java.util.*;
public class pro_169198 {
    static class Solution {
        public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
            int ball_len = balls.length;        //공의 갯수

            int[] answer = new int[ball_len];

            for(int i=0; i<ball_len; i++){

                int sol1 = (int)Math.pow(startX - balls[i][0], 2) + (int)Math.pow(startY + balls[i][1], 2);     //아래쪽 벽으로 넘기기
                int sol2 = (int)Math.pow(startX - balls[i][0], 2) + (int)Math.pow(startY - (2 * n - balls[i][1]), 2);       //n-balls + n 위쪽 벽으로 넘기기
                int sol3 = (int)Math.pow(startX + balls[i][0], 2) + (int)Math.pow(startY - balls[i][1], 2);     //왼쪽 벽으로 넘기기
                int sol4 = (int)Math.pow(startX - (2 * m - balls[i][0]), 2) + (int)Math.pow(startY - balls[i][1], 2);       //m-balls + m 오른쪽 벽으로 넘기기

                if(startX == balls[i][0]){
                    if(startY > balls[i][1]){    //쳐야 될 공이 더 밑에 있으면 무조건 위쪽으로 쳐야 함.
                        sol1 = 10000000;
                    }
                    else{
                        sol2 = 10000000;
                    }
                }
                else if (startY == balls[i][1]){
                    if(startX > balls[i][0]){
                        sol3 = 10000000;
                    }
                    else{
                        sol4 = 10000000;
                    }
                }
                answer[i] = Math.min(sol1,Math.min(sol2,Math.min(sol3,sol4)));
            }



            //질문하기 보니까 치는 공이 x축,y축에 겹치는 경우를 보네
            return answer;
        }
    }
}
