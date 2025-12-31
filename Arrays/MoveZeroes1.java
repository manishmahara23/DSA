class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int[] temp= new int[n];
        int idx=0;
        for(int i=0; i<n; i++){
            if(nums[i]!=0){
                temp[idx++]= nums[i];
            }
        }
        for(int i=0; i<n; i++){
            nums[i]= temp[i];
        }
    }
}