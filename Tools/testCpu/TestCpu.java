public class TestCpu {

    //10.0.20.85             1135607320
    //10.0.19.168            1209337692
    public static void main(String[] args) {
        int times = 10;
        long res = 0;
        for (int i = 0; i < times; i++) {
            long startTime = System.currentTimeMillis();
            long endTime = startTime + 6000;
            long index = 0;
            while (true) {
                double x = Math.sqrt(index);
                long now = System.currentTimeMillis();
                if (now > endTime) {
                    break;
                }
                index++;
            }
            System.out.println(index + " Loops in 6 seconds,test NO."+ i);
            res+=index;
        }
        System.out.println(res/times + " avg Loops in 6 seconds,test "+ times +" times.");
    }
}
// company  i5-10500    1912852834
// my       desktop     1170471211
