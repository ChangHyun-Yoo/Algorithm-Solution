import java.io.*;
import java.util.*;

public class Main {

    public static Queue<Node> q;
    public static char[][] info;
    public static int answer = -1;
    public static boolean check = false;
    public static int N;
    public static int M;
    public static boolean[][][] v;

    static class Node {
        int row;
        int col;
        int length;
        int key;

        public Node(int row, int col, int length, int key) {
            this.row = row;
            this.col = col;
            this.length = length;
            this.key = key;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        info = new char[N][M];
        v = new boolean[N][M][64];
        int x = 0;
        int y = 0;
        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            for(int j = 0; j < M; j++) {
                char c = s.charAt(j);
                if(c == '0') {
                    x = i;
                    y = j;
                    info[i][j] = '.';
                } else
                    info[i][j] = c;
            }
        }
        v[x][y][0] = true;
        q = new LinkedList<>();
        Node start = new Node(x, y, 0, 0);
        q.add(start);

        while(!q.isEmpty()) {
            Node n = q.poll();

            if(n.row != 0) {
                move(n.row - 1, n.col, n.length, n.key);
            }

            if(n.col != 0) {
                move(n.row, n.col - 1, n.length, n.key);
            }

            if(n.row != N - 1) {
                move(n.row + 1, n.col, n.length, n.key);
            }

            if(n.col != M - 1) {
                move(n.row, n.col + 1, n.length, n.key);
            }

            if(check)
                break;
        }

        System.out.println(answer);
    }
    
    public static void move(int dx, int dy, int length, int key) {
        if(v[dx][dy][key]) {
            return;
        }
        switch(info[dx][dy]) {
            case '.':
                q.add(new Node(dx, dy, length + 1, key));
                v[dx][dy][key] = true;
                break;
            case 'a':
                q.add(new Node(dx, dy, length + 1, key | 32));
                v[dx][dy][key | 32] = true;
                break;
            case 'b':
                q.add(new Node(dx, dy, length + 1, key | 16));
                v[dx][dy][key | 16] = true;
                break;
            case 'c':
                q.add(new Node(dx, dy, length + 1, key | 8));
                v[dx][dy][key | 8] = true;
                break;
            case 'd':
                q.add(new Node(dx, dy, length + 1, key | 4));
                v[dx][dy][key | 4] = true;
                break;
            case 'e':
                q.add(new Node(dx, dy, length + 1, key | 2));
                v[dx][dy][key | 2] = true;
                break;
            case 'f':
                q.add(new Node(dx, dy, length + 1, key | 1));
                v[dx][dy][key | 1] = true;
                break;
            case 'A':
                if((key & 32) == 32) {
                    q.add(new Node(dx, dy, length + 1, key));
                    v[dx][dy][key] = true;
                }
                break;
            case 'B':
                if((key & 16) == 16) {
                    q.add(new Node(dx, dy, length + 1, key));
                    v[dx][dy][key] = true;
                }
                break;
            case 'C':
                if((key & 8) == 8) {
                    q.add(new Node(dx, dy, length + 1, key));
                    v[dx][dy][key] = true;
                }
                break;
            case 'D':
                if((key & 4) == 4) {
                    q.add(new Node(dx, dy, length + 1, key));
                    v[dx][dy][key] = true;
                }
                break;
            case 'E':
                if((key & 2) == 2) {
                    q.add(new Node(dx, dy, length + 1, key));
                    v[dx][dy][key] = true;
                }
                break;
            case 'F':
                if((key & 1) == 1) {
                    q.add(new Node(dx, dy, length + 1, key));
                    v[dx][dy][key] = true;
                }
                break;
            case '1':
                answer = length + 1;
                check = true;
                break;
            default:
                break;
        }
    }

}