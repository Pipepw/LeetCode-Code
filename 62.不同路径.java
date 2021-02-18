class Solution {
    int[][] nums;

    public int uniquePaths(int m, int n) {
        nums = new int[m][n];
        return findPaths(m, n);
    }

    public int findPaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        if (nums[m - 1][n - 1] == 0) {
            int left = findPaths(m, n - 1);
            int right = findPaths(m - 1, n);
            nums[m - 1][n - 1] = left + right;
        }
        return nums[m - 1][n - 1];
    }
}