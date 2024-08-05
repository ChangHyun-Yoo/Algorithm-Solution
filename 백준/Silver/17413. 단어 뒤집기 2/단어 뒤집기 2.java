import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        char[] chs = br.readLine().toCharArray();

        char[] answer = new char[chs.length];

        Stack<Character> stack = new Stack<>();
        for(char ch: chs) {
            stack.add(ch);
        }

        List<Character> current = new ArrayList<>();
        boolean in = false;
        for(int i = chs.length - 1; i >= 0; i--) {
            char poped = stack.pop();

            if(in) {
                answer[i] = poped;
                if(poped == '<') {
                    in = false;
                }
            } else {
                if(poped == '>') {
                    for(int j = i + 1; j < i + 1 + current.size(); j++) {
                        answer[j] = current.get(j - i - 1);
                    }
                    answer[i] = poped;
                    current.clear();
                    in = true;
                } else if(poped == ' ') {
                    for(int j = i + 1; j < i + 1 + current.size(); j++) {
                        answer[j] = current.get(j - i - 1);
                    }
                    answer[i] = poped;
                    current.clear();
                } else {
                    current.add(poped);
                }
            }
        }
        if(current.size() != 0) {
            for(int i = 0; i < current.size(); i++) {
                answer[i] = current.get(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < answer.length; i++) {
            sb.append(answer[i]);
        }

        System.out.print(sb);
    }

}


