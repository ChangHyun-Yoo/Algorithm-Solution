import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while(true) {
            String s = br.readLine();

            if(s.equals("end")) break;

            if(check(s)) {
                sb.append("<").append(s).append("> is acceptable.").append('\n');
            } else {
                sb.append("<").append(s).append("> is not acceptable.").append('\n');
            }
        }

        System.out.print(sb);
    }

    static boolean check(String s) {
        char[] chs = s.toCharArray();

        boolean f = false;
        for(int i = 0; i < chs.length; i++) {
            if(check2(chs[i])) {
                f = true;
                break;
            }
        }

        if(!f) return false;

        for(int i = 2; i < chs.length; i++) {
            if(check2(chs[i]) && check2(chs[i - 1]) && check2(chs[i - 2])) {
                return false;
            }
            if(!check2(chs[i]) && !check2(chs[i - 1]) && !check2(chs[i - 2])) {
                return false;
            }
        }

        for(int i = 1; i < chs.length; i++) {
            if(chs[i] == chs[i - 1]) {
                if(chs[i] != 'e' && chs[i] != 'o') {
                    return false;
                }
            }
        }

        return true;
    }

    static boolean check2(char c) {
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }

        return false;
    }
}
