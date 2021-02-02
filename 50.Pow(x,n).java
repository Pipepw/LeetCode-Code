class Solution {

    public double myPow(double x, int n) {
        double temp = x;
        double res = 1;
        int flag = (n>0)?1:-1;
        n = (n>0) ? n : -1*n;
        String bin = Integer.toBinaryString(n);
        for(int i=bin.length()-1; i>=0; i--){
            if('1' == bin.charAt(i)){
                res *= temp;
            }
            temp *= temp;
        }
        return (flag<0)?1/res:res;
    }
}
