import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] place = new int[N + 2];

        if(N != 0) {
            st = new StringTokenizer(br.readLine());

            for (int i = 1; i < N + 1; i++) {
                place[i] = Integer.parseInt(st.nextToken());
            }
        }
        place[N + 1] = L;

        Arrays.sort(place);

        for(int i = place.length - 1; i > 0; i--) {
            place[i] -= place[i - 1] + 1;
        }

        int low = 1;
        int high = 1001;

        while(low < high) {
            int mid = low + (high - low) / 2;

            int need = 0;
            for(int i = 1; i < place.length; i++) {
                need += place[i] / mid;
            }

            if(need <= M) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(low);
    }

}


