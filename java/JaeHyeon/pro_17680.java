import java.util.*;

class Solution {

    static List<String> list = new ArrayList<>();

    public int solution(int cacheSize, String[] cities) {

        int answer = 0;

        if (cacheSize == 0) {

            return cities.length * 5;
        }

        for (String city : cities) {

            String c = city.toUpperCase();

            if (list.contains(c)) {

                list.remove(c);
                list.add(c);

                answer += 1;
                continue;
            }

            if (list.size() >= cacheSize) {
                list.remove(0);
            }

            list.add(c);
            answer += 5;
        }

        return answer;
    }
}