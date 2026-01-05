class Solution {
    public int[] plusOne(int[] digits) {
    long nums=0;
    for(int d: digits){
        nums= nums*10 +d;
    }
    nums++;

    String s= String.valueOf(nums);
    int[] res = new int[s.length()];
    for(int i=0; i<s.length(); i++){
        res[i] = s.charAt(i) -'0';
    }
    return res;
    }
}