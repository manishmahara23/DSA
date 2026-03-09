class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return calculate(nums, 0, 0, target);
    }

    private int calculate(int[] nums, int index, int currentSum, int target) {
        if (index == nums.length) {
            return currentSum == target ? 1 : 0;
        }

        int add = calculate(nums, index + 1, currentSum + nums[index], target);
        int subtract = calculate(nums, index + 1, currentSum - nums[index], target);

        return add + subtract;
    }
}