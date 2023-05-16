package finished;

public class LC17printNumbers {
    public static void main(String[] args) {
        LC17printNumbers l = new LC17printNumbers();
        l.printNumbers(3);
    }

    /*
    执行耗时:1 ms,击败了69.30% 的Java用户
	内存消耗:50.9 MB,击败了5.02% 的Java用户
     */
    public int[] printNumbers(int n) {
        n=powInt(10,n);
        int[] res = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            res[i] = i + 1;
        }
        return res;
    }

    public int powInt(int n, int p) {
        if (p==0) return 1;
        for (int i = 1; i < p; i++) {
            n *= 10;
        }
        return n;
    }

    //大数打印的情况：LC
    int[] res;
    int nine = 0, count = 0, start, n;
    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public int[] printNumbersLCBigNum(int n) {
        this.n = n;
        res = new int[(int)Math.pow(10, n) - 1];
        num = new char[n];
        start = n - 1;
        dfs(0);
        return res;
    }
    void dfs(int x) {
        if(x == n) {
            String s = String.valueOf(num).substring(start);
            if(!s.equals("0")) res[count++] = Integer.parseInt(s);
            if(n - start == nine) start--;
            return;
        }
        for(char i : loop) {
            if(i == '9') nine++;
            num[x] = i;
            dfs(x + 1);
        }
        nine--;
    }
}
