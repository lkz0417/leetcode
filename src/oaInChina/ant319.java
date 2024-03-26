package oaInChina;

import java.util.PriorityQueue;

public class ant319 {
  public int maxSumInKRange(int[] nums, int k) {
    int n = nums.length;
    int[] dp = new int[n];
    dp[0] = nums[0];
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
    pq.offer(new int[]{dp[0], 0});
    for (int i = 1; i < n; i++) {
      while (pq.peek()[0] <= i - k) {
        pq.poll();
      }
      dp[i] = nums[i] + pq.peek()[1];
      pq.offer(new int[]{dp[i], i});
    }
    int res = 0;
    for (int i = n - 1; i >= n - k; i--) {
      res = Math.max(res, dp[i]);
    }
    return  res;
  }

}
