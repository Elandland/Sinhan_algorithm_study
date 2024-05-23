package chansol.N과M;

import java.util.*;
import java.io.*;
public class boj_15651 {
    static int N;
    static int M;
    static int[] arr;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));   //할당된 버퍼에 값 넣어주기

    public static void main(String[] args) throws IOException{
        // Scanner sc = new Scanner(System.in);      입력값이 작으면 얘가 더 유리하데. 무조건 버퍼 리더 안써도 될듯?
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //버퍼에 있는 값 전부 출력


        String s = br.readLine();

        StringTokenizer st = new StringTokenizer(s);


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        back_tracking(0);

        bw.flush();
        bw.close();
    }

    private static void back_tracking(int depth) throws IOException {

        StringBuilder sb = new StringBuilder();


        if (depth == M) {
            for(int i=0; i<M; i++) {
                sb.append(arr[i]).append(" ");
            }
            bw.write(String.valueOf(sb)+"\n");
            return;
        }

        for(int i=0; i<N; i++){
            arr[depth] = i+1;
            back_tracking(depth + 1);

        }
    }
}

