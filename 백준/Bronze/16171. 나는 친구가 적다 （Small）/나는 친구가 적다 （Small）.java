import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String s = "";
        for(int i = 0; i < S.length(); i++) {
            if(!((int) S.charAt(i) >= 48 && (int) S.charAt(i) <= 57)) {
                s += S.charAt(i);
            }
        }

        if(s.contains(br.readLine())) System.out.println(1);
        else System.out.println(0);
    }
}