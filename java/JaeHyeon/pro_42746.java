import java.util.*;
class pro_42746 {
    public String solution(int[] numbers) {
        String[] arr = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        if (arr[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();

        for (String i : arr) {
            sb.append(i);
        }

        return sb.toString();
    }
}