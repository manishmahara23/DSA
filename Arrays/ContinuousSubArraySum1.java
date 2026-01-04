class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n =nums.length;
        int[] mod = new int[n+1];

        for(int i=1; i<=n; i++){
            mod[i] = mod[i-1] + nums[i-1];
            if(k != 0){
                mod[i] %=k;
            }
        }
        for(int i=0; i<n ; i++){
            for(int j=i+2; j<=n; j++){
                if(mod[i]==mod[j]){
                    return true;
                }
            }
        }
        return false;
    }
}
