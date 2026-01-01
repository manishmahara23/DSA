class Solution {
    public int[] twoSum(int[] num, int target) {
        int n= num.length;
        int left=0, right=n-1;
        while(left<right){
            int sum= num[left]+ num[right];

            if(sum==target){
                return new int[]{left+1, right+1};
            }else if(sum<target){
                left++;
            }else{
                right--;
            }
        }
        return new int[]{-1,-1};
    }
}