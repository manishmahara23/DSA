class Solution {
    public int[] sortArray(int[] nums) {
        bubbleSort(nums, nums.length);
        return nums;
    }
    public void bubbleSort( int[] nums, int n){
        if(n==1) return;

        for(int i=0; i<n-1; i++){
            if(nums[i] > nums[i+1]){
                int temp = nums[i];
                nums[i] = nums[i+1];
                nums[i+1] = temp;
            }
        }
        bubbleSort(nums,n-1);
    }
}