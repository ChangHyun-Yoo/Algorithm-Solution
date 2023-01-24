import java.io.*;
import java.util.*;

public class Main {

    private static List<String> cand = new ArrayList<>();
    private static int L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        L = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        List<String> ch = new ArrayList<>();

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < C; i++) {
            ch.add(st.nextToken());
        }

        Collections.sort(ch);
        backtracking(0, "", 0, 0, ch);

        StringBuilder sb = new StringBuilder();
        for(String s: cand)
            sb.append(s).append('\n');
        System.out.println(sb);
    }

    public static void backtracking(int current, String made, int ja, int mo, List<String> ch) {
        if(made.length() == L) {
            if(ja >= 2 && mo >= 1) {
                cand.add(made);
            }
        } else if(ch.size() - current == L - made.length()) {
            int jj = ja;
            int mm = mo;
            String mmm = made;
            for(int i = current; i < ch.size(); i++) {
                if(ch.get(i).equals("a") || ch.get(i).equals("e") || ch.get(i).equals("i") || ch.get(i).equals("o") || ch.get(i).equals("u")) {
                    mm++;
                } else {
                    jj++;
                }
                mmm += ch.get(i);
            }
            if(jj >= 2 && mm >= 1)
                cand.add(mmm);
        } else {
            if(ch.get(current).equals("a") || ch.get(current).equals("e") || ch.get(current).equals("i") || ch.get(current).equals("o") || ch.get(current).equals("u")) {
                backtracking(current + 1, made + ch.get(current), ja, mo + 1, ch);
            } else {
                backtracking(current + 1, made + ch.get(current), ja + 1, mo, ch);
            }
            backtracking(current + 1, made, ja, mo, ch);
        }
    }
}