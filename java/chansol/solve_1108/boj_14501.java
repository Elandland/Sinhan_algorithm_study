package chansol.solve_1108;
import java.util.*;

public class boj_14501 {

    static int N;
    static int answer;

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        answer = 0;

        int[] date = new int[N];
        int[] pay = new int[N];
        boolean[] isCounsel = new boolean[N];

        for (int i = 0; i < N; i++) {
            date[i] = scanner.nextInt();
            pay[i] = scanner.nextInt();
        }

        counsel(date, pay, isCounsel, 0, 0);

        System.out.println(answer);
    }

    public static void counsel(int[] date, int[] pay, boolean[] isCounsel, int nowDate, int totalpay) {
        if (nowDate >= N) {
            answer = Math.max(totalpay, answer);
            return;
        }

        if (nowDate + date[nowDate] <= N && !isCounsel[nowDate]) {
            isCounsel[nowDate] = true;
            counsel(date, pay, isCounsel, nowDate + date[nowDate], totalpay + pay[nowDate]);
            isCounsel[nowDate] = false;
        }

        counsel(date, pay, isCounsel, nowDate + 1, totalpay);
    }
}