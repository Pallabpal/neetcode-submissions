class Solution {
    int[][] dp;
    int Solve(int[] prices , int ind, int buy){

        if(ind == prices.length){
            return 0;
        }
        if(dp[ind][buy] != -1) return dp[ind][buy];
        if(buy == 1){
            return dp[ind][buy] = Math.max(Solve(prices, ind +1, buy) 
            , -prices[ind]+Solve(prices, ind +1, 0));
        }

        return dp[ind][buy] = Math.max(Solve(prices, ind + 1, buy), prices[ind] + Solve(prices, ind+1, 1));
    }
    public int maxProfit(int[] prices) {
        dp = new int[prices.length][2];
        for(int i =0; i<prices.length ; i++){
            Arrays.fill(dp[i], -1);
        }
        return Solve(prices, 0, 1);
    }
}