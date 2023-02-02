import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int a = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();
            int num;
            int check;

            switch (command) {
                case "add":
                    num = Integer.parseInt(st.nextToken());
                    a |= (1 << num);
                    break;
                case "remove":
                    num = Integer.parseInt(st.nextToken());
                    a &= ~(1 << num);
                    break;
                case "check":
                    num = Integer.parseInt(st.nextToken());
                    check = a & (1 << num);
                    if(check == 0) {
                        sb.append(0).append('\n');
                    } else {
                        sb.append(1).append('\n');
                    }
                    break;
                case "toggle":
                    num = Integer.parseInt(st.nextToken());
                    check = a & (1 << num);
                    if(check == 0) {
                        a |= (1 << num);
                    } else {
                        a &= ~(1 << num);
                    }
                    break;
                case "all":
                    a = (1 << 21) - 1;
                    break;
                case "empty":
                    a = 0;
                    break;
                default:
                    break;
            }
        }

        System.out.println(sb);
    }
}