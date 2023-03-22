package LC.finished;

public class LC2469convertTemperature {

    // 开氏度 = 摄氏度 + 273.15
    // 华氏度 = 摄氏度 * 1.80 + 32.00
    public double[] convertTemperature(double celsius) {
        double[] res=new double[2];
        res[0]=celsius+ 273.15 ;
        res[1]=celsius * 1.80 + 32.00 ;
        return res;
    }

}
