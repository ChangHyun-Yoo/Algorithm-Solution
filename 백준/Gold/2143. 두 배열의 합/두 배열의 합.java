import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long T = Long.parseLong(br.readLine());
        long n = Long.parseLong(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        List<Integer> A = new ArrayList<>();
        A.add(0);
        int i = 0;
        while(st.hasMoreTokens()) {
            A.add(Integer.parseInt(st.nextToken()) + A.get(i++));
        }
        long m = Long.parseLong(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        List<Integer> B = new ArrayList<>();
        B.add(0);
        i = 0;
        while(st.hasMoreTokens()) {
            B.add(Integer.parseInt(st.nextToken()) + B.get(i++));
        }
        Map<Long, Long> tableA = new HashMap<>();
        for(int j = 0; j < n; j++) {
            for(int k = j + 1; k <= n; k++) {
                long test = A.get(k) - A.get(j);
                if(tableA.get(test) == null) {
                    tableA.put(test, (long) 1);
                } else {
                    tableA.replace(test, tableA.get(test) + 1);
                }
            }
        }
        Map<Long, Long> tableB = new HashMap<>();
        for(int j = 0; j < m; j++) {
            for(int k = j + 1; k <= m; k++) {
                long test = B.get(k) - B.get(j);
                if(tableB.get(test) == null) {
                    tableB.put(test, (long) 1);
                } else {
                    tableB.replace(test, tableB.get(test) + 1);
                }
            }
        }
        Set<Long> setA = tableA.keySet();
        long answer = 0;
        for(long s: setA) {
            if(tableB.get(T - s) != null) {
                answer += tableA.get(s) * tableB.get(T - s);
            }
        }
        System.out.println(answer);
    }

}