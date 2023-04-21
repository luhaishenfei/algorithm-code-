package LC.finished;

public class LCOffer10numWays {

    public static void main(String[] args) {
        LCOffer10numWays l = new LCOffer10numWays();
        System.out.println(l.numWays(3));
    }

    public int numWays(int n) {
        if (n<2) return 1;
        final int MOD = 1000000007;
        int[] dp= new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for (int i = 2 ; i <=n ; i++) {
            dp[i]=(dp[i-2]+dp[i-1]) % MOD;
        }
        return dp[n];
    }
}
