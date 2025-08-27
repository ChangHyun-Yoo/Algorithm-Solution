import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.*;
import java.io.*;

public class Main {

    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> choices = new ArrayList<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Node> homes = new ArrayList<>();
        List<Node> stores = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());

                // home
                if(value == 1) {
                    homes.add(new Node(i, j));
                }
                // store
                else if(value == 2) {
                    stores.add(new Node(i, j));
                }
            }
        }

        dfs(0, 0, choices, stores, homes, M);

        System.out.println(answer);
    }

    static void dfs(int current, int chosenNum, List<Integer> choices, List<Node> stores, List<Node> homes, int M) {
        if(current == stores.size() && chosenNum != 0) {
            int city = 0;
            for(Node home: homes) {
                int min = Integer.MAX_VALUE;
                for(int j = 0; j < stores.size(); j++) {
                    if(choices.get(j) == 1) {
                        min = Math.min(min, Math.abs(stores.get(j).x - home.x) + Math.abs(stores.get(j).y - home.y));
                    }
                }
                city += min;
            }

            answer = Math.min(answer, city);
            return;
        } else if(current == stores.size() && chosenNum == 0) return;

        if(chosenNum < M) {
            choices.add(1);
            dfs(current + 1, chosenNum + 1, choices, stores, homes, M);
            choices.remove(choices.size() - 1);
        }
        choices.add(0);
        dfs(current + 1, chosenNum, choices, stores, homes, M);
        choices.remove(choices.size() - 1);

    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}


