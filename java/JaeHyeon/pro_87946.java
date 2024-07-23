class Solution {
    static int answer = 0;
    static boolean[] visit;

    public int solution(int k, int[][] dungeons) {

        visit = new boolean[dungeons.length];

        dfs(k, dungeons, 0);

        return answer;
    }

    static private void dfs(int fatigue, int[][] dungeon, int depth) {

        for (int i = 0; i < dungeon.length; i++) {

            if (!visit[i] && fatigue >= dungeon[i][0]) {
                visit[i] = true;
                dfs(fatigue-dungeon[i][1], dungeon, depth+1);
                visit[i] = false;
            }
        }

        answer = Math.max(answer, depth);
    }
}