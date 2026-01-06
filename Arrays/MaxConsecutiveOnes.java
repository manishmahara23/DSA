class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n= nums.length;
        int maxCount = 0;

        for(int i=0;i<n ;i++){
            if(nums[i]==1){
                int count =0;
                for(int j=i; j<n && nums[j]==1; j++){
                    count++;
                }
                maxCount = Math.max(maxCount, count);
             }
        }
        return maxCount ;
    }
}