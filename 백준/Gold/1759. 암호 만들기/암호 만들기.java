import java.util.*;
import java.io.*;

public class Main {

    static int L;
    static int C;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        char[] chs = new char[C];

        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < C; i++) {
            chs[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(chs);
        List<Character> result = new ArrayList<>();

        dfs(0, chs, result);

        System.out.print(sb);
    }

    static void dfs(int current, char[] chs, List<Character> result) {
        if(result.size() == L) {
            // 자음, 모음 체크 후 맞으면 정답에 추가
            StringBuilder now = new StringBuilder();
            int mo = 0;
            int ja = 0;
            for(char c: result) {
                if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') mo++;
                else ja++;
                now.append(c);
            }

            if(mo >= 1 && ja >= 2) {
                sb.append(now.toString());
                sb.append('\n');
            }
            return;
        }

        if(current == C) return;

        result.add(chs[current]);
        dfs(current + 1, chs, result);
        result.remove(result.size() - 1);

        dfs(current + 1, chs, result);
    }
}