package undo;

import java.util.Arrays;

public class LC2500deleteGreatestValue {

        /*
    [[1,2,4],[3,3,1]]
  -> [[1,2],[3,1]]     3,4
  -> [[1,],[1]]        2,3
  ->[[],[]]            1,1
    */

    public static void main(String[] args) {
        int[][] grid={{1,2,4},{3,3,1}};

        System.out.println(        );

    }
    public int deleteGreatestValue(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            Arrays.sort(grid[i]);
        }
        int res=0;
        int lMax=0;
        for (int i = 0; i < grid[0].length; i++) {
            for (int j = 0; j < grid.length; j++) {
                int n=grid[j][i];
                if (n>lMax) lMax=n;
            }
            res=res+lMax;
            lMax=0;
        }
        return res;
    }

}
