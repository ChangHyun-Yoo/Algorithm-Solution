import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[] price;
    static String[] word;
    static int answer = Integer.MAX_VALUE;
    static int[] need;
    static int[] current;
    static int currentPrice = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] T = br.readLine().toCharArray();

        N = Integer.parseInt(br.readLine());

        price = new int[N];
        word = new String[N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            price[i] = Integer.parseInt(st.nextToken());
            word[i] = st.nextToken();
        }

        need = new int[26];
        for(int i = 0; i < T.length; i++){
            need[(int) T[i] - 65]++;
        }
        current = new int[26];

        dfs(0);

        if(answer != Integer.MAX_VALUE)
            System.out.println(answer);
        else System.out.println(-1);
    }

    static void dfs(int cur) {
        if(answer <= currentPrice) return;

        if(cur == N) {
            for(int j = 0; j < 26; j++) {
                if(need[j] > current[j]) return;
            }
            answer = currentPrice;
            return;
        }

        dfs(cur + 1);

        currentPrice += price[cur];
        char[] chs = word[cur].toCharArray();
        for(int i = 0; i < chs.length; i++){
            current[(int) chs[i] - 65]++;
        }
        dfs(cur + 1);
        currentPrice -= price[cur];
        for(int i = 0; i < chs.length; i++){
            current[(int) chs[i] - 65]--;
        }
    }
}
