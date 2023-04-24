package finished;

import org.junit.Test;

public class LC11maxArea {
    @Test
    public void test() {
        int[] ints = {2,3,4,5,18,17,6};
        System.out.println(maxArea(ints));
    }

    int getArea(int l, int r, int[] height) {
        return Math.min(height[l], height[r]) * (r - l);
    }

    public int maxArea(int[] height) {
        if (height.length <= 1) return 0;

        int l = 0;
        int r = height.length - 1;

        int lMax = l;
        int rMax = r;

        int maxArea = getArea(l, r, height);
        while (l < r) {
            if (height[lMax] < height[rMax]) {
                l++;
                if (l == r) break;
                if (height[l] > height[lMax]) {
                    int area = getArea(l, rMax, height);
                    if (area > maxArea) {
                        maxArea = area;
                    }
                    lMax=l;
                }
            } else {
                r--;
                if (l == r) break;
                if (height[r] > height[rMax]) {
                    int area = getArea(lMax, r, height);
                    if (area > maxArea) {
                        maxArea = area;
                    }
                    rMax = r;

                }
            }
        }
        return maxArea;
    }


    //LC
    //比较暴力，穷举了所有面积
    public int maxAreaLC(int[] height) {
        int l = 0, r = height.length - 1;
        int ans = 0;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans, area);
            if (height[l] <= height[r]) {
                ++l;
            }
            else {
                --r;
            }
        }
        return ans;
    }
}
