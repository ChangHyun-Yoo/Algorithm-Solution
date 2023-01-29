import java.io.*;
import java.util.*;

public class Main {

    public static int R = 0;
    public static int C = 0;
    public static int answer = 0;
    public static char[][] info;
    public static List<Character> visited = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        info = new char[R][C];
        for(int i = 0; i < R; i++) {
            info[i] = br.readLine().toCharArray();
        }

        visited.add(info[0][0]);
        dfs(1, 0, 0);

        System.out.println(answer);
    }

    public static void dfs(int current, int row, int col) {
        boolean progress = false;
        try {
            if(!visited.contains(info[row+1][col])) {
                progress = true;
                visited.add(info[row+1][col]);
                dfs(current + 1,row + 1, col);
                visited.remove(visited.size() - 1);
            }
        } catch(Exception e) {

        }
        try {
            if(!visited.contains(info[row-1][col])) {
                progress = true;
                visited.add(info[row-1][col]);
                dfs(current + 1, row - 1, col);
                visited.remove(visited.size() - 1);
            }
        } catch(Exception e) {

        }
        try {
            if(!visited.contains(info[row][col+1])) {
                progress = true;
                visited.add(info[row][col+1]);
                dfs(current + 1, row, col+1);
                visited.remove(visited.size() - 1);
            }
        } catch(Exception e) {

        }
        try {
            if(!visited.contains(info[row][col-1])) {
                progress = true;
                visited.add(info[row][col-1]);
                dfs(current + 1, row, col-1);
                visited.remove(visited.size() - 1);
            }
        } catch(Exception e) {

        }

        if(!progress)
            if(current > answer)
                answer = current;
    }

}