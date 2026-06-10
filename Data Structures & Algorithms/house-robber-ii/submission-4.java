class Solution {

    public int rob(int[] nums) {

        int n = nums.length;

        if(n == 1) {
            return nums[0];
        }

        int ans1 = solve(nums, 0, n - 1);

        int ans2 = solve(nums, 1, n);

        return Math.max(ans1, ans2);
    }

    private int solve(int[] nums, int start, int end) {

        int[] dp = new int[nums.length + 2];

        for(int i = end - 1; i >= start; i--) {

            int rob = nums[i] + dp[i + 2];

            int skip = dp[i + 1];

            dp[i] = Math.max(rob, skip);
        }

        return dp[start];
    }
}