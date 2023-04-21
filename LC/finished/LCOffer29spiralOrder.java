package LC.finished;

public class LCOffer29spiralOrder {
    public static void main(String[] args) {
        LCOffer29spiralOrder l = new LCOffer29spiralOrder();
        int[][] matrix = new int[][]{
             new int[]{1, 2, 3, 4, 5},
             new int[]{6, 7, 8, 9, 10},
             new int[]{11, 12, 13, 14, 15},
             new int[]{16, 17, 18, 19, 20}
//                ,
//             new int[]{21, 22, 23, 24, 25}
        } ;
        int[] res=l.spiralOrder(matrix);
        for (int i :
                res) {
            System.out.println(i);
        }
    }


    int up, left;

    int down, right;

    enum Direction {
        RIGHT, DOWN, LEFT, UP
    }

    /*
       0 right
       1 down
       2 left
       3 up
        */
    Direction direction = Direction.RIGHT;

    int i = 0;
    int j = 0;

    /*
    解答成功:
	执行耗时:2 ms,击败了23.27% 的Java用户
	内存消耗:43.1 MB,击败了73.80% 的Java用户
     */
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length==0||matrix[0].length==0) return new int[0];
        up = 0;
        left = 0;
        down = matrix.length - 1;
        right = matrix[0].length - 1;
        int[] res = new int[matrix.length * matrix[0].length];
        for (int k = 0; k < res.length; k++) {
            res[k]=matrix[j][i];
            go();
        }
        return res;
    }

    private void go() {
        switch (direction) {
            case RIGHT:
                if (i == right) {
                    up++;
                    direction = Direction.DOWN;
                    j++;
                } else {
                    i++;
                }
                break;
            case DOWN:
                if (j == down) {
                    right--;
                    direction = Direction.LEFT;
                    i--;
                } else {
                    j++;
                }
                break;
            case LEFT:
                if (i == left) {
                    down--;
                    direction = Direction.UP;
                    j--;
                } else {
                    i--;
                }
                break;
            case UP:
                if (j == up) {
                    left++;
                    direction = Direction.RIGHT;
                    i++;
                } else {
                    j--;
                }
                break;
        }
    }



    // LC's method, ideas are same,but lc's code is more agent than mine
    /*
    执行耗时:1 ms,击败了67.15% 的Java用户
	内存消耗:43.1 MB,击败了75.30% 的Java用户
     */
    class Solution {
        public int[] spiralOrder(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return new int[0];
            }
            int rows = matrix.length, columns = matrix[0].length;
            int[] order = new int[rows * columns];
            int index = 0;
            int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
            while (left <= right && top <= bottom) {
                for (int column = left; column <= right; column++) {
                    order[index++] = matrix[top][column];
                }
                for (int row = top + 1; row <= bottom; row++) {
                    order[index++] = matrix[row][right];
                }
                if (left < right && top < bottom) {
                    for (int column = right - 1; column > left; column--) {
                        order[index++] = matrix[bottom][column];
                    }
                    for (int row = bottom; row > top; row--) {
                        order[index++] = matrix[row][left];
                    }
                }
                left++;
                right--;
                top++;
                bottom--;
            }
            return order;
        }
    }

}
