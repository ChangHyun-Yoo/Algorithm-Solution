import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int t = 0; t < T; t++) {
            String commands = br.readLine();
            int p = Integer.parseInt(br.readLine());

            String array = br.readLine();
            array = array.substring(1, array.length() - 1);
            String[] arr = array.split(",");

            Deque<Integer> dq = new ArrayDeque<>();
            if(p != 0)
                for(String s: arr) {
                    dq.offerLast(Integer.parseInt(s));
                }

            boolean direction = true;

            boolean error = false;
            for(int i = 0; i < commands.length(); i++) {
                char command = commands.charAt(i);

                if(command == 'R') {
                    direction = !direction;
                } else {
                    if(dq.isEmpty()) {
                        error = true;
                        break;
                    } else {
                        if(direction) {
                            dq.pollFirst();
                        } else {
                            dq.pollLast();
                        }
                    }
                }
            }

            if(error) {
                sb.append("error").append('\n');
            } else {
                sb.append('[');
                if(direction) {
                    while(!dq.isEmpty()) {
                        sb.append(dq.pollFirst());
                        if(!dq.isEmpty())
                            sb.append(',');
                    }
                } else {
                    while(!dq.isEmpty()) {
                        sb.append(dq.pollLast());
                        if(!dq.isEmpty())
                            sb.append(',');
                    }
                }
                sb.append(']').append('\n');
            }
        }

        System.out.print(sb);
    }
}