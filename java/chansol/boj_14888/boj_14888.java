package chansol.boj_14888;

import java.util.*;
//주어진 숫자 갯수 n이 최대 11개 까지 밖에 안됨. 사칙연산 4가지 라고 해도 생각보다 값이 안 많을거 같음.
//사실 애초에 백트래킹 문제임.
public class boj_14888 {
    static int N;
    static int MAX=-1000000000;         //최소 -10억
    static int MIN=1000000000;          //최대 10억
    static int value =0;
    static int[] num;
    static int[] cal;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        num = new int[N];
        cal = new int[4];
        for(int i=0; i<N; i++){
            num[i] = sc.nextInt();
        }
        for(int i=0; i<4; i++){
            cal[i] = sc.nextInt();      //+, - , *, /
        }

        back_tracking(num[0],1);        //1번째 수 와 depth+1번째 수

        System.out.println(MAX+"\n"+MIN);
    }

    private static void back_tracking(int value,int depth){
        if(depth == N ){      //연산자를 다 넣은 후
            MAX = Math.max(MAX,value);
            MIN = Math.min(MIN,value);
            return ;
        }

        for(int i=0; i<4; i++){
            if(cal[i]>0){
                cal[i]--;
                if(i==0) {
                    back_tracking(value + num[depth], depth + 1);
                }
                else if(i==1){
                    back_tracking(value-num[depth],depth+1);
                }
                else if(i==2){
                    back_tracking(value*num[depth],depth+1);
                }
                else{       //i==3
                    back_tracking(value/num[depth],depth+1);
                }

                cal[i]++;
            }

        }
    }


}