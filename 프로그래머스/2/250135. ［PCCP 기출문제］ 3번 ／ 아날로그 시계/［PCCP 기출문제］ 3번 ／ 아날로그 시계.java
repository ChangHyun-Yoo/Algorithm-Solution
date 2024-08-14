class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = 0;
        
        double start = h1*3600 + m1*60 + s1;
        double end = h2*3600 + m2*60 + s2;
        
        int beforeH = (int) (((start / 120) % 360) * 120);
        int beforeM = (int) (((start / 10) % 360) * 120);
        int beforeS = (int) (((start * 6) % 360) * 120);
        if(beforeH == beforeS || beforeM == beforeS) answer++;
        
        for(double t = start + 1; t <= end; t++) {
            int currentH = (int) (((t / 120) % 360) * 120);
            int currentM = (int) (((t / 10) % 360) * 120);
            int currentS = (int) (((t * 6) % 360) * 120);
            
            if(currentH == 0 && currentM == 0 && currentS == 0) {
                answer++;
            
                beforeH = currentH;
                beforeM = currentM;
                beforeS = currentS;
            } else {
                if(currentS == 0) currentS = 43200;
                if(beforeH > beforeS && currentH < currentS) answer++;

                if(beforeM > beforeS && currentM < currentS) answer++;

                if(currentH == currentS || currentM == currentS) answer++;

                beforeH = currentH;
                beforeM = currentM;
                if(currentS == 43200) {
                    beforeS = 0;
                } else {
                    beforeS = currentS;
                }
            }
        }
        
        return answer;
    }
}