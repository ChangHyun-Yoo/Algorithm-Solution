import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int B = scanner.nextInt();

        int[] signal = new int[N];

        for(int i = 0; i < B; i++) {
            signal[scanner.nextInt() - 1] = 1;
        }

        int min = 100001;
        int left = 0;
        int right = K;
        int sum = 0;
        for(int i = 0; i < K; i++) {
            sum += signal[i];
        }

        if(N == K) {
            System.out.println(B);
            return;
        }

        while(true) {
            if(sum < min) {
                min = sum;
            }
            sum -= signal[left++];
            sum += signal[right++];
            if(right == N) {
                min = Math.min(min, sum);
                break;
            }
        }

        System.out.println(min);
    }

}