import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> lst = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            lst.add(Integer.parseInt(br.readLine()));
        }

        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int a: lst) {
            sum += a;
            if(map.get(a) == null) {
                map.put(a, 1);
            } else {
                map.replace(a, map.get(a) + 1);
            }
        }
        Collections.sort(lst);
        Set<Integer> key = map.keySet();
        List<Integer> check = new ArrayList<>();
        int max = -1;
        for(int k: key) {
            if(map.get(k) > max) {
                max = map.get(k);
                check.clear();
                check.add(k);
            } else if(map.get(k) == max) {
                check.add(k);
            } else
                continue;
        }
        Collections.sort(check);

        System.out.println(Math.round(sum / (double) n));
        System.out.println(lst.get(n / 2));
        if(check.size() > 1)
            System.out.println(check.get(1));
        else
            System.out.println(check.get(0));
        System.out.println(Collections.max(lst) - Collections.min(lst));
    }

}