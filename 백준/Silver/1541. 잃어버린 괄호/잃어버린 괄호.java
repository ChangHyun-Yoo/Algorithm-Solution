import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int cnt = 1;
        for(int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == '-') {
                break;
            } else if(input.charAt(i) == '+') {
                cnt++;
            }
        }
        String[] s1 = input.split("-");
        List<Integer> result = new ArrayList<>();
        for(String s: s1) {
            for(String sss: s.split("\\+")) {
                result.add(Integer.parseInt(sss));
            }
        }

        int answer = result.get(0);
        for(int i = 1; i < result.size(); i++) {
            if(i >= cnt)
                answer -= result.get(i);
            else
                answer += result.get(i);
        }
        System.out.println(answer);
    }
}