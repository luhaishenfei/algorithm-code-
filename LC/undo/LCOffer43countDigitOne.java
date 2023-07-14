package undo;

public class LCOffer43countDigitOne {
    public static void main(String[] args) {
        LCOffer43countDigitOne l = new LCOffer43countDigitOne();
        System.out.println(l.countDigitOne(824883294));
    }


    int[] dpNumCount;
    int[] dpAllCount;

    //lang.OutOfMemoryError: Java heap space
    public int countDigitOne(int n) {
        dpNumCount = new int[n];
        dpAllCount = new int[n];

        dpNumCount[0] = 1;
        dpAllCount[0] = 1;
        for (int i = 1; i < n; i++) {
            get1Count(i + 1);
        }
        return dpAllCount[n - 1];
    }

    void get1Count(int n) {
        int i = n % 10;
        int head=0;
        if (n>9) {
            head = dpNumCount[n / 10-1];
        }
        if (i == 1) {
            dpNumCount[n-1] = head + 1;
            dpAllCount[n-1] = dpAllCount[n - 2] + dpNumCount[n-1];
        } else {
            dpNumCount[n-1] = head;
            dpAllCount[n-1] = dpAllCount[n - 2] + dpNumCount[n-1];
        }
    }
}
