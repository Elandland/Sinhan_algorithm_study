package chansol.pro_118666;
import java.util.*;

public class pro_118666 {

    class Solution {
        static String answer = "";
        public String solution(String[] survey, int[] choices) {
            int len = survey.length;      // =choices.length
            String score = " ";


            for(int i=0; i<len; i++){
                if(choices[i]<4){
                    for(int j=0; j<4-choices[i]; j++){
                        score += survey[i].charAt(0);
                    }
                }
                else if(choices[i]>4){
                    for(int k=0; k<choices[i]-4; k++){
                        score += survey[i].charAt(1);
                    }
                }
            }
            check(score,'R','T');
            check(score,'C','F');
            check(score,'J','M');
            check(score,'A','N');
            return answer;
        }

        private static void check(String score,char a,char b){
            int cnt1=0;
            int cnt2=0;

            for(int i=0; i<score.length(); i++){
                if(score.charAt(i)==a){
                    cnt1++;
                }
                else if(score.charAt(i)==b){
                    cnt2++;
                }
            }

            if(cnt1>cnt2){
                answer += a;
            }
            else if(cnt1<cnt2){
                answer += b;
            }
            else{
                answer += (char)Math.min(a,b);
            }
        }
    }
}
