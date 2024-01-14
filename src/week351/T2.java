package week351;

public class T2 {
    public int makeTheIntegerZero(int num1, int num2) {
        for(long k=1;k<=num1-num2*k;k++){
            if(k>=Long.bitCount((long)(num1-num2*k))){
                return (int)k;
            }
        }
        return -1;
    }
}
