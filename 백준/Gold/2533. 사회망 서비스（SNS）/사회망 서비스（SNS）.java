import java.util.*;
import java.io.*;

public class Main {

    static List<List<Integer>> roads;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        roads = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            roads.add(new ArrayList<>());
        }
        visited = new boolean[N + 1];

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            roads.get(u).add(v);
            roads.get(v).add(u);
        }

        int[] result = dfs(1);

        System.out.println(Math.min(result[0], result[1]));
    }

    static int[] dfs(int c) {
        visited[c] = true;
        int[] result = new int[2];

        int num = 0;
        for(int i = 0; i < roads.get(c).size(); i++) {
            int next = roads.get(c).get(i);
            if(!visited[next]) num++;
        }

        if(num == 0) {
            result[0] = 0;
            result[1] = 1;
        } else {
            int no = 0;
            int yes = 0;
            for(int i = 0; i < roads.get(c).size(); i++) {
                int next = roads.get(c).get(i);
                if(!visited[next]) {
                    int[] r = dfs(next);
                    no += r[1];
                    yes += Math.min(r[0], r[1]);
                }
            }
            result[0] = no;
            result[1] = yes + 1;
        }
        return result;
    }
}