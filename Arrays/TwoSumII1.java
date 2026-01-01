class Solution {
    public int[] twoSum(int[] num, int target) {
        int n= num.length;
        for(int i=0; i<n; i++){
            int left=i+1, right=n-1;
            int needed= target - num[i];
            while(left<=right){
                int mid= left+(right-left)/2;
                if(num[mid]==needed){
                    return new int[]{i+1,mid+1};
                }else if(num[mid]<needed){
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }
        }
        return new int[]{-1,-1};
    }
}