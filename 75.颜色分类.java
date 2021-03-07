class Solution {
    public void sortColors(int[] nums) {
        int WhitePointStart = 0, BluePointStart = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0 ){
                swap(WhitePointStart, i, nums);
                if(WhitePointStart < BluePointStart){
                    swap(BluePointStart, i, nums);
                }
                WhitePointStart++;
                BluePointStart++;
            } else if(nums[i] == 1){
                swap(BluePointStart++, i, nums);
            }
        }
        System.out.println(Arrays.toString(nums));
    }
    public void swap(int a, int b, int[] nums){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}