import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        char[] chs = s.toCharArray();

        int b = 0;
        int r = 0;

        if(chs[0] == 'B') b = 1;
        else r = 1;

        for(int i = 0; i < chs.length - 1; i++) {
            if(chs[i] == 'B' && chs[i + 1] == 'R') {
                r++;
            } else if(chs[i] == 'R' && chs[i + 1] == 'B') {
                b++;
            }
        }

        System.out.println(Math.min(r + 1, b + 1));
    }
    
}
