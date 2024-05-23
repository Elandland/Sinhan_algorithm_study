package chansol.N과M;

import java.util.*;
import java.io.*;
public class boj_15651 {
    static int N;
    static int M;
    static int[] arr;

    static String temp="";
    public static void main(String[] args) throws IOException{
        // Scanner sc = new Scanner(System.in);      입력값이 작으면 얘가 더 유리하데. 무조건 버퍼 리더 안써도 될듯?
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        StringTokenizer st = new StringTokenizer(s);


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        back_tracking(0);

    }

    private static void back_tracking(int depth) {
        temp ="";
        if (depth == M) {
            for(int i=0; i<M; i++) {
                temp = temp + arr[i] + " ";
            }
            System.out.println(temp);
            return;
        }

        for(int i=0; i<N; i++){
            arr[depth] = i+1;
            back_tracking(depth + 1);

        }
    }
}

