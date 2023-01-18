import java.io.*;
import java.util.*;

public class Main {
    public static List<List<Integer>> col = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] info = new int[N][M];
        List<List<Integer>> no = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++) {
                int k = Integer.parseInt(st.nextToken());
                info[i][j] = k;
                if(k == 0) {
                    List<Integer> a = new ArrayList<>();
                    a.add(i);
                    a.add(j);
                    no.add(a);
                }
                if(k == 2) {
                    queue.add(i);
                    queue.add(j);
                }
            }
        }

        List<Integer> now = new ArrayList<>();
        com(now,0, no.size());

        int max = -1;
        for(List<Integer> c: col) {
            int[][] copyInfo = new int[N][M];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    copyInfo[i][j] = info[i][j];
                }
            }
            for(int i: c) {
                int row = no.get(i).get(0);
                int col = no.get(i).get(1);
                copyInfo[row][col] = 1;
            }
            int cand = bfs(queue, copyInfo);
            if(cand > max)
                max = cand;
        }

        System.out.println(max);

    }

    public static int bfs(Queue<Integer> queue, int[][] info) {

        Queue<Integer> qq = new LinkedList<>();
        for(int q: queue) {
            qq.add(q);
        }
        while(!qq.isEmpty()) {
            int row = qq.poll();
            int col = qq.poll();
            try {
                if(info[row-1][col] == 0) {
                    info[row-1][col] = 2;
                    qq.add(row-1);
                    qq.add(col);
                }
            } catch(Exception e) {

            }
            try {
                if(info[row+1][col] == 0) {
                    info[row+1][col] = 2;
                    qq.add(row+1);
                    qq.add(col);
                }
            } catch(Exception e) {

            }
            try {
                if(info[row][col-1] == 0) {
                    info[row][col-1] = 2;
                    qq.add(row);
                    qq.add(col-1);
                }
            } catch(Exception e) {

            }
            try {
                if(info[row][col+1] == 0) {
                    info[row][col+1] = 2;
                    qq.add(row);
                    qq.add(col+1);
                }
            } catch(Exception e) {

            }
        }

        int safe = 0;
        for(int[] in: info) {
            for(int i: in) {
                if(i == 0)
                    safe++;
            }
        }

        return safe;
    }

    public static void com(List<Integer> now, int current, int length) {
        if(now.size() == 3) {
            col.add(now);
        } else if(length - current + now.size() == 3) {
            List<Integer> copied = new ArrayList<>();
            for(int n: now) {
                copied.add(n);
            }
            for(int j = current; j < length; j++) {
                copied.add(j);
            }
            col.add(copied);
        } else {
            List<Integer> copied1 = new ArrayList<>();
            for(int n: now) {
                copied1.add(n);
            }
            copied1.add(current);
            com(copied1, current + 1, length);
            List<Integer> copied2 = new ArrayList<>();
            for(int n: now) {
                copied2.add(n);
            }
            com(copied2, current + 1, length);
        }
    }

}