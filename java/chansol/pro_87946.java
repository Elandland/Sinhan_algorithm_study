package chansol;

public class pro_87946 {

    class Solution {

        boolean[] visit;
        int answer = -1;
        int dungeons_depth;

        public int solution(int k, int[][] dungeons) {
            dungeons_depth = dungeons.length;
            visit = new boolean[dungeons_depth];
            for(int i=0; i<dungeons_depth; i++){
                visit[i] = false;
            }

            dfs(k, dungeons, 0);

            return answer;
        }



        public void dfs(int k, int[][] dungeons, int clear){
            answer = Math.max(answer,clear);

            for(int i=0; i<dungeons_depth; i++){
                if(visit[i] == false && dungeons[i][0] <= k){       //무조건 최소 필요 필요도가 소모 피로도 보다 크므로 dungeons[i][0]만 비교해 주면 됨.
                    visit[i] = true;
                    dfs(k - dungeons[i][1], dungeons, clear+1);
                    visit[i] = false;
                }
            }
        }



    }
}
