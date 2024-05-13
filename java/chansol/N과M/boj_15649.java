package chansol.N과M;

import java.util.*;
import java.io.*;
public class boj_15649 {
    static int N;
    static int M;
    static boolean[] visit;
    static int[] arr;
    public static void main(String[] args) throws IOException{
       // Scanner sc = new Scanner(System.in);      입력값이 작으면 얘가 더 유리하데. 무조건 버퍼 리더 안써도 될듯?
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        StringTokenizer st = new StringTokenizer(s);


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visit = new boolean[N];     //어떤게 중복됐는지 확인 용.
        arr = new int[M];
        back_tracking(0);

    }

    private static void back_tracking(int depth) {

        if (depth == M) {
            for(int i=0; i<M; i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println("");
            return;
        }

        for(int i=0; i<N; i++){
            if(!visit[i]) {
                visit[i] = true;
                arr[depth] = i+1;
                back_tracking(depth + 1);
                visit[i] = false;
            }
        }
    }
}


