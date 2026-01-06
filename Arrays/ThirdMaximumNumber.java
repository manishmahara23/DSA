class Solution {
    public int thirdMax(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);

        int size = list.size();
        if(size>=3){
            return list.get(size - 3);
        }
        return list.get(size-1);
    }
}