class Solution {
    public int[] twoSum(int[] num, int target) {
        int n= num.length;
        for(int i=0;i<n;i++){
            for(int j=i+1; j<n; j++){
                if(num[i]+num[j]==target){
                    return new int[]{i+1,j+1};
                }
            }
           
        }
        return new int[]{-1,-1};
    }
}