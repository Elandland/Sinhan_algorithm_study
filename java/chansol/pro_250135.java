package chansol;

public class pro_250135 {
    class Solution {
        public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
            int answer = 0;

            double hourDegree = 360.0 / 43200.0;
            double minuteDegree = 0.1;
            double secondDegree = 6.0;

            int startTime = h1 * 3600 + m1 * 60 + s1;
            int endTime = h2 * 3600 + m2 * 60 + s2;

            int duration = endTime - startTime;

            double prevHour = ((h1 % 12) * 3600 + m1 * 60 + s1) * hourDegree;
            double prevMinute = (m1 * 60 + s1) * minuteDegree;
            double prevSecond = s1 * secondDegree;


            //12시 0분 0초 이거나 24시 0분 0초일때
            if((startTime/3600==12&&startTime%3600==0)||(startTime/3600==0&&startTime%3600==0)){
                answer++;
            }


            for (int t = 0; t < duration; t++) {
                double hour = (prevHour+hourDegree)%360;
                double min = (prevMinute+minuteDegree)%360;
                double sec = (prevSecond+secondDegree)%360;

                if(hour<0.000001){
                    hour = 360;
                }
                if(min<0.000001){
                    min = 360;
                }
                if(sec<0.000001){
                    sec = 360;
                }


                if(prevSecond<prevMinute&&sec>=min){
                    answer++;

                }
                if(prevSecond<prevHour&&sec>=hour||prevSecond==360&&sec>=hour){
                    answer++;

                }
                if(Math.abs(min-hour)<0.000001){
                    answer--;
                }
                if(Math.abs(min-hour)<0.000001&&Math.abs(min-sec)<0.000001&&!(endTime/3600==12&&endTime%3600==0)||(endTime/3600==0&&endTime%3600==0)){
                    answer--;
                }

                prevSecond = sec;
                prevMinute = min;
                prevHour = hour;

            }

            return answer;
        }
    }

}
