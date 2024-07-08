import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[][] info;
    static int[][] childs;
    static boolean[] before;
    static int[] columns;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        info = new int[2][10001];
        childs = new int[N + 1][2];
        before = new boolean[N + 1];
        columns = new int[N + 1];

        Arrays.fill(info[0], Integer.MAX_VALUE);
        Arrays.fill(info[1], Integer.MIN_VALUE);

        for(int i = 1; i < N + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int parent = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            childs[parent][0] = left;
            childs[parent][1] = right;
            if(left != -1) before[left] = true;
            if(right != -1) before[right] = true;
        }

        int root = -1;
        for(int i = 1; i < before.length; i++) {
            if(!before[i]) {
                root = i;
                break;
            }
        }

        left(root);

        dfs(root, 1, 0, true);

        int level = 0;
        int max = -1;
        for(int i = 1; i < 10001; i++) {
            if(info[0][i] == Integer.MAX_VALUE) break;

            if(info[1][i] - info[0][i] + 1 > max) {
                level = i;
                max = info[1][i] - info[0][i] + 1;
            }
        }

        System.out.println(level + " " + max);
    }

    static void dfs(int current, int level, int col, boolean left) {
        if(left) {
            col += columns[current] - 1;
            info[0][level] = Math.min(info[0][level], col);
            info[1][level] = Math.max(info[1][level], col);

            if(childs[current][0] != -1) dfs(childs[current][0], level + 1, col, true);
            if(childs[current][1] != -1) dfs(childs[current][1], level + 1, col, false);
        } else {
            col += columns[current] + 1;
            info[0][level] = Math.min(info[0][level], col);
            info[1][level] = Math.max(info[1][level], col);

            if(childs[current][0] != -1) dfs(childs[current][0], level + 1, col, true);
            if(childs[current][1] != -1) dfs(childs[current][1], level + 1, col, false);
        }
    }

    static int left(int current) {
        int result = 1;

        if(childs[current][0] != -1) {
            result += left(childs[current][0]);
        }
        if(childs[current][1] != -1) {
            int r = right(childs[current][1]);
            result += r;
            columns[current] = - r;
        }

        return result;
    }

    static int right(int current) {
        int result = 1;

        if(childs[current][0] != -1) {
            int l = left(childs[current][0]);
            result += l;
            columns[current] = l;
        }
        if(childs[current][1] != -1) {
            result += right(childs[current][1]);
        }

        return result;
    }
}
