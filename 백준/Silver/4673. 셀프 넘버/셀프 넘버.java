import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        int[] lst = new int[10000];
        for(int i = 1; i < 10000; i++) {
            if(lst[i - 1] == 1)
                continue;
            else {
                int current = i;
                while(current <= 9999) {
                    if(current < 10) {//한자리
                        current = 2 * current;
                    } else if(current < 100) {//두자리
                        current += current / 10 + current % 10;
                    } else if(current < 1000) {//세자리
                        current += current / 100 + (current % 100) / 10 + current % 10;
                    } else if(current < 10000) {//네자리
                        current += current / 1000 + (current % 1000) / 100 + (current % 100) / 10 + current % 10;
                    }
                    if(current < 10001) {
                        lst[current - 1] = 1;
                    }
                }
            }
        }

        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < 10000; i++) {
            if(lst[i] == 0) {
                sb.append(i + 1).append('\n');
            }
        }
        System.out.println(sb);
    }

}