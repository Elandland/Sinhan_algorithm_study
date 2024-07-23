import java.util.*;

public class pro_86971 {

    static List<List<Integer>> tree = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;

    static public int solution(int n, int[][] wires) {

        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }

        for (int[] wire : wires) {
            tree.get(wire[0]).add(wire[1]);
            tree.get(wire[1]).add(wire[0]);
        }

        for (int i = 0; i < wires.length; i++) {

            boolean[] visit = new boolean[n+1];

            tree.get(wires[i][0]).remove(Integer.valueOf(wires[i][1]));
            tree.get(wires[i][1]).remove(Integer.valueOf(wires[i][0]));

            int count = dfs(1, visit);

            answer = Math.min(answer, Math.abs(count - (n - count)));

            tree.get(wires[i][0]).add(wires[i][1]);
            tree.get(wires[i][1]).add(wires[i][0]);
        }

        return answer;
    }

    private static int dfs(int start, boolean[] visit) {
        visit[start] = true;
        int cnt = 1;

        for (int nextVertex : tree.get(start)) {
            if (!visit[nextVertex]) {
                cnt += dfs(nextVertex, visit);
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(solution(9, new int[][]{{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}}));
    }
}
