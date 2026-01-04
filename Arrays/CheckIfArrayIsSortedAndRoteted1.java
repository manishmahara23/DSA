class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int drops = 0;

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                drops++;
            }
        }
        // check circular drop (last to first)
        if (nums[n - 1] > nums[0]) {
            drops++;
        }

        return drops <= 1;
    }
}