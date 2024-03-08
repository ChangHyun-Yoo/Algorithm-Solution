import java.util.*;
import java.io.*;

public class Main {

    static int[] prices = new int[14];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int jun = Integer.parseInt(br.readLine());
        int sung = jun;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 14; i++) {
            prices[i] = Integer.parseInt(st.nextToken());
        }

        int junCurrent = 0;
        for (int i = 0; i < 14; i++) {
            junCurrent += jun / prices[i];
            jun -= (jun / prices[i]) * prices[i];
        }

        int sungCurrent = 0;
        for (int i = 3; i < 14; i++) {
            if(prices[i - 3] < prices[i - 2] && prices[i - 2] < prices[i - 1]) {
                sung += sungCurrent * prices[i];
                sungCurrent = 0;
            } else if(prices[i - 3] > prices[i - 2] && prices[i - 2] > prices[i - 1]) {
                sungCurrent += sung / prices[i];
                sung -= (sung / prices[i]) * prices[i];
            }
        }

        if(junCurrent * prices[13] + jun > sungCurrent * prices[13] + sung) System.out.println("BNP");
        else if(junCurrent * prices[13] + jun == sungCurrent * prices[13] + sung) System.out.println("SAMESAME");
        else System.out.println("TIMING");

    }

}