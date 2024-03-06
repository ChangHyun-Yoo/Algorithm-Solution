import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        List<Double> lst = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            lst.add(Double.parseDouble(st.nextToken()));
        }
        Collections.sort(lst, Collections.reverseOrder());

        double max = lst.get(0);

        for(int i = 1; i < lst.size(); i++) {
            max += lst.get(i) / 2;
        }

        if(max == (int) max) System.out.println((int) max);
        else System.out.println(max);
    }
}