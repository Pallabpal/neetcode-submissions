class Solution {
    int dp[][];
    public int Solve(int ind , int[] nums, int prev){

        if(ind == nums.length){
            return 0;
        }
        if(prev != -1){
            if(dp[ind][prev] != -1) return dp[ind][prev];
        } 
        int takeLen = Integer.MIN_VALUE;

        int notTakeLen = Solve(ind +1, nums, prev);

        if(prev == -1 || nums[prev] < nums[ind]){
            takeLen = 1 + Solve(ind + 1 , nums, ind);
        }

        if(prev != -1){
            dp[ind][prev] = Math.max(takeLen, notTakeLen);
        }

        return  Math.max(takeLen, notTakeLen);
    }
    public int lengthOfLIS(int[] nums) {
        dp = new int[nums.length][nums.length];

        for(int i =0; i<nums.length; i++){
            Arrays.fill(dp[i], -1);
        }
        return Solve(0, nums, -1);
    }
}
