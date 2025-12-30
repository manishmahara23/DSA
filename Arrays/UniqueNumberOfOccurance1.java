class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> map= new HashMap<>();
        
        for(int num: arr){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        List<Integer> freqList= new ArrayList<>();
        
        for(int freq:map.values()){
            if(freqList.contains(freq)){
                return false;
            }
            freqList.add(freq);
        }
        return true;
    }
}