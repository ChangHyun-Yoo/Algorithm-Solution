import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        Map<Character, Integer> map = new HashMap<>();

        map.put('A', 3);
        map.put('B', 2);
        map.put('C', 1);
        map.put('D', 2);
        map.put('E', 3);
        map.put('F', 3);
        map.put('G', 3);
        map.put('H', 3);
        map.put('I', 1);
        map.put('J', 1);
        map.put('K', 3);
        map.put('L', 1);
        map.put('M', 3);
        map.put('N', 3);
        map.put('O', 1);
        map.put('P', 2);
        map.put('Q', 2);
        map.put('R', 2);
        map.put('S', 1);
        map.put('T', 2);
        map.put('U', 1);
        map.put('V', 1);
        map.put('W', 2);
        map.put('X', 2);
        map.put('Y', 2);
        map.put('Z', 1);

        Queue<Integer> nums = new LinkedList<>();
        for(int i = 0; i < s.length(); i++) {
            nums.add(map.get(s.charAt(i)));
        }

        while(nums.size() != 1) {

            int length = nums.size();

            if(length % 2 == 0) {
                for(int i = 0; i < length / 2; i++) {
                    int sum = 0;
                    sum += nums.poll();
                    sum += nums.poll();
                    nums.offer(sum);
                }
            } else {
                for(int i = 0; i < length / 2; i++) {
                    int sum = 0;
                    sum += nums.poll();
                    sum += nums.poll();
                    nums.offer(sum);
                }
                nums.offer(nums.poll());
            }
        }

        if(nums.peek() % 2 == 0) System.out.println("You're the winner?");
        else System.out.println("I'm a winner!");
    }
}