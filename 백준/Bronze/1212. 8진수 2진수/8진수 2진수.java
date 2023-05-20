import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] n = br.readLine().toCharArray();

        String[] lst = {"000", "001", "010", "011", "100", "101", "110", "111"};
        String[] lst2 = {"0", "1", "10", "11", "100", "101", "110", "111"};

        StringBuilder sb = new StringBuilder();
        sb.append(lst2[(int) n[0] - 48]);
        for(int i = 1; i < n.length; i++) {
            sb.append(lst[(int) n[i] - 48]);
        }
        System.out.println(sb);
    }
}