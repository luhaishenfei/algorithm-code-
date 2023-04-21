package finished;

import java.util.ArrayList;
import java.util.List;

public class LC1470shuffle {

    public static void main(String[] args) {
       List list= new ArrayList();
        for (int i = 0; i < 95; i++) {
            list.add(i);
        }
        for (int i = 0; i < 10; i++) {
            List s = list.subList(i*10,i*10+10);
            s.size();
        }
    }

    //normal solution
    public int[] shuffle1(int[] nums, int n) {
        int len = nums.length;
        int[] tmp = nums.clone();
        for (int i =0; i <len ; i++) {
            if (i%2==0){
                nums[i]=tmp[i/2];
            }   else {
                nums[i]=tmp[i/2+len/2];
            }
        }
        return nums;
    }


    //遍历次数少了一半，虽然都是O(1)
    public int[] shuffleLC(int[] nums, int n) {
        int[] ans = new int[2 * n];
        for (int i = 0; i < n; i++) {
            ans[2 * i] = nums[i];
            ans[2 * i + 1] = nums[i + n];
        }
        return ans;
    }
}
