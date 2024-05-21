import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int M;
    static List<List<Integer>> fav = new ArrayList<>();
    static List<Integer> chickens = new ArrayList<>();
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N + 1; i++) {
            fav.add(new ArrayList<>());
        }
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++) {
                fav.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }

        dfs(1);

        System.out.println(answer);
    }

    static void dfs(int current) {
        if(chickens.size() == 3) {
            answer = Math.max(answer, checkMax());
            return;
        }

        for(int i = current; i <= M; i++) {
            chickens.add(i);
            dfs(i + 1);
            chickens.remove(chickens.size() - 1);
        }
    }

    static int checkMax() {
        int val = 0;
        for(int i = 1; i <= N; i++) {
            int max = 0;
            for(int j = 0; j < chickens.size(); j++) {
                if(max < fav.get(i).get(chickens.get(j) - 1)) max = fav.get(i).get(chickens.get(j) - 1);
            }
            val += max;
        }
        return val;
    }
}
