class Solution {
    
    int dp[];
    int Solve( int n, int i){
        if(i == n){
            return 1;
        }
        if( i> n){
            return 0;
        }
        if(dp[i] != -1) return dp[i];
        int os = Solve(n, i +1);
        int ts = Solve(n, i+2);

        return dp[i] =  os+ ts;
    }
    public int climbStairs(int n) {
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        return  Solve(n, 0);
    }
}
