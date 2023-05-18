import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(br.readLine());

        List<Integer> lst = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            lst.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(lst, Collections.reverseOrder());

        int answer = 0;
        for(int i = 0; i < N; i += 3) {
            if(i == N - 2) {
                answer += lst.get(i);
                answer += lst.get(i + 1);
                break;
            }
            if(i == N - 1) {
                answer += lst.get(i);
                break;
            }

            answer += lst.get(i);
            answer += lst.get(i + 1);
        }
        System.out.println(answer);
    }
}