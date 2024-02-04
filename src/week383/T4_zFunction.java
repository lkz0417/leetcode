package week383;

public class T4_zFunction {
  public int minimumTimeToInitialState(String word, int k) {
    char[] c = word.toCharArray();
    int n = c.length;
    int[] ans = new int[n];
    int l = 0, r = 0;
    for (int i = 1; i < n; i++) {
      if(i <= r) {
        ans[i] = Math.min(ans[i - l], r - i + 1);
      }
      while(i + ans[i] < n && c[i + ans[i]] == c[ans[i]]) {
        r = i + ans[i];
        l = i;
        ans[i]++;
      }
      if (i % k ==0 && ans[i] >= n -i) {
        return i / k;
      }
    }
    return (n - 1) / k + 1;
  }

}
