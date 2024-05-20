package chansol;

public class pro_17682 {

    class Solution {
        public int solution(String dartResult) {
            int answer = 0;
            int len = dartResult.length();
            char[] arr = new char[len];
            int cnt =-1;
            int iften =0;
            for(int i=0; i<len; i++){
                arr[i] = dartResult.charAt(i);
            }
            int[] score = new int[3];

            for(int i=0; i<len; i++){
                int score_point = (int)arr[i] - '0';
                if(score_point>=0&&score_point<=10){
                    iften++;
                    // cnt++; 10일때는 숫자가 2개
                    if(iften ==2){
                        score[cnt] = 10;
                    }
                    else{
                        cnt++;
                        score[cnt] = score_point;
                    }
                }
                else if(arr[i]=='S'){
                    iften=0;
                }
                else if(arr[i]=='D'){
                    iften=0;
                    score[cnt] = (int)Math.pow(score[cnt],2);
                }
                else if(arr[i]=='T'){
                    iften =0;
                    score[cnt] = (int)Math.pow(score[cnt],3);
                }
                else if(arr[i]=='*'){
                    score[cnt] *=2;
                    if(cnt !=0){
                        score[cnt-1] *=2;
                    }
                }
                else if(arr[i]=='#'){
                    score[cnt] *= -1;
                }

                // System.out.println("첫번째 :"+score[0]);
                // System.out.println("두번째 : "+score[1]);
                // System.out.println("세번째 :"+score[2]);
            }

            answer = score[0] + score[1] + score[2];
            return answer;
        }
    }
}
