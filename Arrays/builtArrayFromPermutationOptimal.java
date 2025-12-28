class Solution {
    public int[] buildArray(int[] nums) {
        int n = nums.length;
        int[] ans= new int[n];
        for(int i=0; i<n; i++){
            ans[i]= nums[i] + n*(nums[nums[i]]%n);
        }
        for(int i=0; i<n; i++){
            ans[i]= ans[i]/n;
        }
        return ans;
    }
}