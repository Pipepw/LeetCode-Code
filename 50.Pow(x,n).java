class Solution {

    public double myPow(double x, int n) {
        double res = 1;
        if (n == 0) {
            return res;
        } else if (n > 0) {
            for (int i = 0; i < n; i++) {
                res *= x;
            }
        } else {
            n *= -1;
            for (int i = 0; i < n; i++) {
                res *= x;
            }
            res = 1 / res;
        }
        return res;
    }
}
