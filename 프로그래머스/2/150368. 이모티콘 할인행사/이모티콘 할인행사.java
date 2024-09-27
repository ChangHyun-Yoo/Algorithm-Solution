import java.util.*;
class Solution {
    
    static int emo;
    static int max1 = Integer.MIN_VALUE;
    static int max2 = Integer.MIN_VALUE;
    
    public int[] solution(int[][] users, int[] emoticons) {
        List<Integer> lst = new ArrayList<>();
        emo = emoticons.length;
        dfs(users, lst, emoticons);
        
        return new int[]{max1, max2};
    }
    
    static void dfs(int[][] users, List<Integer> lst, int[] emoticons) {
        if(lst.size() == emo) {
            int plus = 0;
            int price = 0;
            
            for(int i = 0; i < users.length; i++) {
                int[] user = users[i];
                int sum = 0;
                for(int j = 0; j < lst.size(); j++) {
                    if(user[0] <= lst.get(j)) {
                        sum += emoticons[j] * (100 - lst.get(j)) / 100;
                    }
                }
                if(sum >= user[1]) {
                    plus++;
                } else {
                    price += sum;
                }
            }
            
            if(max1 < plus) {
                max1 = plus;
                max2 = price;
            } else if(max1 == plus) {
                max2 = Math.max(max2, price);
            }
            return;
        }
        
        for(int i = 10; i <= 40; i += 10) {
            lst.add(i);
            dfs(users, lst, emoticons);
            lst.remove(lst.size() - 1);
        }
    }
}