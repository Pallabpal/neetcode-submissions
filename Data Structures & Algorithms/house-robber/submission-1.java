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
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return Solve(nums, 0);
    }
}
