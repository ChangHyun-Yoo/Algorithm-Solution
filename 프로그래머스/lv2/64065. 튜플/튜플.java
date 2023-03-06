import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        char[] c = s.toCharArray();
        
        char[] nc = new char[c.length - 4];
        for(int i = 0; i < nc.length; i++) {
            nc[i] = c[i + 2];
        }
        
        String ns = new String(nc);
        
        String[] ddd = ns.split("\\},\\{");
        int[][] lst = new int[ddd.length][];
        for(String st: ddd) {
            String[] a = st.split(",");
            int[] q = new int[a.length];
            for(int i = 0; i < a.length; i++) {
                q[i] = Integer.parseInt(a[i]);
            }
            lst[a.length - 1] = q;
        }
        
        List<Integer> ls = new ArrayList<>();
        for(int[] ss: lst) {
            for(int aa : ss) {
                if(ls.contains(aa)) {
                    continue;
                } else {
                    ls.add(aa);
                }
            }
        }
        
        int[] answer = new int[ls.size()];
        for(int j = 0; j < ls.size(); j++) {
            answer[j] = ls.get(j);
        }
        
        return answer;
    }
}