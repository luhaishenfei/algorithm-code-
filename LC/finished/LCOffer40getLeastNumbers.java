package finished;

import java.util.Arrays;

public class LCOffer40getLeastNumbers {

    /*
    执行耗时:7 ms,击败了71.57% 的Java用户
	内存消耗:43.7 MB,击败了31.77% 的Java用户
     */
    public int[] getLeastNumbers1(int[] arr, int k) {
        int[] res =new int[k];
        Arrays.sort(arr);

        for (int i = 0; i < k; i++) {
            res[i]=arr[i];
        }
        return res;
    }

}
