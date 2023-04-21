package finished;

public class LCOffer21exchange {
    public static void main(String[] args) {
        LCOffer21exchange l =new LCOffer21exchange();
        int[] nums=new int[]{2,2,2,2,2,2,2,7};
        nums=l.exchange(nums);
        System.out.println(nums);
    }

    /*
    	执行耗时:1 ms,击败了100.00% 的Java用户
	内存消耗:49.4 MB,击败了29.58% 的Java用户
     */
    public int[] exchange(int[] nums) {
        int start =0;
        int end =nums.length-1;
        while (start<end){
            if (nums[start]%2==0){
                //偶数
                while (start<end&&nums[end]%2==0){
                    end--;
                }
                int tmp=nums[end];
                nums[end]=nums[start];
                nums[start]=tmp;
                end--;
            }
            start++;
        }
        return nums;
    }


    public int[] exchangeLC(int[] nums) {
        int i = 0, j = nums.length - 1, tmp;
        while(i < j) {
            while(i < j && (nums[i] & 1) == 1) i++;
            while(i < j && (nums[j] & 1) == 0) j--;
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        return nums;
    }

}
