import java.io.*;
import java.util.*;

public class Main {

    static char[] input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine().toCharArray();

        int current = 0;
        boolean impossible = false;
        while(current < input.length) {
            if(input[current] == '.') {
                current++;
                continue;
            }

            if(input.length - current >= 4) {
                if(input[current] == 'X' && input[current + 1] == 'X' && input[current + 2] == 'X' && input[current + 3] == 'X') {
                    for(int k = current; k < current + 4; k++) {
                        input[k] = 'A';
                    }
                    current += 4;
                } else if(input[current] == 'X' && input[current + 1] == 'X') {
                    for(int k = current; k < current + 2; k++) {
                        input[k] = 'B';
                    }
                    current += 2;
                } else {
                    impossible = true;
                    break;
                }
            } else if(input.length - current >= 2) {
                if(input[current] == 'X' && input[current + 1] == 'X') {
                    for(int k = current; k < current + 2; k++) {
                        input[k] = 'B';
                    }
                    current += 2;
                } else {
                    impossible = true;
                    break;
                }
            } else {
                impossible = true;
                break;
            }
        }

        if(impossible)
            System.out.println(-1);
        else {
            String answer = "";
            for(char c: input)
                answer += c;
            System.out.println(answer);
        }
    }
}