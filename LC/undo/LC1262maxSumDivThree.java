package undo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LC1262maxSumDivThree {

    public static void main(String[] args) {
        LC1262maxSumDivThree l = new LC1262maxSumDivThree();
//        int[] nums = {1, 2, 3, 4, 4};
        int[] nums = {3, 6, 5, 1, 8};
        System.out.println(l.maxSumDivThree(nums));

    }

    //虽然是屎山，但好歹做出来了
    /*
    执行耗时:11 ms,击败了46.65% 的Java用户
	内存消耗:43.4 MB,击败了94.37% 的Java用户
     */
    public int maxSumDivThree(int[] nums) {
        List<Integer> l0 = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        int sum = 0;

        for (int i :
                nums) {
            if (i % 3 == 0) {
                l0.add(i);
            } else if (i % 3 == 1) {
                l1.add(i);
            } else {
                l2.add(i);
            }
            sum += i;
        }

        if (sum % 3 == 0) {
            return sum;
        } else if (sum % 3 == 1) {
            //%==1
            //remove l1's min
            int l1Min = getMin(l1, 1);
            //remove l2's 2 mines
            int l2Min = getMin(l2, 2);
            if (l1Min == -1 && l2Min == -1) {
                sum = 0;
                for (int i :
                        l0) {
                    sum += i;
                }
                return sum;
            } else if (l1Min == -1) {
                return sum - l2Min;
            } else if (l2Min == -1) {
                return sum - l1Min;
            } else {
                return sum - Math.min(l1Min, l2Min);
            }
        } else {
            //%==2
            //remove l1's 2
            int l1Min = getMin(l1, 2);
            //remove l2's 1
            int l2Min = getMin(l2, 1);
            if (l1Min == -1 && l2Min == -1) {
                sum = 0;
                for (int i :
                        l0) {
                    sum += i;
                }
                return sum;
            } else if (l1Min == -1) {
                return sum - l2Min;
            } else if (l2Min == -1) {
                return sum - l1Min;
            } else {
                return sum - Math.min(l1Min, l2Min);
            }
        }
    }

    int getMin(List<Integer> list, int count) {
        if (count > list.size()) return -1;
        int min = Integer.MAX_VALUE;
        if (list.size() == 1) return list.get(0);
        if (count == 1) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) < min) {
                    min = list.get(i);
                }
            }
            return min;
        } else {
            int min2 = Integer.MAX_VALUE;
            for (int i = 0; i < list.size(); i++) {
                int l = list.get(i);
                if (l < min) {
                    min2 = min;
                    min = list.get(i);
                } else if (l < min2) {
                    min2 = l;
                }
            }
            return min + min2;
        }
    }


    //LC
    public int maxSumDivThreeLC(int[] nums) {
        // 使用 v[0], v[1], v[2] 分别表示 a, b, c
        List<Integer>[] v = new List[3];
        for (int i = 0; i < 3; ++i) {
            v[i] = new ArrayList<Integer>();
        }
        for (int num : nums) {
            v[num % 3].add(num);
        }
        Collections.sort(v[1], (a, b) -> b - a);
        Collections.sort(v[2], (a, b) -> b - a);

        int ans = 0;
        int lb = v[1].size(), lc = v[2].size();
        for (int cntb = lb - 2; cntb <= lb; ++cntb) {
            if (cntb >= 0) {
                for (int cntc = lc - 2; cntc <= lc; ++cntc) {
                    if (cntc >= 0 && (cntb - cntc) % 3 == 0) {
                        ans = Math.max(ans, getSum(v[1], 0, cntb) + getSum(v[2], 0, cntc));
                    }
                }
            }
        }
        return ans + getSum(v[0], 0, v[0].size());
    }

    public int getSum(List<Integer> list, int start, int end) {
        int sum = 0;
        for (int i = start; i < end; ++i) {
            sum += list.get(i);
        }
        return sum;
    }



    public int maxSumDivThreeLC2(int[] nums) {
        // 使用 v[0], v[1], v[2] 分别表示 a, b, c
        List<Integer>[] v = new List[3];
        for (int i = 0; i < 3; ++i) {
            v[i] = new ArrayList<Integer>();
        }
        for (int num : nums) {
            v[num % 3].add(num);
        }
        Collections.sort(v[1], (a, b) -> b - a);
        Collections.sort(v[2], (a, b) -> b - a);

        int tot = Arrays.stream(nums).sum();
        int remove = Integer.MAX_VALUE;

        if (tot % 3 == 0) {
            remove = 0;
        } else if (tot % 3 == 1) {
            if (v[1].size() >= 1) {
                remove = Math.min(remove, v[1].get(v[1].size() - 1));
            }
            if (v[2].size() >= 2) {
                remove = Math.min(remove, v[2].get(v[2].size() - 2) + v[2].get(v[2].size() - 1));
            }
        } else {
            if (v[1].size() >= 2) {
                remove = Math.min(remove, v[1].get(v[1].size() - 2) + v[1].get(v[1].size() - 1));
            }
            if (v[2].size() >= 1) {
                remove = Math.min(remove, v[2].get(v[2].size() - 1));
            }
        }

        return tot - remove;
    }


    public int maxSumDivThreeLCDP(int[] nums) {
        int[] f = {0, Integer.MIN_VALUE, Integer.MIN_VALUE};
        for (int num : nums) {
            int[] g = new int[3];
            System.arraycopy(f, 0, g, 0, 3);
            for (int i = 0; i < 3; ++i) {
                g[(i + num % 3) % 3] = Math.max(g[(i + num % 3) % 3], f[i] + num);
            }
            f = g;
        }
        return f[0];
    }

}
