package biWeek124;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class T4 {
  public int maxSelectedElements(int[] nums) {
    TreeMap<Integer, Integer> map = new TreeMap<>();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    List<int[]> list = new ArrayList<>();
    int type = 1;
    int cnt = 0;
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      int key = entry.getKey();
      int val = entry.getValue();
      cnt++;
      if (val > 1) {
        type = 2;
      }
      Integer nextKey = map.higherKey(key);
      if (nextKey == null || nextKey - key > 2) {
        if (type == 1){
          list.add(new int[]{cnt, 3});
        }else {
          list.add(new int[]{cnt + 1, 3});
        }
        cnt = 0;
        type = 1;
        continue;
      }
      if (nextKey != null && nextKey - key == 2) {
        if (type == 1){
          list.add(new int[]{cnt, 1});
        }else {
          list.add(new int[]{cnt + 1, 2});
        }
        cnt = 0;
        type = 1;
        continue;
      }
    }
    int longest = list.get(0)[0], sum = list.get(0)[0];
    for (int i = 1; i < list.size(); i++) {
      int[] cur = list.get(i);
      int[] pre = list.get(i - 1);
      if (pre[1] == 3) {
        sum = cur[0];
      }else if (pre[1] == 1) {
        sum = cur[0] + pre[0];
      }else if (pre[1] == 2) {
        sum += cur[0];
      }
      longest = Math.max(sum, longest);
    }
    return longest;
  }

}
