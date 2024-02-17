package Algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class HierholzerEulerPath {
  Map<String, PriorityQueue<String>> map = new HashMap<>();
  List<String> res  = new ArrayList<>();
  public List<String> findItinerary(List<List<String>> tickets) {
    for (List<String> list : tickets) {
      String src = list.get(0);
      String des = list.get(1);
      if (!map.containsKey(src)) {
        map.put(src, new PriorityQueue<>());
      }
      map.get(src).offer(des);
    }
    dfs("start");
    Collections.reverse(res);
    return res;
  }
  public void dfs(String cur) {
    while(map.containsKey(cur) && map.get(cur).size() > 1) {
      String next = map.get(cur).poll();
      dfs(next);
    }
    res.add(cur);
  }

}
