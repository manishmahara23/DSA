class Solution {
    public int removeDuplicates(int[] nums) {
        Set <Integer> set= new LinkedHashSet<>();
        for(int num: nums){
            set.add(num);
        }
        int idx=0;
        for(int val: set){
            nums[idx++]= val;
        }
        return idx;
        }
}