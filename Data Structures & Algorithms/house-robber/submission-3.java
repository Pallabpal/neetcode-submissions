class Solution {

    int[] dp;

    int Solve(int[] nums, int ind){

        if(ind >= nums.length){
            return 0;
        }
        if(dp[ind] != -1) return dp[ind];
        int take = nums[ind] + Solve(nums, ind + 2);
        int notTake = Solve(nums, ind + 1);

        return dp[ind] = Math.max(take, notTake);
    }
    public int rob(int[] nums) {
        // dp = new int[nums.length];
        // Arrays.fill(dp, -1);
        // return Solve(nums, 0);

        int n = nums.length;

        int[] dp1 = new int[n+2];

        for(int ind = n-1; ind>=0; ind--){
            int take = nums[ind] + dp1[ind+2];
            int notTake = dp1[ind + 1];

            dp1[ind] = Math.max(take, notTake);
        }
        return dp1[0];
    }
}
