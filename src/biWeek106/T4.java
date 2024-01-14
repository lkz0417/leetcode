package biWeek106;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T4 {
    public List<Integer> goodSubsetofBinaryMatrix(int[][] grid) {
       int m=grid.length,n=grid[0].length;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<m;i++){
            int mask=0;
            for(int j=0;j<n;j++){
                mask|=(grid[i][j]<<j);
            }
            map.put(mask,i);
        }
        if(map.containsKey(0))return List.of(map.get(0));
        for(Map.Entry<Integer,Integer> entry1:map.entrySet()){
            for(Map.Entry<Integer,Integer> entry2: map.entrySet()){
                if((entry1.getKey()&entry2.getKey())==0){
                    int i= entry1.getValue(),j=entry2.getValue();
                    return i>j?List.of(j,i):List.of(i,j);
                }
            }
        }
        return List.of();
    }
}
