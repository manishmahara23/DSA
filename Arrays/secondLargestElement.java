import java.util.*;
class Solution {
    public int getSecondLargest(int[] arr) {
        
        int secondLargest=-1;
        int n = arr.length;
        Arrays.sort(arr);
        int largest=arr[n-1];
        // first pass obtain largest element
        for(int i=0; i<n; i++){
            if(arr[i]>largest){
            largest= arr[i];
            }
         }
         // second pass to find secondLargest
        for(int i=0; i<n;i++){
            if(arr[i]>secondLargest && arr[i]!= largest){
                secondLargest = arr[i];
            }
        }
        return secondLargest;
    }
}
     
