import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String s = br.readLine();
            if(!s.equals("END")) {
                System.out.println(new StringBuffer(s).reverse().toString());
            } else break;
        }
    }
}