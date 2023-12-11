public class UglyNumber {
    public int nthUgly(int n) {
        if(n==1) {
            return 1;
        }
        int[] ugly = new int[n];
        ugly[0] = 1;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        int factor2 = 2;
        int factor3 = 3;
        int factor5 = 5;
        for(int i = 1; i < n; i ++) {
            int minn = Math.min(Math.min(factor2, factor3),factor5);
            ugly[i] = minn;
            if(factor2  == minn) {
                factor2 = 2*ugly[++index2];
            }
            if(factor3 == minn) {
                factor3 = 3*ugly[++index3];
            }
            if(factor5 == minn) {
                factor5 = 5*ugly[++index5];
            }
        }
        return ugly[n-1];
    }
}
