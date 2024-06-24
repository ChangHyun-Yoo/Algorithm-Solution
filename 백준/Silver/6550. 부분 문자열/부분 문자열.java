import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = null;
        while((input = br.readLine()) != null) {
            String[] strings = input.split(" ");

            char[] s = strings[0].toCharArray();
            char[] t = strings[1].toCharArray();

            int index = 0;

            for(int i = 0; i < t.length; i++) {
                if(t[i] == s[index]) index++;
                if(index == s.length) break;
            }

            if(index == s.length) System.out.println("Yes");
            else System.out.println("No");
        }
    }
}
