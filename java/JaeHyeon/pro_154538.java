import java.util.*;

class pro_154538 {

    static Set<Integer> set = new HashSet<>();

    public int solution(int x, int y, int n) {

        if (x == y) {
            return 0;
        }

        if (x + n > y || x * 2 > y) {
            return -1;
        }

        if (x+n == y || x*2 == y || x*3 == y) {
            return 1;
        }

        int result = bfs(x, y, n);

        return result;
    }

    static private int bfs(int x, int y, int n) {

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{x+n, 1});
        q.offer(new int[]{x*2, 1});
        q.offer(new int[]{x*3, 1});

        while (!q.isEmpty()) {

            int[] arr = q.poll();

            if (arr[0] > y) {
                continue;
            }

            for (int i = 0; i < 3; i++) {

                int check;

                if (i == 0) {
                    check = arr[0] + n;
                } else if (i == 1) {
                    check = arr[0] * 2;
                } else {
                    check = arr[0] * 3;
                }
                if (check == y) {
                    return arr[1]+1;
                } else if (set.contains(check)) {
                    continue;
                }

                set.add(check);
                q.offer(new int[]{check, arr[1]+1});
            }
        }

        return -1;
    }
}
