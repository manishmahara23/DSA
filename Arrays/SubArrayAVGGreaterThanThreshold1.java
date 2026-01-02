class Solution {
    public int numOfSubarrays(int[] nums, int k, int threshold) {
        int n = nums.length;
        int target = k * threshold;
        int[] prefix = new int [n + 1];

        for(int i=0; i<n; i++){
            prefix[i+1]= prefix[i] + nums[i];
        }

        int count=0;
        for(int i=0; i<= n - k; i++){
            int sum = prefix[i + k ] - prefix[i];
            if(sum >= target){
                count ++;
            }
        }
        return count;
    }
}