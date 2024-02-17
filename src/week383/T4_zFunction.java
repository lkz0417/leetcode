package week383;

public class T4_zFunction {
  public int minimumTimeToInitialState(String word, int k) {
    char[] c = word.toCharArray();
    int n = c.length;
    int l = 0, r = 0;
    int[] z = new int[n];
    for (int i = 1; i < n; i++) {
      if (i <= r) {
        z[i] = Math.min(z[i - l], r - i + 1);
      }
      while (i + z[i] < n && c[z[i]] == c[i + z[i]]) {
        l = i;
        r = i + z[i];
        z[i]++;
      }
      if (i % k == 0 && z[i] >= n - i) return i / k;
    }
    return (n - 1) / k + 1;
  }

}
