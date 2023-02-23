import java.io.*;
import java.util.*;

public class Main {

    static Map<Integer, Boolean> check = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> lst = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            lst.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(lst);
        int min = lst.get(0);
        int max = lst.get(N - 1);

        Set<Integer> set = new HashSet<>();
        List<Integer> sum = new ArrayList<>();
        for(int i = 0; i < N - 1; i++) {
            for(int j = i + 1; j < N; j++) {
                if(lst.get(i) == 0 && lst.get(j) == 0) {
                    set.add(0);
                } else if(lst.get(i) == 0 && lst.get(j) != 0) {
                    set.add(0);
                    set.add(lst.get(j));
                } else if(lst.get(i) != 0 && lst.get(j) == 0) {
                    set.add(lst.get(i));
                    set.add(0);
                } else {
                    int num = lst.get(i) + lst.get(j);
                    if(num < min) {
                        continue;
                    } else if(num > max) {
                        break;
                    } else {
                        sum.add(num);
                    }
                }
            }
        }

        int answer = 0;

        for(int s: set) {

            int low = 0;
            int high = N;
            while(low < high) {
                int mid = low + (high - low) / 2;
                if(s <= lst.get(mid)) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            int lowerBound = low;

            low = 0;
            high = N;
            while(low < high) {
                int mid = low + (high - low) / 2;
                if(s >= lst.get(mid)) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            int higherBound = low;

            if(s == 0) {
                if(higherBound - lowerBound >= 3) {
                    answer += higherBound - lowerBound;
                    if(check.get(s) == null) {
                        check.put(s, true);
                    }
                }
            } else {
                if(higherBound - lowerBound >= 2) {
                    answer += higherBound - lowerBound;
                    if(check.get(s) == null) {
                        check.put(s, true);
                    }
                }
            }
        }

        for(int s : set) {
            if(check.get(s) == null) {
                continue;
            } else {
                while(lst.contains(s)) {
                    lst.remove(Integer.valueOf(s));
                }
            }
        }

        for(int i = 0; i < sum.size(); i++) {
            while(lst.contains(sum.get(i))) {
                lst.remove(Integer.valueOf(sum.get(i)));
                answer++;
            }
        }

        System.out.println(answer);
    }
}
