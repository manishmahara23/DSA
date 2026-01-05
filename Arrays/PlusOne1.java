class Solution {
    public int[] plusOne(int[] digits) {
        int carry= 1;
        int n= digits.length;
        int [] temp = new int[n+1];

        for(int i=n-1; i>=0; i--){
            int sum = digits[i] + carry;
            temp[i+1] = sum % 10;
            carry = sum/10;
        }

        if(carry==1){
            temp[0] = 1;
            return temp;
        }
        int[] res = new int[n];
        for(int i=0; i<n; i++){
            res[i]= temp[i+1];
        }
        return res;
    }
}