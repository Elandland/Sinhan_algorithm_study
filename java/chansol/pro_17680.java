package chansol;

import java.util.*;

public class pro_17680 {
    class Solution {
        public int solution(int cacheSize, String[] cities) {
            int answer = 0;
            int cities_len = cities.length;
            Queue<String> cache = new LinkedList<>();

            for(int i =0; i<cities_len; i++){
                String check_city = cities[i].toUpperCase();
                if(cache.contains(check_city)){
                    answer+=1;
                    cache.remove(check_city);
                    cache.add(check_city);
                }
                else{
                    answer+=5;
                    if(cache.size()==cacheSize){
                        cache.poll();
                    }
                    cache.add(check_city);
                }

            }

            if(cacheSize==0){
                answer = cities.length*5;
            }

            return answer;
        }
    }
}
