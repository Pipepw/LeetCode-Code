class Solution {
    int[] isReachable;

    public boolean canJump(int[] nums) {
        // 默认就是false，这样没办法记录新的结果，所以用int
        isReachable = new int[nums.length]; // 默认为0，成功为1，失败为2
        find(nums, 0);
        return isReachable[0] == 1;
    }

    public void find(int[] nums, int loc) {
        if (loc + nums[loc] >= nums.length - 1) {
            isReachable[loc] = 1;
            return;
        }
        for (int i = 1; i <= nums[loc]; i++) {
            if (isReachable[loc + i] == 0) {
                find(nums, loc + i);
            }
            if (isReachable[loc + i] == 1) {
                isReachable[loc] = 1;
                return;
            }
        }
        isReachable[loc] = 2;
    }
}