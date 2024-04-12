package JaeHyeon;

import java.util.*;
import java.io.*;

public class Virus {
  static int computer;
  static int vertex;
  static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
  static int count = 0;
  static boolean[] visit;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    computer = Integer.parseInt(br.readLine());
    vertex = Integer.parseInt(br.readLine());

    visit = new boolean[computer+1];

    for (int i = 0; i <= computer; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < vertex; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int fromVertex = Integer.parseInt(st.nextToken());
      int toVertex = Integer.parseInt(st.nextToken());

      graph.get(fromVertex).add(toVertex);
      graph.get(toVertex).add(fromVertex);
    }

    bfs();

    bw.write(String.valueOf(count));
    bw.flush();
    bw.close();
  }

  static void bfs() {
    Queue<Integer> q = new LinkedList<>();

    q.offer(1);
    visit[1] = true;

    while (!q.isEmpty()) {

      int v = q.poll();

      for (int i = 0; i < graph.get(v).size(); i++) {
        int newHost = graph.get(v).get(i);

        if (!visit[newHost]) {
          visit[newHost] = true;
          q.offer(newHost);
          count += 1;
        }
      }
    }
  }
}
