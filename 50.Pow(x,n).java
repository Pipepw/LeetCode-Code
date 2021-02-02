class Solution {

    public double myPow(double x, int n) {
        double res = 1;
        int flag = (n > 0) ? 1 : -1;
        if (n == 0 || x == 1) {
            return res;
        }
        if (x == -1) {
            return (n % 2 == 0) ? 1 : -1;
        }
        n = (n > 0) ? n : (n > -2147483648) ? -1 * n : -1;
        if (n == -1) {
            return 0;
        }
        for (int i = 0; i < n; i++) {
            res *= x;
        }
        if (flag < 0) {
            res = 1 / res;
        }
        return res;
    }
}
