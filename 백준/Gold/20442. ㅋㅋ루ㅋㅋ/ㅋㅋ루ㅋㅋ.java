import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        if(s.length() == 0) {
            System.out.println(0);
            return;
        }

        char[] chs = s.toCharArray();

        int[] sumR = new int[chs.length + 1];
        for(int i = 0; i < chs.length; i++) {
            if(chs[i] == 'R')
                sumR[i + 1] = sumR[i] + 1;
            else sumR[i + 1] = sumR[i];
        }

        int answer = sumR[sumR.length - 1];

        int left = 0;
        int right = chs.length - 1;
        int history = 0;

        while(left < right) {
            if(chs[left] == 'K' && chs[right] == 'K') {
                int sum = sumR[right + 1] - sumR[left + 1];
                if(sum > 0) {
                    history += 2;
                    answer = Math.max(answer, sum + history);
                }
                else break;
                left++;
                right--;
            } else if(chs[left] == 'K' && chs[right] != 'K') {
                right--;
            } else if(chs[left] != 'K' && chs[right] == 'K') {
                left++;
            } else {
                left++;
                right--;
            }
        }

        System.out.println(answer);
    }
}
