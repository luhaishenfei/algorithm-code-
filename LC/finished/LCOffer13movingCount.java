package finished;

import java.util.LinkedList;
import java.util.Queue;

public class LCOffer13movingCount {
    public static void main(String[] args) {
        LCOffer13movingCount l = new LCOffer13movingCount();
        System.out.println(l.movingCount(16, 8, 4));
    }



    /*
    时间1 ms   击败61.74%
    内存38.1 MB击败90.19%
     */
    int[][] board;
    int k;
    int count;
    public int movingCount(int m, int n, int k) {
        board=new int[m][n];
        this.k=k;
        this.count=0;

        move(0,0);
        return count;
    }

    void move(int i,int j){
//        System.out.println(i+"-"+j);
        if (i<0||j<0||i>=board.length||j>=board[0].length){
            //overflow
            return;
        }else if (board[i][j]==1){
            //isCalculated
            return;
        }else {
            if (isValid(i,j)){
                board[i][j]=1;
                count++;
                //down
                move(i+1,j);
                //up
                move(i-1,j);
                //left
                move(i,j-1);
                //right
                move(i,j+1);
            }

        }
    }

    boolean isValid(int i,int j){
        return getSum(i) + getSum(j) <= k;
    }

    int getSum(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }


    //Queue version
    public int movingCountLC1(int m, int n, int k) {
        if (k == 0) {
            return 1;
        }
        Queue<int[]> queue = new LinkedList<int[]>();
        // 向右和向下的方向数组
        int[] dx = {0, 1};
        int[] dy = {1, 0};
        boolean[][] vis = new boolean[m][n];
        queue.offer(new int[]{0, 0});
        vis[0][0] = true;
        int ans = 1;
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for (int i = 0; i < 2; ++i) {
                int tx = dx[i] + x;
                int ty = dy[i] + y;
                if (tx < 0 || tx >= m || ty < 0 || ty >= n || vis[tx][ty] || get(tx) + get(ty) > k) {
                    continue;
                }
                queue.offer(new int[]{tx, ty});
                vis[tx][ty] = true;
                ans++;
            }
        }
        return ans;
    }

    private int get(int x) {
        int res = 0;
        while (x != 0) {
            res += x % 10;
            x /= 10;
        }
        return res;
    }

    /*
    同时这道题还有一个隐藏的优化：我们在搜索的过程中搜索方向可以缩减为向右和向下，而不必再向上和向左进行搜索。如下图，我们展示了 16 * 16 的地图随着限制条件 k 的放大，可行方格的变化趋势，每个格子里的值为行坐标和列坐标的数位之和，蓝色方格代表非障碍方格，即其值小于等于当前的限制条件 k。我们可以发现随着限制条件 k 的增大，(0, 0) 所在的蓝色方格区域内新加入的非障碍方格都可以由上方或左方的格子移动一步得到。而其他不连通的蓝色方格区域会随着 k 的增大而连通，且连通的时候也是由上方或左方的格子移动一步得到，因此我们可以将我们的搜索方向缩减为向右或向下。
     */

}
