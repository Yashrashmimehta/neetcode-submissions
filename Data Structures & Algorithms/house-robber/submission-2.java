class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n+2];
        dp[0] = nums[0];

        for(int i=1;i<n;i++){
            int rob = nums[i];
            if(i>1){
        rob += dp[i-2]; 
            }
        int not = dp[i-1];

        dp[i] = Math.max(rob,not);
        }

        return dp[n-1];
        
    }
}
