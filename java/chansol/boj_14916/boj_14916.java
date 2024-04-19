package chansol.boj_14916;

import java.util.*;

public class boj_14916 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int money = sc.nextInt();
        int max_five = money/5;
        int no=0;
        int coin_count=100000;

        for(int i= max_five; i>=0; i--){
            if((money - (i*5)) %2 !=0) {
                no++;
                continue;
            }
            if(coin_count>i+ ((money - (i*5)) /2)) {
                coin_count = i + ((money - (i * 5)) / 2);
            }
        }
        if(no == max_five+1){
            System.out.println("-1");
            return;
        }

        System.out.println(coin_count);

    }
}
//처음엔 5원짜리 0개부터 했는데 이게 나을듯
