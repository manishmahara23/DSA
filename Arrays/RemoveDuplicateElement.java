
class Solution {
    // Function to remove duplicates from the given array.
    ArrayList<Integer> removeDuplicates(int[] arr) {
        Set<Integer> set = new LinkedHashSet<>();
        
        for(int num: arr){
            set.add(num);
        }
          ArrayList<Integer> result = new ArrayList<>(set);
        return result;
}
