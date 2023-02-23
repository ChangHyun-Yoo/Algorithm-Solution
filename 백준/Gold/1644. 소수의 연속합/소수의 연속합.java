import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> l = new ArrayList<>();
        boolean[] lst = new boolean[4000001];
        for(int i = 2; i <= 4000000; i++) {
            for(int j = 2; i * j <= 4000000; j++) {
                lst[i * j] = true;
            }
        }
        lst[0] = true;
        lst[1] = true;
        lst[2] = false;
        lst[3] = false;

        for(int i = 0; i < lst.length; i++) {
            if(!lst[i])
                l.add(i);
        }

        int answer = 0;
        int length = 0;
        int current = 0;
        while(length < l.size()) {
            current = 0;
            for(int i = 0; i <= length; i++) {
                current += l.get(i);
            }
            if(current > N) {
                break;
            }
            int low = 0;
            int high = low + length;
            while(high < l.size()) {
                if(current < N) {
                    current -= l.get(low);
                    low++;
                    high++;
                    if(high == l.size()) {
                        break;
                    }
                    current += l.get(high);
                } else if(current == N) {
                    answer++;
                    break;
                } else {
                    break;
                }
            }
            length++;
        }

        System.out.println(answer);
    }
}
