class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> one = new ArrayList<>();
        find(0, nums, one, true);
        return res;
    }
    public void find(int index, int[] nums, List<Integer> one, boolean isChoose){
        if(isChoose){
            List<Integer> temp = new ArrayList<>(one);
            res.add(temp);
        }
        if(index >= nums.length){
            return;
        }
        find(index + 1, nums, one, false);
        one.add(nums[index]);
        find(index + 1, nums, one, true);
        one.remove((Object)nums[index]);
    }
}