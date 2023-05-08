package finished;

public class LC16myPow {
    public static void main(String[] args) {
        LC16myPow l = new LC16myPow();
        double v = l.myPow(2,10);
        System.out.println(v);
    }

    public double myPow(double x, int n) {
        long N=n;
        if (n >= 0) return getModePow(x, N);
        return 1.0 / getModePow(x, -N);
    }

    public double getModePow(double x, long n) {
        double res = 1.0;
        double base = x;
        while (n >=1) {
            if (n % 2 == 0) {
                base = base * base;
            } else {
                res = res * base;
                base = base * base;
            }
            n = n / 2;
        }
        return res;
    }

    //too slow ,when x=1,n=2147483647
    public double getModePowX(double x, int n) {
        double res = 1;
        for (int i = 0; i < n; i++) {
            res = res * x;
        }
        return res;
    }


    public double myPowLC(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    public double quickMul(double x, long N) {
        double ans = 1.0;
        // 贡献的初始值为 x
        double x_contribute = x;
        // 在对 N 进行二进制拆分的同时计算答案
        while (N > 0) {
            if (N % 2 == 1) {
                // 如果 N 二进制表示的最低位为 1，那么需要计入贡献
                ans *= x_contribute;
            }
            // 将贡献不断地平方
            x_contribute *= x_contribute;
            // 舍弃 N 二进制表示的最低位，这样我们每次只要判断最低位即可
            N /= 2;
        }
        return ans;
    }
}
