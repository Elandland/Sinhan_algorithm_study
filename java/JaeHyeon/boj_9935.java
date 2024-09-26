import java.io.*;
import java.util.Stack;

public class boj_9935 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        String check = br.readLine();

        Stack<Character> stack = new Stack<>();

        O: for (int i = 0; i < input.length(); i++) {

            stack.push(input.charAt(i));

            if (stack.size() >= check.length()) {

                for (int j = 0; j < check.length(); j++) {

                    if(stack.get(stack.size() - check.length() + j) != check.charAt(j)) {
                        continue O;
                    }
                }

                for (int j = 0; j < check.length(); j++) {
                    stack.pop();
                }
            }
        }

        if (stack.isEmpty()) {
            bw.write("FRULA");
        } else {
            StringBuilder sb = new StringBuilder();
            for (Character c : stack) {
                sb.append(c);
            }
            bw.write(sb.toString());
        }

        bw.flush();
        bw.close();
    }
}
