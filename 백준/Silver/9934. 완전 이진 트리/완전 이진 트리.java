import java.io.*;
import java.util.*;

public class Main {

    static int[] tree;
    static int[] value;
    static int K;
    static int index = 0;
    static StringBuilder sb = new StringBuilder();
    static List<List<Integer>> l = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        tree = new int[(int) Math.pow(2, K)];
        value = new int[(int) Math.pow(2, K) - 1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < value.length; i++) {
            value[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < K; i++) {
            l.add(new ArrayList<>());
        }

        insert(1);
        search(1, 0);

        for(List<Integer> ll: l) {
            for(int lll: ll) {
                sb.append(lll + " ");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static void insert(int current) {
        if(current >= (int) Math.pow(2, K)) return;

        insert(current * 2);
        tree[current] = value[index++];
        insert(current * 2 + 1);
    }

    static void search(int current, int depth) {
        if(current >= (int) Math.pow(2, K)) return;

        l.get(depth).add(tree[current]);
        search(current * 2, depth + 1);
        search(current * 2 + 1, depth + 1);
    }
}

