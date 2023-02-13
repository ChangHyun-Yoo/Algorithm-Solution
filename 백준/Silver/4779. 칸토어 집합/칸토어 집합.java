import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int[] answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while((s = br.readLine()) != null) {
            int num = Integer.parseInt(s);
            answer = new int[(int) Math.pow(3, num)];
            dq(0, (int) Math.pow(3, num));
            for(int i = 0; i < answer.length; i++) {
                if(answer[i] == 1) {
                    sb.append(" ");
                } else {
                    sb.append("-");
                }
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static void dq(int start, int end) {
        if(end - start == 1) {
            return;
        }

        for(int i = start + (end - start) / 3; i < start + 2 * (end - start) / 3; i++) {
            answer[i] = 1;
        }
        dq(start, start + (end - start) / 3);
        dq(start + 2 * (end - start) / 3, end);
    }
}