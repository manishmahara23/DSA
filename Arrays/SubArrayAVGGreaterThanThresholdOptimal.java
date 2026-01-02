class Solution {
    public int numOfSubarrays(int[] nums, int k, int threshold) {
        int n = nums.length;
        int target = k * threshold;
        int sum=0;
        int count =0;

        for(int i=0; i<k; i++ ){
            sum += nums[i];
        }
        if(sum>=target) count++;

        for(int i=k; i<n; i++){
            sum += nums[i];
            sum -= nums[i -k];

            if(sum>= target){
            count++;
        }
        
        }
        return count;
    }
}