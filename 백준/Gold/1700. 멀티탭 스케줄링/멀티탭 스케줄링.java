import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String[] lst = br.readLine().split(" ");

        int index = 0;
        List<Integer> mul = new ArrayList<>();
        while(mul.size() != N && index < K) {
            int i = Integer.parseInt(lst[index]);
            if(!mul.contains(i)) {
                mul.add(i);
            }
            index++;
        }

        int answer = 0;
        //적게 남은 것 부터 뽑기
        for(int j = index; j < K; j++) {
            int num = Integer.parseInt(lst[j]);//기기 번호
            if(mul.contains(num)) {//이미 멀티탭이 꽂혀있으면
                continue;
            } else {
                List<Integer> recent = new ArrayList<>();
                int remove = 0;
                for(int m: mul) {
                    boolean b = false;
                    for(int k = j + 1; k < K; k++) {
                        if(Integer.parseInt(lst[k]) == m) {//가까이 있는게 있을 경우
                            recent.add(k);
                            b = true;
                            break;
                        }
                    }
                    if(!b) {//이후로 나오지 않는 친구가 있으면
                        remove = m;
                        break;
                    }
                }
                //모두 다 근처에 있는 경우 가장 멀리 있는 제품을 뽑아
                if(remove == 0) {
                    remove = mul.get(recent.indexOf(Collections.max(recent)));
                }

                mul.remove(Integer.valueOf(remove));
                mul.add(num);
                answer++;
            }
        }
        System.out.println(answer);
    }
}