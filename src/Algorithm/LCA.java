package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LCA {
  int[][] fa;
  int[] depth;
  public LCA(int[][] edges) {
    int n = edges.length + 1;
    List<Integer>[] g = new ArrayList[n];
    Arrays.setAll(g, e -> new ArrayList<>());
    for (int [] edge : edges) {
      g[edge[0]].add(edge[1]);
      g[edge[1]].add(edge[0]);
    }
    int m = 32 - Integer.numberOfLeadingZeros(n);
    fa = new int[n][m];
    depth = new int[n];
    dfs(g, 0, -1);
    for (int i = 0; i < m - 1; i++) {
      for (int j = 0; j < n; j++) {
        int p = fa[j][i];
        fa[j][i + 1] = p > 0? fa[p][i] : -1;
      }
    }
  }

  public void dfs(List<Integer>[] g, int x, int pa) {
    fa[x][0] = pa;
    for (int next : g[x]) {
      if (next == pa) continue;
      depth[next] = depth[x] + 1;
      dfs(g, next, x);
    }
  }

  public int getKthAncestor(int node , int k) {
    int m = 32 - Integer.numberOfLeadingZeros(k);
    for (int i = 0; i < m; i++) {
      if ((((k >> i) & 1) == 1)) {
        node = fa[node][i];
        if (node == -1) return -1;
      }
    }
    return node;
  }

  public int getLCA(int x, int y) {
    if (depth[x] > depth[y]) {
      int tmp = depth[x];
      depth[x] = depth[y];
      depth[y] = tmp;
    }
     y = getKthAncestor(y, depth[y] - depth[x]);
    if (x == y) {
      return x;
    }
    for (int i = fa[0].length - 1; i >= 0; i--) {
      int px = fa[x][i], py = fa[y][i];
      if (px != py) {
        x = px;
        y = py;
      }
    }
    return fa[x][0];
  }



}
