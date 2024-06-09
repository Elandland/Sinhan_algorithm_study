package chansol;
import java.util.*;

public class pro_42839 {
        static int answer = 0;
        static boolean[] visit;     //중복 확인 용
        static int num_len;
        //static int[] made_num;
        static ArrayList<Integer> made_num = new ArrayList<>();
        public int solution(String numbers) {

            num_len = numbers.length();
            String [] arr = numbers.split("");
            visit = new boolean[num_len];


            for(int i=0; i<num_len; i++){
                back_tracking(arr,"",i+1);
            }

            for(int i=0; i<made_num.size(); i++){
                // prime_num(made_num[i]);     만들어진 수 를 담는걸 배열으로 하니까 길이를 어케 정해야될지 모르겠네 list로 해야될 듯?
                prime_num(made_num.get(i));
                // System.out.println(made_num.get(i));
            }

            return answer;
        }

        private static void back_tracking(String[] arr,String temp,int len){
            if(temp.length() == len){
                int num = Integer.parseInt(temp);
                if(!made_num.contains(num)){
                    made_num.add(num);
                }
            }

            for(int i=0; i<num_len; i++){
                if(!visit[i]){
                    visit[i] = true;
                    temp += arr[i];
                    back_tracking(arr, temp, len);
                    visit[i] = false;
                    temp = temp.substring(0, temp.length()-1);
                }
            }
        }

        //소수 구하는 부분이 문제인듯? 33점나옴

        private static void prime_num(int num){
            int cnt = 0;

            if(num==1){
                return;
            }
            else if(num==2){
                answer++;
                return;
            }
            else{
                for(int i=2; i<num; i++){
                    if(num % i ==0){
                        cnt++;
                        break;
                    }
                }
                if(cnt ==0&&num!=0){
                    answer++;
                }
            }
        }

    }

