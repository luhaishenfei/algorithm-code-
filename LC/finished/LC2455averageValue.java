package finished;

public class LC2455averageValue {
    public int averageValue(int[] nums) {
        int res =0;
        int count=0;
        for (int i = 0; i <nums.length ; i++) {
            if (nums[i]%2==0&&nums[i]%3==0){
                res+=nums[i];
            }
        }
        return res/count;
    }


    public int averageValue2(int[] nums) {
        int res =0;
        int count=0;
        for (int i = 0; i <nums.length ; i++) {
            if (nums[i]%6==0){
                res+=nums[i];
            }
        }
        return res/count;
    }
}
