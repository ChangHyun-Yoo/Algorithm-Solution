import java.util.*;
import java.lang.Math;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        
        List<List<String>> newRecords = new ArrayList<>();
        Set<String> set = new LinkedHashSet<>();
        for(String record: records) {
            String[] splited = record.split(" ");
            List<String> newRecord = new ArrayList<>();
            String[] time = splited[0].split(":");
            if(splited[2].equals("OUT") && time[1].equals("00")) {
                newRecord.add(Integer.toString(Integer.parseInt(time[0]) - 1));
                newRecord.add("60");
            } else {
                newRecord.add(time[0]);
                newRecord.add(time[1]);
            }
            newRecord.add(splited[1]);
            newRecord.add(splited[2]);
            newRecords.add(newRecord);
            set.add(splited[1]);
        }
        Collections.sort(newRecords, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> l1, List<String> l2) {
                return l1.get(2).compareTo(l2.get(2));
            }
        });
        List<String> cars = new ArrayList<>(set);
        Collections.sort(cars);
        
        Map<String, Integer> result = new LinkedHashMap<>();
        String currentCar = "";
        List<List<List<String>>> res = new ArrayList<>();
        List<List<String>> re = new ArrayList<>();
        for(int k = 0; k < newRecords.size(); k++) {
            if(!currentCar.equals(newRecords.get(k).get(2))) {
                currentCar = newRecords.get(k).get(2);
                if(k != 0) {
                    res.add(re);
                }
                re = new ArrayList<>();
            }
            re.add(newRecords.get(k));
        }
        res.add(re);
        int[] answer = new int[set.size()];
        int num = 0;
        for(List<List<String>> ree: res) {
            int minutes = 0;
            if(ree.size() % 2 == 0) {//짝수
                for(int i = 0; 2 * i < ree.size(); i++) {
                    minutes += 
                        (Integer.parseInt(ree.get(2*i + 1).get(0)) - Integer.parseInt(ree.get(2*i).get(0))) * 60;
                    minutes += Integer.parseInt(ree.get(2*i + 1).get(1)) - Integer.parseInt(ree.get(2*i).get(1));
                }
            } else {//홀수
                for(int i = 0; 2 * i < ree.size(); i++) {
                    if(2 * i == ree.size() - 1) {
                        minutes += (23 - Integer.parseInt(ree.get(2*i).get(0))) * 60;
                        minutes += 59 - Integer.parseInt(ree.get(2*i).get(1));
                    } else {
                        minutes += (Integer.parseInt(ree.get(2*i + 1).get(0)) - Integer.parseInt(ree.get(2*i).get(0))) * 60;
                        minutes += Integer.parseInt(ree.get(2*i + 1).get(1)) - Integer.parseInt(ree.get(2*i).get(1));
                    }
                }
            }
            if(minutes <= fees[0]) {
                result.put(ree.get(0).get(2), fees[1]);
                answer[num] = fees[1];
            } else {
                result.put(ree.get(0).get(2), fees[1] +  ((int) Math.ceil((double) (minutes - fees[0]) / fees[2]) * fees[3]));
                answer[num] = fees[1] +  ((int) Math.ceil((double) (minutes - fees[0]) / fees[2]) * fees[3]);
            }
            num += 1;
        }
        return answer;
    }
}