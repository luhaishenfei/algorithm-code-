package finished;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC2418sortPeople {
    public static void main(String[] args) {
        String[] strs = new String[]{"Mary", "John", "Emma"};
        int[]    ints = new int[]{180, 165, 170};
        LC2418sortPeople l=new LC2418sortPeople();
        String[] res=l.sortPeople(strs,ints);
        System.out.println(res);
    }

    /*
    执行耗时:18 ms,击败了17.72% 的Java用户
    内存消耗:41.9 MB,击败了80.00% 的Java用户
     */
    public String[] sortPeople(String[] names, int[] heights) {
        String[] res = new String[names.length];
        for (int i = 0; i < heights.length; i++) {
            res[i] = names[findMax(heights)];
        }
        return res;
    }

    public int findMax(int[] ints) {
        int max = -1;
        int maxIdx = -1;
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] > max) {
                max = ints[i];
                maxIdx = i;
            }
        }
        ints[maxIdx] = -1;
        return maxIdx;
    }



    //priority
    /*
    执行耗时:6 ms,击败了95.61% 的Java用户
    内存消耗:42.2 MB,击败了23.33% 的Java用户
    or
    执行耗时:6 ms,击败了95.61% 的Java用户
	内存消耗:42 MB,击败了64.74% 的Java用户
     */
    public String[] sortPeople1(String[] names, int[] heights) {
        Queue<NameAndHeight> pq = new PriorityQueue<NameAndHeight>(new Comparator<NameAndHeight>() {
            @Override
            public int compare(NameAndHeight o1, NameAndHeight o2) {
                return o2.h-o1.h;
            }
        });
        for (int i = 0; i < heights.length; i++) {
            pq.offer(new NameAndHeight(names[i],heights[i]));
        }
        for (int i = 0; i <names.length ; i++) {
            names[i]=pq.poll().name;
        }
        return names;
    }

    class NameAndHeight {
        String name;
        int h;
        NameAndHeight(String name, int h) {
            this.name = name;
            this.h = h;
        }
    }


    //LC
    /*
    执行耗时:7 ms,击败了65.61% 的Java用户
	内存消耗:42.1 MB,击败了38.07% 的Java用户
     */
    public String[] sortPeopleLC(String[] names, int[] heights) {
        int n = names.length;
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, (a, b) -> heights[b] - heights[a]);
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            res[i] = names[indices[i]];
        }
        return res;
    }

}
