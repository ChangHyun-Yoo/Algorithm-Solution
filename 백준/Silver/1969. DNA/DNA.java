import java.io.*;
import java.util.*;

public class Main {

    static String answer = "";
    static int min = Integer.MAX_VALUE;

    static class Node implements Comparable<Node> {
        String s;
        int num;

        public Node(String s, int num) {
            this.s = s;
            this.num = num;
        }

        public int compareTo(Node n) {
            if(this.num == n.num) {
                return this.s.compareTo(n.s);
            } else {
                return n.num - this.num;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] dnas = new char[N][M];

        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            for(int j = 0; j < M; j++) {
                dnas[i][j] = s.charAt(j);
            }
        }

        for(int i = 0; i < M; i++) {
            int A = 0;
            int C = 0;
            int G = 0;
            int T = 0;
            for(int j = 0; j < N; j++) {
                if(dnas[j][i] == 'A') {
                    A++;
                } else if(dnas[j][i] == 'C') {
                    C++;
                } else if(dnas[j][i] == 'G') {
                    G++;
                } else {
                    T++;
                }
            }

            List<Node> lst = new ArrayList<>();
            lst.add(new Node("A", A));
            lst.add(new Node("C", C));
            lst.add(new Node("G", G));
            lst.add(new Node("T", T));
            Collections.sort(lst);

            answer += lst.get(0).s;
        }
        int min = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(dnas[i][j] != answer.charAt(j)) min++;
            }
        }

        System.out.println(answer);
        System.out.println(min);
    }
}