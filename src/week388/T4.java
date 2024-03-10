package week388;

public class T4 {
  public long maximumStrength(int[] nums, int k) {
    int n = nums.length;
    long[] s = new long[n + 1];
    for (int i = 0; i < n; i++) {
      s[i + 1] = s[i] + nums[i];
    }
    long[][] dp = new long[k + 1][n + 1];
    for (int i = 1; i <= k; i++) {
      int w = i % 2 == 0? i - k - 1 : k - i + 1;
      dp[i][i - 1] = Long.MIN_VALUE;
      long mx = Long.MIN_VALUE;
      for (int j = i; j <= n + i - k; j++) {
        mx = Math.max(mx, dp[i - 1][j - 1] - s[j - 1] * w);
        dp[i][j] = Math.max(dp[i][j - 1], s[j] * w + mx);
      }
    }
    return dp[k][n];
  }

}
