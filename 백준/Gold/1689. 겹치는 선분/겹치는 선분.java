import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] info = new int[2 * N][2];
        for(int i = 0 ; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            info[i][0] = start;
            info[i][1] = 1;
            info[i + N][0] = end;
            info[i + N][1] = -1;
        }

        Arrays.sort(info, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });

        int max = 0;
        int count = 0;
        for(int i = 0; i < info.length; i++) {
            count += info[i][1];
            max = Math.max(max, count);
        }
        System.out.println(max);
    }
}