package Algorithm;

import java.util.ArrayList;
import java.util.List;

public class RabinKarp {
  int MOD = 1000000007;
  int base = 256;
  public List<Integer> rollHash(String s, String t){
    int tLen = t.length();
    long hashVal = 0;
    List<Integer> res = new ArrayList<>();
    for (int i = 0; i < tLen; i++) {
      hashVal = (hashVal * base + t.charAt(i)) % MOD;
    }
    long hashRoll=0;
    for (int i = 0; i < tLen-1; i++ ){
      hashRoll = (hashRoll * base + s.charAt(i)) % MOD;
    }
    for(int i = tLen - 1; i < s.length(); i++){
      hashRoll = (hashRoll * base + s.charAt(i)) % MOD;
      if(hashRoll == hashVal) {
        res.add(i - tLen + 1);
      }
      hashRoll = (hashRoll - (s.charAt(i - tLen) * (int)(Math.pow(base,tLen)) % MOD + MOD)) % MOD;
    }
    return res;
  }

}
