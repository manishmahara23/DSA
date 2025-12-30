class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int n = arr.length;
        boolean[] visited= new boolean[n];
        List<Integer> feq= new ArrayList<>();

        for(int i=0; i<n ; i++){
            if(visited[i]){
                continue;
            }
            int count=1;
            for(int j=i+1; j<n; j++){
                if(arr[i]==arr[j]){
                    visited[j]= true;
                    count++;
                }
            }
            if(feq.contains(count)) return false;
            feq.add(count);
        }
        return true;
    }
}