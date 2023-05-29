import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        char[] s = br.readLine().toCharArray();

        double[] num = new double[N];
        for(int i = 0; i < N; i++) {
            num[i] = Double.parseDouble(br.readLine());
        }

        List<Object> chs = new ArrayList<>();
        for(char c: s) {
            if(c - '0' - 17 >= 0 && c - '0' - 17 < 26) {
                chs.add(num[c - '0' - 17]);
            } else {
                chs.add(c);
            }
        }

        while(chs.size() != 1) {
            for(int i = 0; i < chs.size() - 2; i++) {
                if(chs.get(i).getClass().equals(Double.class) && chs.get(i + 1).getClass().equals(Double.class) && chs.get(i + 2).getClass().equals(Character.class)) {
                    if((char) chs.get(i + 2) == '*') {
                        chs.add(i, (double) chs.get(i) * (double) chs.get(i + 1));
                    } else if((char) chs.get(i + 2) == '+') {
                        chs.add(i, (double) chs.get(i) + (double) chs.get(i + 1));
                    } else if((char) chs.get(i + 2) == '-') {
                        chs.add(i, (double) chs.get(i) - (double) chs.get(i + 1));
                    } else {
                        chs.add(i, (double) chs.get(i) / (double) chs.get(i + 1));
                    }
                    chs.remove(i + 1);
                    chs.remove(i + 1);
                    chs.remove(i + 1);
                    break;
                }
            }
        }
        System.out.printf("%.2f", (double) chs.get(0));
    }
}