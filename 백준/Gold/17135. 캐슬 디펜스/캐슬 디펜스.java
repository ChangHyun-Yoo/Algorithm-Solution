import java.io.*;
import java.util.*;

public class Main {

    private static List<int[]> cand = new ArrayList<>();
    private static int N;
    private static int max = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int[][] invaders = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++)
                invaders[i][j] = Integer.parseInt(st.nextToken());
        }

        boolean[] visited = new boolean[M];
        int[] current = new int[3];
        com(visited, 0, current, 0);

        for(int[] cc: cand) {
            game(cc, invaders, D, 0);
        }

        System.out.println(max);
    }

    public static void game(int[] cc, int[][] info, int D, int removed) {
        boolean finish = true;
        for(int i = 0; i < info.length; i++)
            for(int j = 0; j < info[0].length; j++)
                if(info[i][j] != 0)
                    finish = false;
        if(finish) {
            if(max < removed)
                max = removed;
        } else {
            Queue<Integer> remove = new LinkedList<>();
            for(int c: cc) {
                boolean exist = false;

                for(int i = 1; i <= D; i++) {
                    for(int j = 1 - i; j <= i - 1; j++) {
                        int row = N - (i - Math.abs(j));
                        int col = c + j;
                        try {
                            if(info[row][col] == 1) {
                                remove.add(row);
                                remove.add(col);
                                exist = true;
                                break;
                            } else {
                                continue;
                            }
                        } catch(Exception e) {
                            continue;
                        }
                    }
                    if(exist)
                        break;
                }
            }

            int[][] copy = new int[info.length][info[0].length];
            for(int i = 0; i < N; i++) {
                copy[i] = info[i].clone();
            }
            while(!remove.isEmpty()) {
                int row = remove.poll();
                int col = remove.poll();
                if(copy[row][col] == 0)
                    continue;
                else {
                    copy[row][col] = 0;
                    removed++;
                }
            }
            int[] zero = new int[info[0].length];
            for(int k = N - 2; k >= 0; k--) {
                copy[k + 1] = copy[k].clone();
            }
            copy[0] = zero;
            game(cc, copy, D, removed);
        }
    }

    public static void com(boolean[] visited, int currentIndex, int[] current, int p) {
        if(p == 3) {
            cand.add(current);
        } else if(currentIndex == visited.length) {

        } else {
            boolean[] copy1 = visited.clone();
            copy1[currentIndex] = true;
            int[] ccopy1 = current.clone();
            ccopy1[p] = currentIndex;
            com(copy1, currentIndex + 1, ccopy1, p + 1);
            boolean[] copy2 = visited.clone();
            int[] ccopy2 = current.clone();
            com(copy2, currentIndex + 1, ccopy2, p);
        }
    }
}