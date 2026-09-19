class Solution {
    int[] dp;
    int Solve(int[] cost, int ind){

        if(ind >= cost.length){
            return 0;
        }

        if(dp[ind] != -1) return dp[ind];
        
        int   os = cost[ind] + Solve(cost, ind + 1);
        int   ts = cost[ind] + Solve(cost , ind + 2);

        return dp[ind]= Math.min(os, ts);
    }
    public int minCostClimbingStairs(int[] cost) {
        dp = new int[cost.length];
        Arrays.fill(dp, -1);
        return Math.min(Solve(cost, 0), Solve(cost, 1));
    }
}
