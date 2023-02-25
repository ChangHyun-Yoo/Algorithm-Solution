import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] visited = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            visited[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for(int i = 0; i < X; i++) {
            sum += visited[i];
        }

        int max = 0;
        int count = 0;
        int l = 0;
        int r = X - 1;
        while(true) {
            if(max < sum) {
                max = sum;
                count = 1;
            } else if(max == sum) {
                count++;
            }

            sum -= visited[l];
            l++;
            r++;
            if(r == visited.length)
                break;
            sum += visited[r];
        }

        if(max == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(max);
            System.out.println(count);
        }
    }
}