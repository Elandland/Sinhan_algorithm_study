package chansol.boj_17291;

import java.util.Scanner;

public class boj_17291_new {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int year = sc.nextInt();

        int[] year_bug = new int[year+1];

        if(year>=1) {
            year_bug[1] = 1;        //1년말
        }
        if(year>=2) {
            year_bug[2] = 2;        //2년말
        }

        for(int i=3; i<=year; i++){
            if(i%2!=0) {
                year_bug[i] = year_bug[i - 1] * 2;
            }
            else {
                year_bug[i]=year_bug[i-1]+year_bug[i-2]+year_bug[i-3];
            }
        }
        System.out.println(year_bug[year]);

    }
}
