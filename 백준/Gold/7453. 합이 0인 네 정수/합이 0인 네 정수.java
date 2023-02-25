import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] A = new int[n];
        int[] B = new int[n];
        int[] C = new int[n];
        int[] D = new int[n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);
        Arrays.sort(B);
        Arrays.sort(C);
        Arrays.sort(D);

        List<Integer> ab = new ArrayList<>();
        for(int a: A) {
            for(int b: B) {
                ab.add(a + b);
            }
        }

        List<Integer> cd = new ArrayList<>();
        for(int c: C) {
            for(int d: D) {
                cd.add(c + d);
            }
        }

        Collections.sort(ab);
        Collections.sort(cd);

        long l = 0;
        long r = cd.size() - 1;

        long answer = 0;

        while(l < ab.size() && r >= 0) {
            int num = ab.get((int) l) + cd.get((int) r);
            if(num == 0) {
                long low = 0;
                long high = ab.size();

                while(low < high) {
                    long mid = low + (high - low) / 2;
                    if(ab.get((int) l) >= ab.get((int) mid)) {
                        low = mid + 1;
                    } else {
                        high = mid;
                    }
                }

                long upper = low;

                low = 0;
                high = cd.size();

                while(low < high) {
                    long mid = low + (high - low) / 2;
                    if(cd.get((int) r) > cd.get((int) mid)) {
                        low = mid + 1;
                    } else {
                        high = mid;
                    }
                }

                long lower = low - 1;

                answer += (upper - l) * (r - lower);
                l = upper;
                r = lower;
            } else if(num < 0) {
                //l을 그 다음 value로 이동 -> upper bound
                long low = 0;
                long high = ab.size();

                while(low < high) {
                    long mid = low + (high - low) / 2;
                    if(ab.get((int) l) >= ab.get((int) mid)) {
                        low = mid + 1;
                    } else {
                        high = mid;
                    }
                }

                l = low;
            } else {
                //r을 그 전 value로 이동
                long low = 0;
                long high = cd.size();

                while(low < high) {
                    long mid = low + (high - low) / 2;
                    if(cd.get((int) r) > cd.get((int) mid)) {
                        low = mid + 1;
                    } else {
                        high = mid;
                    }
                }

                r = low - 1;
            }
        }
        System.out.println(answer);
    }
}