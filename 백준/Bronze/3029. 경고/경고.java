import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] before = br.readLine().split(":");
        int[] b = new int[3];
        for(int i = 0; i < 3; i++) {
            b[i] = Integer.parseInt(before[i]);
        }

        String[] after = br.readLine().split(":");
        int[] a = new int[3];
        for(int i = 0; i < 3; i++) {
            a[i] = Integer.parseInt(after[i]);
        }

        int[] answer = new int[3];
        if(a[2] < b[2]) {
            a[2] += 60;
            if(a[1] == 0) {
                a[1] = 59;
                a[0] += 23;
                a[0] %= 24;
            } else {
                a[1]--;
            }
        }
        answer[2] = a[2]  - b[2];

        if(a[1] < b[1]) {
            a[1] += 60;
            a[0] += 23;
            a[0] %= 24;
        }
        answer[1] = a[1] - b[1];

        if(a[0] < b[0]) {
            a[0] += 24;
        }
        answer[0] = a[0] - b[0];

        if(answer[0] == 0 && answer[1] == 0 && answer[2] == 0) {
            answer[0] = 24;
        }
        String ss = "";
        if(answer[0] >= 0 && answer[0] < 10) {
            ss += "0" + answer[0];
        } else {
            ss += answer[0];
        }
        ss += ":";

        if(answer[1] >= 0 && answer[1] < 10) {
            ss += "0" + answer[1];
        } else {
            ss += answer[1];
        }
        ss += ":";
        if(answer[2] >= 0 && answer[2] < 10) {
            ss += "0" + answer[2];
        } else {
            ss += answer[2];
        }
        System.out.println(ss);
    }
}