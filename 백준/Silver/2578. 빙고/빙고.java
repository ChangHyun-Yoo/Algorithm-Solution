import java.util.*;
import java.io.*;

public class Main {

    static boolean[][] current = new boolean[5][5];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<Integer, Node> m = new HashMap<>();
        for(int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < 5; j++) {
                m.put(Integer.parseInt(st.nextToken()), new Node(i, j));
            }
        }

        for(int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < 5; j++) {
                Node node = m.get(Integer.parseInt(st.nextToken()));
                current[node.x][node.y] = true;

                if(num() >= 3) {
                    System.out.println(5 * i + j + 1);
                    return;
                }
            }
        }
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int num() {
        int answer = 0;
        if(current[0][0] && current[0][1] && current[0][2] && current[0][3] && current[0][4]) answer++;
        if(current[1][0] && current[1][1] && current[1][2] && current[1][3] && current[1][4]) answer++;
        if(current[2][0] && current[2][1] && current[2][2] && current[2][3] && current[2][4]) answer++;
        if(current[3][0] && current[3][1] && current[3][2] && current[3][3] && current[3][4]) answer++;
        if(current[4][0] && current[4][1] && current[4][2] && current[4][3] && current[4][4]) answer++;

        if(current[0][0] && current[1][0] && current[2][0] && current[3][0] && current[4][0]) answer++;
        if(current[0][1] && current[1][1] && current[2][1] && current[3][1] && current[4][1]) answer++;
        if(current[0][2] && current[1][2] && current[2][2] && current[3][2] && current[4][2]) answer++;
        if(current[0][3] && current[1][3] && current[2][3] && current[3][3] && current[4][3]) answer++;
        if(current[0][4] && current[1][4] && current[2][4] && current[3][4] && current[4][4]) answer++;

        if(current[0][0] && current[1][1] && current[2][2] && current[3][3] && current[4][4]) answer++;
        if(current[4][0] && current[3][1] && current[2][2] && current[1][3] && current[0][4]) answer++;

        return answer;
    }
}