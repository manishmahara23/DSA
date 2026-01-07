class Solution {
    public boolean isPalindrome(int x) {

        // Negative numbers and numbers ending with 0 (except 0 itself) can't be palindromes
        if(x<0 || (x%10==0 && x !=0)){
            return false;
        }
        int original = x;
        int reverse = 0;

        while(x!=0){
            reverse = reverse * 10 + x % 10;
            x = x/10;
        }
        return reverse == original;
    }  
}