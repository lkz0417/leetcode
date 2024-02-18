package week385;


import java.util.HashMap;
import java.util.Map;

public class T4Trie {
  public long countPrefixSuffixPairs(String[] words) {
     Node root = new Node();

     long res = 0;
     for (String word : words) {
       Node node = root;
       char[] ch = word.toCharArray();
       for (int i = 0; i < ch.length; i++) {
         char c1 = ch[i], c2 = ch[ch.length - 1 - i];
         int key = (c1 - 'a') * 26 + (c2 - 'a');
         node = node.son.computeIfAbsent(key, k -> new Node());
         res += node.cnt;
       }
       node.cnt++;
     }
     return res;
  }



}
class Node{
  Map<Integer, Node> son;
  int cnt;
  public Node() {
    son = new HashMap<>();
    cnt = 0;
  }
}
