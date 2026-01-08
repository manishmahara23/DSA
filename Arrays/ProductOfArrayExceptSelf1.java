class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int [] answer = new int[n];
        int [] prefix = new int[n];
        int [] suffex = new int[n];

        prefix[0]=1;
        for(int i=1; i<n; i++){
            prefix[i]= prefix[i-1] * nums[i-1];
        }

        suffex[n-1]=1;
        for(int i= n-2; i>=0;i--){
            suffex[i] = suffex[i+1] * nums[i+1];
        }
        for(int i=0;i<n;i++){
            answer[i] = prefix[i] * suffex[i];
        }
        return answer;
    }
}