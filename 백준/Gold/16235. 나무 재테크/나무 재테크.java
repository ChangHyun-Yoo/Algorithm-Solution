import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int K;
    static int[][] current;
    static int[][] A;
    static Deque<Tree> trees;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        current =  new int[N][N];
        for(int[] c: current) {
            Arrays.fill(c, 5);
        }
        A = new int[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        trees = new ArrayDeque<>();

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int z = Integer.parseInt(st.nextToken());

            trees.offer(new Tree(x, y, z));
        }

        for(int k = 0; k < K; k++) {
            Queue<Tree> live = new LinkedList<>();
            Queue<Tree> dead = new LinkedList<>();
            while(!trees.isEmpty()) {
                Tree tree = trees.poll();

                if(current[tree.x][tree.y] >= tree.age) {
                    current[tree.x][tree.y] -= tree.age;
                    tree.age++;
                    live.offer(tree);
                } else {
                    dead.offer(tree);
                }
            }

            while(!dead.isEmpty()) {
                Tree tree = dead.poll();
                current[tree.x][tree.y] += tree.age / 2;
            }

            while(!live.isEmpty()) {
                Tree tree = live.poll();
                if(tree.age % 5 == 0) {
                    wind(tree.x - 1, tree.y);
                    wind(tree.x + 1, tree.y);
                    wind(tree.x, tree.y - 1);
                    wind(tree.x, tree.y + 1);
                    wind(tree.x - 1, tree.y - 1);
                    wind(tree.x - 1, tree.y + 1);
                    wind(tree.x + 1, tree.y - 1);
                    wind(tree.x + 1, tree.y + 1);
                }
                trees.addLast(tree);
            }

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    current[i][j] += A[i][j];
                }
            }

        }

        System.out.println(trees.size());
    }

    static void wind(int x, int y) {
        if(x >= 0 && x < N && y >= 0 && y < N) {
            trees.addFirst(new Tree(x, y, 1));
        }
    }

    static class Tree {
        int x;
        int y;
        int age;

        public Tree(int x, int y, int age) {
            this.x = x;
            this.y = y;
            this.age = age;
        }
    }
}