package week347;

import java.util.*;

public class T4 {
    public int maxIncreasingCells(int[][] mat) {
        int m=mat.length,n=mat[0].length;
        TreeMap<Integer, List<int[]>> map=new TreeMap<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int val=mat[i][j];
                if(!map.containsKey(val)){
                    map.put(val, new ArrayList<int[]>() );
                }
                map.get(val).add(new int[]{i,j});
            }
        }
        int res=0;
        int[] rowMax=new int[m];
        int[] colMax=new int[n];
        int[][] dp=new int[m][n];
        for(Map.Entry<Integer,List<int[]>> entry:map.entrySet()){
            List<int[]> pos=entry.getValue();
            for(int i=0;i< pos.size();i++){
                int row=pos.get(i)[0],col=pos.get(i)[1];
                dp[row][col]=Math.max(rowMax[row],colMax[col])+1;
            }
            for(int k=0;k< pos.size();k++){
                int row=pos.get(k)[0],col=pos.get(k)[1];
                rowMax[row]=Math.max(rowMax[row],dp[row][col]);
                colMax[col]=Math.max(colMax[col],dp[row][col]);
                res=Math.max(res,Math.max(rowMax[row],colMax[col]));
            }
        }
        return  res;

    }
}
