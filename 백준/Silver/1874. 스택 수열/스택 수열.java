import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Set<Integer> before = new HashSet<>();
        Set<Integer> poped = new HashSet<>();

        Stack<Integer> stack = new Stack<>();
        int[] nums = new int[n];
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            before.add(i + 1);
        }

        int currentNum = 1;
        int currentIndex = 0;

        while(currentIndex < n) {
            if(nums[currentIndex] >= currentNum) {
                while(nums[currentIndex] >= currentNum) {
                    stack.push(currentNum++);
                    sb.append('+');
                    sb.append('\n');
                }
            } else {
                if(stack.isEmpty()) {
                    System.out.println("NO");
                    return;
                } else {
                    if(stack.peek() == nums[currentIndex]) {
                        currentIndex++;
                        stack.pop();
                        sb.append('-');
                        sb.append('\n');
                    } else {
                        System.out.println("NO");
                        return;
                    }
                }
            }
        }
        System.out.println(sb);
    }
}