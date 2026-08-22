class Solution {
    public int maxProfit(int[] prices) {
        
        int n = prices.length;

        int maxProfit = 0;
        int minSofar = prices[0];

        for(int i =1; i<n; i++){
            minSofar = Math.min(minSofar, prices[i]);
            int currProfit = prices[i] - minSofar;
            maxProfit = Math.max(maxProfit, currProfit);
        }

        return maxProfit;
    }
}
