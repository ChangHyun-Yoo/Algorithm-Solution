import java.io.*;
import java.util.*;

public class Main {

    static int[] first;
    static int[] second;
    static List<Integer> sumF;
    static List<Integer> sumS;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        first =  new int[N / 2];
        second = new int[N - N / 2];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < first.length; i++) {
            first[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < second.length; i++) {
            second[i] = Integer.parseInt(st.nextToken());
        }

        sumF = new ArrayList<>();
        sumS = new ArrayList<>();

        dfs(0, 0, "f");
        dfs(0, 0, "s");

        Collections.sort(sumF);
        Collections.sort(sumS);

        int i = 0;
        int j = sumS.size() - 1;
        long answer = 0;

        while(i < sumF.size() && j >= 0) {
            if (sumF.get(i) + sumS.get(j) > S) {
                j--;
            } else if (sumF.get(i) + sumS.get(j) == S) {

                //first 의 upperBound
                int low = 0;
                int high = sumF.size();
                while(low < high) {
                    int mid = low + (high - low) / 2;
                    if(sumF.get(i) < sumF.get(mid)) {
                        high = mid;
                    } else {
                        low = mid + 1;
                    }
                }
                long x = low - i;
                i = low;
                //second 의 lowerBound
                low = 0;
                high = sumS.size();
                while(low < high) {
                    int mid = low + (high - low) / 2;
                    if(sumS.get(j) <= sumS.get(mid)) {
                        high = mid;
                    } else {
                        low = mid + 1;
                    }
                }
                long y = j - low + 1;
                answer += x * y;

                j = low - 1;
            } else {
                i++;
            }
        }


        //만약 S가 0이면 답 하나 빼야하지 않나?
        if(S == 0) {
            System.out.println(answer - 1);
        } else {
            System.out.println(answer);
        }
    }

    static void dfs(int current, int sum, String s) {
        if(s.equals("f")) {
            if(current == first.length) {
                sumF.add(sum);
            } else {
                dfs(current + 1, sum + first[current], s);
                dfs(current + 1, sum, s);
            }
        } else {
            if(current == second.length) {
                sumS.add(sum);
            } else {
                dfs(current + 1, sum + second[current], s);
                dfs(current + 1, sum, s);
            }
        }
    }
}
