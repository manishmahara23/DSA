class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;

        for(int i=0 ; i< n-1; i++){
            int min_idx= i;
            for(int j=i+1; j<n; j++){
                if(nums[j]<nums[min_idx]){
                    min_idx= j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[min_idx];
            nums[min_idx] = temp;
        }
        return nums;
    }
}