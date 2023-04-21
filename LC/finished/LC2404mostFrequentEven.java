package LC.finished;

import java.util.HashMap;
import java.util.Map;

public class LC2404mostFrequentEven {


    /*
	执行耗时:17 ms,击败了64.35% 的Java用户
	内存消耗:41.4 MB,击败了90.22% 的Java用户
     */
    public int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i :
                nums) {
            if (i % 2 == 0) {
                if (countMap.containsKey(i)) {
                    countMap.put(i, countMap.get(i) + 1);
                } else {
                    countMap.put(i, 1);
                }
            }
        }
        int min = -1;
        int maxCount = 0;
        for (int key :
                countMap.keySet()) {
            int count = countMap.get(key);
            if (count > maxCount||(count == maxCount && key < min)){
                min = key;
                maxCount = count;
            }
        }
        return min;
    }

}
