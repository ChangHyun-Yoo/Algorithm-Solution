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

        int odd = 0;
        int even = 0;
        int max = -1;
        if(lst[0] % 2 == 0)
            even++;
        else
            odd++;

        while(true) {
            if(odd <= K) {
                if(max < r - l + 1 - odd) {
                    max = r - l + 1 - odd;
                }
                if(r != N - 1) {
                    r++;
                    if(lst[r] % 2 == 0)
                        even++;
                    else
                        odd++;
                } else {
                    break;
                }
            } else {
                if(lst[l] % 2 == 0)
                    even--;
                else
                    odd--;
                l++;
            }
        }

        System.out.println(max);
    }
}
