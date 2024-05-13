package chansol.pro_258712;
import java.util.*;
public class pro_258712 {
    class Solution {
        public int solution(String[] friends, String[] gifts) {
            int answer = 0;
            int gift =0;
            int gifts_len = gifts.length;
            int friends_len = friends.length;
            HashMap<String,Integer>gift_point = new HashMap<String,Integer>();

            int[][] arr = new int[friends_len][friends_len];

            //그냥 진짜 문제 설명에 있는 그대로를 구현해서 풀었습니다 허허..
            //다른 사람 풀이 보니까 이거도 맵 처리해서 풀던데 맵 너무 어렵네..
            for(int i=0; i<gifts_len; i++){
                String[] name = gifts[i].split(" ");
                for(int j=0; j<friends_len; j++){
                    if(name[0].equals(friends[j])){
                        for(int k=0; k<friends_len; k++){
                            if(name[1].equals(friends[k])){
                                arr[j][k]++;
                            }
                        }
                    }
                }
            }


            for(int i=0; i<friends_len; i++){
                gift_point.put(friends[i],0);
            }
            for(int i=0; i<gifts_len; i++){
                String[] name = gifts[i].split(" ");
                // gift_point.get(name[0])++; 이건 안되네
                gift_point.put(name[0], gift_point.get(name[0])+1);
                gift_point.put(name[1], gift_point.get(name[1])-1);
            }

            for(int i=0; i<friends_len; i++){
                for(int j=0; j<friends_len; j++){
                    if(i!=j&&arr[i][j]> arr[j][i]){
                        gift++;
                    }
                    else if(i!=j&&arr[i][j]==arr[j][i]){
                        if(gift_point.get(friends[i])>gift_point.get(friends[j])){
                            gift++;
                        }
                    }
                }
                answer=  Math.max(answer,gift);
                gift =0;
            }


            return answer;
        }
    }
}
