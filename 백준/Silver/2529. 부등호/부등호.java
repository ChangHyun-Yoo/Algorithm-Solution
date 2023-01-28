import java.io.*;
import java.util.*;

public class Main {

    public static int N = 0;
    public static String maxStr = "";
    public static String minStr = "";
    public static long max = -1;
    public static long min = Long.MAX_VALUE;
    public static boolean[] visited;
    public static char[] info;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        info = new char[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++) {
            info[i] = st.nextToken().charAt(0);
        }
        visited = new boolean[10];

        for(int i = 0; i < 10; i++) {
            visited[i] = true;
            dfs(1, Integer.toString(i));
            visited[i] = false;
        }

        System.out.println(maxStr);
        System.out.println(minStr);
    }

    public static void dfs(int current, String lst) {
        if(current == N + 1) {//마지막
            long test = Long.parseLong(lst);
            if(max < test){
                max = test;
                maxStr = lst;
            }
            if(min > test) {
                min = test;
                minStr = lst;
            }
            return;
        }

        int test = Integer.parseInt(lst.substring(current - 1, current));
        char sign = info[current - 1];

        if(sign == '>') {
            for(int i = test - 1; i >= 0; i--) {
                if(!visited[i]) {
                    visited[i] = true;
                    dfs(current + 1, lst + i);
                    visited[i] = false;
                }
            }
        }

        if(sign == '<') {
            for(int i = test + 1; i < 10; i++) {
                if(!visited[i]) {
                    visited[i] = true;
                    dfs(current + 1, lst + i);
                    visited[i] = false;
                }
            }
        }
    }

}