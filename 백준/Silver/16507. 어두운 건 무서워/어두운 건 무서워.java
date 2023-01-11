import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int R = scanner.nextInt();
        int C = scanner.nextInt();
        int Q = scanner.nextInt();

        int sum = 0;
        int[] bright = new int[R*C];
        for(int i = 0; i < R*C; i++) {
            sum += scanner.nextInt();
            bright[i] = sum;
        }

        for(int k = 0; k < Q; k++) {
            int r1 = scanner.nextInt();
            int c1 = scanner.nextInt();
            int r2 = scanner.nextInt();
            int c2 = scanner.nextInt();

            int answer = 0;
            for(int i = r1; i <= r2; i++) {
                if((i - 1) * C + c1 - 1 - 1 < 0) {
                    answer += bright[(i - 1) * C + c2 - 1];
                } else {
                    answer += bright[(i - 1) * C + c2 - 1] - bright[(i - 1) * C + c1 - 1 - 1];
                }
            }
            System.out.println(answer / ((r2 - r1 + 1) * (c2 - c1 + 1)));
        }

    }

}