import java.io.*;
import java.util.*;

public class Main {

    static List<List<Integer>> nexts;
    static int[] beforeNum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int l = 0; l < T; l++) {
            int n = Integer.parseInt(br.readLine());
            int[] bOrder = new int[n + 1];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < n; i++) {
                bOrder[i + 1] = Integer.parseInt(st.nextToken());
            }
            nexts = new ArrayList<>();
            for(int i = 0; i < n + 1; i++) {
                nexts.add(new ArrayList<>());
            }
            for(int i = 1; i < n; i++) {
                for(int j = i + 1; j < n + 1; j++) {
                    nexts.get(bOrder[i]).add(bOrder[j]);
                }
            }

            int m = Integer.parseInt(br.readLine());
            for(int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int c1 = Integer.parseInt(st.nextToken());
                int c2 = Integer.parseInt(st.nextToken());
                if(nexts.get(c1).contains(c2)) {
                    nexts.get(c1).remove(Integer.valueOf(c2));
                    nexts.get(c2).add(c1);
                } else if(nexts.get(c2).contains(c1)) {
                    nexts.get(c2).remove(Integer.valueOf(c1));
                    nexts.get(c1).add(c2);
                }
            }
            beforeNum = new int[n + 1];
            for(int i = 1; i < n + 1; i++) {
                for(int c: nexts.get(i)) {
                    beforeNum[c]++;
                }
            }

            Queue<Integer> q = new LinkedList<>();
            for(int i = 1; i < beforeNum.length; i++) {
                if(beforeNum[i] == 0) {
                    q.offer(i);
                }
            }
            if(q.size() == 0) {
                sb.append("IMPOSSIBLE").append('\n');
                continue;
            }
            if(q.size() > 1) {
                sb.append("?").append('\n');
                continue;
            }

            boolean imp = false;
            boolean que = false;
            List<Integer> temp = new ArrayList<>();
            while(!q.isEmpty()) {
                int now = q.poll();
                temp.add(now);
                if(nexts.get(now).size() == 0) {
                    break;
                }
                int beforeSize = q.size();
                for(int next: nexts.get(now)) {
                    beforeNum[next]--;
                    if(beforeNum[next] == 0) {
                        q.offer(next);
                    }
                }
                int afterSize = q.size();
                if(afterSize - beforeSize == 0) {
                    sb.append("IMPOSSIBLE").append('\n');
                    imp = true;
                    break;
                }
                if(afterSize - beforeSize > 1) {
                    sb.append("?").append('\n');
                    que = true;
                    break;
                }
            }

            if(imp || que) {
                continue;
            } else {
                for(int t: temp) {
                    sb.append(t + " ");
                }
                sb.append('\n');
            }
        }
        System.out.println(sb);

    }

}
