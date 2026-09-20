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

        if(nums.length == 1) return nums[0];
        dp = new int[nums.length + 1];
      

        int[] temp = new int[nums.length - 1];
        int[] temp2 = new int[nums.length -1];
       
       int k = 0;
       for(int i =1; i<nums.length; i++){
        temp[k++] = nums[i];
       }

       k = 0;
       for(int i =0; i<nums.length-1; i++){
        temp2[k++] = nums[i];
       }
       Arrays.fill(dp, -1);
       int firstMax =  Solve(temp2, 0);
       Arrays.fill(dp, -1);
       int secondMax =  Solve(temp, 0);

       return Math.max(firstMax, secondMax);
        
    }
}
