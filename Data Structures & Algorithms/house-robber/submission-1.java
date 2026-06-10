class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp,-1);

       return solve(nums,n-1,dp);
    }
    private int solve(int[]a,int i,int[]dp){
        if(i<0) return 0;
        if(dp[i]!=-1) return dp[i];
        int rob = a[i]+ solve(a,i-2,dp);
        int not = solve(a,i-1,dp);

        return dp[i] = Math.max(rob,not);
    }
}
