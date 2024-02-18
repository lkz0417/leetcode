package biWeek124;

import java.util.Arrays;

public class t3 {
  int[][] memo;
  public int maxOperations(int[] nums) {
    int n = nums.length;
    memo = new int[n][n];
    int target = nums[0] + nums[n - 1];
    helper();
    int res = dfs(0, n - 1, target, nums);
    helper();
    target = nums[0] +nums[1];
    res = Math.max(res, dfs(0, n - 1, target, nums));
    helper();
    target = nums[n - 1] + nums[n - 2];
    res = Math.max(res, dfs(0, n - 1, target, nums));
    return res;
  }
  public void helper() {
    for (int i = 0; i < memo.length; i++) {
      Arrays.fill(memo[i], -1);
    }
  }
  public int dfs(int i, int j, int target, int[] nums) {
    if (i >= j) return 0;
    if (memo[i][j] != -1) return memo[i][j];
    int ans = 0;
    if (nums[i] + nums[j] == target) {
      ans = Math.max(ans, 1 + dfs(i + 1, j - 1, target, nums));
    }
    if (nums[i] + nums[i + 1] == target) {
      ans = Math.max(ans, 1 + dfs(i + 2, j, target, nums));
    }
    if (nums[j] + nums[j - 1] == target) {
      ans = Math.max(ans, 1 + dfs(i, j - 2, target, nums));
    }
    memo[i][j] = ans;
    return ans;
  }

}
