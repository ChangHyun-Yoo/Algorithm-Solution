import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();

        Queue<String> q = new LinkedList<>();
        q.add(S);

        while(T.length() != S.length()) {
            if(T.charAt(T.length() - 1) == 'A') {
                T = T.substring(0, T.length() - 1);
            } else {
                T = T.substring(0, T.length() - 1);
                StringBuffer sb = new StringBuffer(T);
                T = sb.reverse().toString();
            }
        }

        if(T.equals(S))
            System.out.println(1);
        else
            System.out.println(0);
    }
}