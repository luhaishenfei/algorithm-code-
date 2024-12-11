package finished;

import java.util.*;

public class LC2931maxSpending {
    public static void main(String[] args) {
        LC2931maxSpending l = new LC2931maxSpending();
        int[][] values=new int[][]{
                {8,5,2},
                {6,4,1},
                {9,7,3}
        };
        System.out.println(l.maxSpending(values));
    }

    /*
    执行用时分布
33
ms
击败
76.79%

消耗内存分布
60.20
MB
击败
11.70%
     */
    public long maxSpending(int[][] values) {

        List<Integer> list=new ArrayList<Integer>();

        for (int j = 0; j < values.length; j++) {
            for (int k = 0; k < values[0].length; k++) {
                list.add(values[j][k]);
            }
        }
        Comparator<Integer> comparator =new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        } ;
        list.sort(comparator);
        long l=0;
        int d=1;
        for (int i:
             list) {
            //之前错误是因为忘记i*d强制转换成long了
            l=l+(long)i*d;
            d++;
        }
        return l;
    }


    //排序 逻辑与我上面的相同
    public long maxSpendingLC1(int[][] values) {
        int m = values.length;
        int n = values[0].length;
        int[] a = new int[m * n];
        for (int i = 0; i < m; i++) {
            System.arraycopy(values[i], 0, a, i * n, n);
        }
        Arrays.sort(a);

        long ans = 0;
        for (int i = 0; i < a.length; i++) {
            ans += (long) a[i] * (i + 1);
        }
        return ans;
    }

    //最小堆 矩阵每一列是递减的 所以每次比较每列最底部的数据，选取后删除，之后直到都为0
    public long maxSpendingLC2(int[][] values) {
        int m = values.length;
        int n = values[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> values[a[0]][a[1]] - values[b[0]][b[1]]);
        for (int i = 0; i < m; i++) {
            pq.offer(new int[]{i, n - 1});
        }

        long ans = 0;
        for (int d = 1; d <= m * n; d++) {
            int[] p = pq.poll();
            int i = p[0];
            int j = p[1];
            ans += (long) values[i][j] * d;
            if (j > 0) {
                pq.offer(new int[]{i, j - 1});
            }
        }
        return ans;
    }


}
