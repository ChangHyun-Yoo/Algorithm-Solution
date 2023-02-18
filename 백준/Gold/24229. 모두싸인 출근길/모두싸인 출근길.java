import java.io.*;
import java.util.*;

public class Main {

    static int[][] info;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        info = new int[N][2];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            info[i][0] = start;
            info[i][1] = end;
        }

        Arrays.sort(info, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else
                    return o1[0] - o2[0];
            }
        });

        List<int[]> q = new ArrayList<>();

        int start = info[0][0];
        int end = info[0][1];
        for(int i = 1; i < N; i++) {
            if(end >= info[i][0]) {
                end = Math.max(end, info[i][1]);
            } else {
                int[] lst = new int[3];
                lst[0] = start;
                lst[1] = end;
                lst[2] = end + end - start;
                q.add(lst);
                start = info[i][0];
                end = info[i][1];
            }
        }
        int[] lst = new int[3];
        lst[0] = start;
        lst[1] = end;
        lst[2] = end + end - start;
        q.add(lst);

        int e = q.get(0)[1];
        int m = q.get(0)[2];
        for(int i = 1; i < q.size(); i++) {
            if(q.get(i)[0] > m) {//점프 불가능할 경우
                System.out.println(e);
                return;
            } else {//점프가 가능할경우
                int maxIndex = -1;
                int max = -1;
                int j;
                for(j = i; j < q.size(); j++) {
                    if(q.get(j)[0] <= m) {//점프가 가능
                        if(max < q.get(j)[2]) {
                            max = q.get(j)[2];
                            maxIndex = j;
                        }
                    } else {
                        break;
                    }
                }
                e = q.get(maxIndex)[1];
                m = q.get(maxIndex)[2];
                i = maxIndex;
            }
        }

        System.out.println(e);
    }
}