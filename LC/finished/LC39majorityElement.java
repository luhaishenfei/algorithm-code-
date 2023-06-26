package finished;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class LC39majorityElement {

    public static void main(String[] args) {
        LC39majorityElement l = new LC39majorityElement();

        int[] nums = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        int limit = nums.length % 2 == 0 ? nums.length / 2 : nums.length / 2 + 1;
        System.out.println(limit);
        System.out.println(l.majorityElement(nums));

    }


    //LC随机算法
    /*
    执行耗时:1 ms,击败了99.59% 的Java用户
	内存消耗:47.7 MB,击败了8.66% 的Java用户
     */
    private int randRange(Random rand, int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    private int countOccurences(int[] nums, int num) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    public int majorityElementLCRandom(int[] nums) {
        Random rand = new Random();
        int majorityCount = nums.length / 2;
        while (true) {
            int candidate = nums[randRange(rand, 0, nums.length)];
            if (countOccurences(nums, candidate) > majorityCount) {
                return candidate;
            }
        }
    }

    //LC分治
    /*
	执行耗时:1 ms,击败了99.59% 的Java用户
	内存消耗:47.6 MB,击败了17.73% 的Java用户
     */
    private int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    private int majorityElementRec(int[] nums, int lo, int hi) {
        // base case; the only element in an array of size 1 is the majority
        // element.
        if (lo == hi) {
            return nums[lo];
        }

        // recurse on left and right halves of this slice.
        int mid = (hi - lo) / 2 + lo;
        int left = majorityElementRec(nums, lo, mid);
        int right = majorityElementRec(nums, mid + 1, hi);

        // if the two halves agree on the majority element, return it.
        if (left == right) {
            return left;
        }

        // otherwise, count each element and return the "winner".
        int leftCount = countInRange(nums, left, lo, hi);
        int rightCount = countInRange(nums, right, lo, hi);

        return leftCount > rightCount ? left : right;
    }

    public int majorityElementLC2(int[] nums) {
        return majorityElementRec(nums, 0, nums.length - 1);
    }

    //my way
    /*
    	执行耗时:12 ms,击败了25.80% 的Java用户
	内存消耗:45.7 MB,击败了49.40% 的Java用户
     */
    public int majorityElement(int[] nums) {
        if (nums.length == 1) return nums[0];
        Map<Integer, Integer> map = new HashMap<>();

        int limit = nums.length % 2 == 0 ? nums.length / 2 : nums.length / 2 + 1;

        for (int i :
                nums) {
            if (map.containsKey(i)) {
                int count = map.get(i) + 1;
                if (count >= limit) return i;
                map.put(i, count);
            } else {
                map.put(i, 1);
            }
        }
        return -1;
    }






    /*
    执行耗时:3 ms,击败了35.24% 的Java用户
	内存消耗:47.5 MB,击败了21.11% 的Java用户
     */
    //排序的思路是没错，但是排序后其实是可以直接就返回nums[n.len/2]作为最终结果的

    /*
    对于每种情况，数组下面的线表示如果众数是数组中的最小值时覆盖的下标，数组下面的线表示如果众数是数组中的最大值时覆盖的下标。对于其他的情况，这条线会在这两种极端情况的中间。对于这两种极端情况，它们会在下标为 ⌊n2⌋\lfloor \dfrac{n}{2} \rfloor⌊
2
n
​
 ⌋ 的地方有重叠。因此，无论众数是多少，返回 ⌊n2⌋\lfloor \dfrac{n}{2} \rfloor⌊
2
n
​
 ⌋ 下标对应的值都是正确的。

作者：力扣官方题解
链接：https://leetcode.cn/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/solutions/832356/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-pvh8/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    //也就是下面
    /*
    执行耗时:2 ms,击败了58.55% 的Java用户
	内存消耗:47.9 MB,击败了5.17% 的Java用户
     */
    public int majorityElementLC(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    //这是原先的错误示范
    public int majorityElement1(int[] nums) {
        int limit = nums.length % 2 == 0 ? nums.length / 2 : nums.length / 2 + 1;
        Arrays.sort(nums);
        int counter = 0;
        int lastElement = nums[0];
        for (int i :
                nums) {
            if (i == lastElement) {
                counter++;
            } else {
                lastElement = i;
                counter = 1;
            }
            if (counter == limit) {
                return i;
            }
        }
        return lastElement;
    }

    //Boyer-Moore 投票算法
    /*
    执行耗时:2 ms,击败了58.55% 的Java用户
	内存消耗:47.5 MB,击败了22.31% 的Java用户
     */
    public int majorityElementLCBoyerMoore(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}
