package Week354;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class T4 {
    public int longestValidSubstring(String word, List<String> forbidden) {
        Set<String> set=new HashSet<>(forbidden);
        int left=0,right=0,res=0;
        int n=word.length();
        for(;right<n;right++){
            for(int i=right;i>=left&&i>right-10;i--){
                if(set.contains(word.substring(i,right+1))){
                    left=i+1;
                    break;
                }
            }
            res=Math.max(res,right-left+1);
        }
        return res;
    }
}
