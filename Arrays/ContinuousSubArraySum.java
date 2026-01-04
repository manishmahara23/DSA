
// Gives TLE on leetcode.
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        for(int i=0; i<n ; i++){
            int sum = nums[i];
            for(int j=i+1; j<n; j++){
                sum +=nums[j];
                if(k==0){
                    if(sum==0) return true;
                }else{
                    if(sum %k ==0) return true;
                }
            }
        }
        return false;
    }
}
