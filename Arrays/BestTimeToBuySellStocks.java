class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxprofit =0;
        for(int i=0;i<n ;i++){
            for(int j=i+1; j<n ; j++){
                int profit = prices[j] - prices[i];
                maxprofit = Math.max(maxprofit, profit);
            }
        }
        return maxprofit;
    }
}