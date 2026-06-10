class Solution {
    public int rob(int[] nums) {

        int n = nums.length;
        int dp1[] = new int[n];
        Arrays.fill(dp1,-1);

        int num[] = new int[n-1];
        int dp2[] = new int[num.length];
        Arrays.fill(dp2,-1);

        for(int i=0;i<num.length;i++){
            num[i] = nums[i];
        }

        return Math.max((house(num,0,dp2)),house(nums,1,dp1));
        
    }
    int house(int a[],int idx,int dp[])
    {
        if(a.length==1) return a[0];
        if(idx>=a.length) return 0;
    
        if(dp[idx]!=-1) return dp[idx];
        int rob=a[idx]+house(a,idx+2,dp);
        int skip=house(a,idx+1,dp);

        return dp[idx]=Math.max(rob,skip);
    }
}
