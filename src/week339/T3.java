package week339;

import java.util.Arrays;

public class T3 {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
       int n=reward1.length;
       Integer[] idx=new Integer[n];
       for(int i=0;i<n;i++){
           idx[i]=i;
       }
        Arrays.sort(idx,(a,b)->((reward1[b]-reward2[b])-(reward1[a]-reward2[a])));
       int res=0;
       for(int i=0;i<n;i++){
           if(i<k){
               res+=reward1[idx[i]];
           }else{
               res+=reward2[idx[i]];
           }
       }
       return res;
    }
}
