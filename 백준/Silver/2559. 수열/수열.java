import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int repeat = scanner.nextInt();
        int length = scanner.nextInt();

        List<Integer> lst = new ArrayList<>();

        for(int i = 0; i < repeat; i++) {
            lst.add(scanner.nextInt());
        }

        int sum = 0;
        int max = -100 * repeat;
        int left = 0;
        int right = length;
        for(int i = 0; i < length; i++) {
            sum += lst.get(i);
        }

        max = sum;

        while(repeat != length) {
            if(max < sum) {
                max = sum;
                sum -= lst.get(left++);
                sum += lst.get(right++);
                if(right == repeat) {
                    max = Math.max(max, sum);
                    break;
                }
            } else {
                sum -= lst.get(left++);
                sum += lst.get(right++);
                if(right == repeat) {
                    max = Math.max(max, sum);
                    break;
                }
            }
        }

        System.out.println(max);
    }

}