import java.io.*;
import java.util.*;

public class Main {

    private static int max = -1;
    private static List<int[]> cand = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] info = new int[N][N];

        int min = 100000;

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                info[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] team = new int[N / 2];
        bfs(0, team, info, 0);

        List<Integer> answer = new ArrayList<>();

        for(int[] c:cand) {
            int sum = 0;
            for(int i = 0; i < c.length - 1; i++) {
                for(int j = i + 1; j < c.length; j++) {
                    sum += info[c[i]][c[j]] + info[c[j]][c[i]];
                }
            }
            answer.add(sum);
        }

        for(int i = 0; i < answer.size() / 2; i++) {
            if(min > Math.abs(answer.get(i) - answer.get(answer.size() - i - 1))) {
                min = Math.abs(answer.get(i) - answer.get(answer.size() - i - 1));
            }
        }

        System.out.println(min);
    }

    public static void bfs(int current, int[] team, int[][] info, int person) {
        if(person == team.length) {
            cand.add(team);
        } else if(info.length - current == team.length - person) {
            int c = current;
            for(int i = person; i < team.length; i++) {
                team[i] = c;
                c++;
            }
            cand.add(team);
        } else {
            int[] copy2 = team.clone();
            copy2[person] = current;
            bfs(current + 1, copy2, info, person + 1);
            int[] copy1 = team.clone();
            bfs(current + 1, copy1, info, person);
        }
    }

}