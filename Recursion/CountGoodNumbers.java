class Solution {
    private long MOD = 1_000_000_007;

    public int countGoodNumbers(long n) {
        // Even indices (0, 2, 4...) have 5 choices: {0, 2, 4, 6, 8}
        // Odd indices (1, 3, 5...) have 4 choices: {2, 3, 5, 7}
        long evenPositions = (n + 1) / 2;
        long oddPositions = n / 2;

        // Total = (5^even * 4^odd) % MOD
        long firstHalf = power(5, evenPositions);
        long secondHalf = power(4, oddPositions);

        return (int) ((firstHalf * secondHalf) % MOD);
    }

    private long power(long base, long exp) {
        if (exp == 0) return 1;
        
        // Recursive call to compute half power: base^(exp/2)
        long half = power(base, exp / 2);
        
        // If exp is even: (half * half) % MOD
        if (exp % 2 == 0) {
            return (half * half) % MOD;
        } else {
            // If exp is odd: (half * half * base) % MOD
            return (((half * half) % MOD) * base) % MOD;
        }
    }
}
