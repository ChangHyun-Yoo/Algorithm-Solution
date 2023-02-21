import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] lst = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
            lst[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());


        Arrays.sort(lst);

        int left = 0;
        int right = n - 1;

        int answer = 0;
        while(left != right) {
            if(lst[left] + lst[right] == x) {
                answer++;
                left++;
            } else if(lst[left] + lst[right] > x) {
                right--;
            } else {
                left++;
            }
        }
        System.out.println(answer);
    }
}
