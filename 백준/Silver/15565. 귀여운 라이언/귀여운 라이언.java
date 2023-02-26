import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] lst = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            lst[i] = Integer.parseInt(st.nextToken());
        }

        int l = 0;
        int r = 0;
        int lion = 0;
        if(lst[0] == 1) {
            lion = 1;
        }

        int min = Integer.MAX_VALUE;
        while(l <= r) {
            if(lion >= K) {
                min = Math.min(min, r - l + 1);
                if(lst[l] == 1) {
                    lion--;
                }
                l++;
            } else {
                if(r != lst.length - 1)
                    r++;
                else
                    break;
                if(lst[r] == 1) {
                    lion++;
                }
            }
        }
        
        if(min == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(min);
    }
}