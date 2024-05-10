import java.util.*;
import java.io.*;

public class Main {

    static int[] before;
    static boolean[] isMid;
    static int[] answer;
    static int[] needed;
    static List<List<Node>> roads = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        before = new int[N + 1];
        isMid = new boolean[N + 1];
        answer = new int[N + 1];
        needed = new int[N + 1];
        for(int i = 0; i < N + 1; i++) {
            roads.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            roads.get(X).add(new Node(Y, K));
            before[Y]++;
            isMid[X] = true;
        }

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(N, 1));
        while(!q.isEmpty()) {
            Node now = q.poll();
            answer[now.x] += now.val;

            for(Node next: roads.get(now.x)) {
                before[next.x]--;
                needed[next.x] += now.val * next.val;
                if(before[next.x] == 0) {
                    q.offer(new Node(next.x, needed[next.x]));
                }
            }
        }

        for(int i = 1; i < isMid.length; i++) {
            if(!isMid[i]) {
                System.out.println(i + " " + answer[i]);
            }
        }
    }

    static class Node {
        int x;
        int val;

        public Node(int x, int val) {
            this.x = x;
            this.val = val;
        }
    }
}