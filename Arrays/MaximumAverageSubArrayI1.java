class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int[] prefix= new int[n+1];

        for(int i=0; i<n; i++){
            prefix[i+1]= prefix[i] + nums[i];
        }
        double maxSum= Integer.MIN_VALUE;
        for(int i=k; i<=n; i++){
            maxSum= Math.max(maxSum, prefix[i]-prefix[i-k]);
        }
        return maxSum/k;
    }
}