package finished;

public class LC9isPalindrome {
    public static void main(String[] args) {
        LC9isPalindrome l = new LC9isPalindrome();
        l.isPalindrome(121);
    }

    /*
    	执行耗时:5 ms,击败了98.05% 的Java用户
	内存消耗:41.6 MB,击败了27.78% 的Java用户
     */
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int origin=x;
        int reverse = 0;
        while (x != 0) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }
        if (reverse == origin) return true;
        return false;
    }

}
