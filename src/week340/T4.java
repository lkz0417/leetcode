package week340;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T4 {
    public int minimumVisitedCells(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        List<int[]>[] cols=new ArrayList[n];
        Arrays.setAll(cols,e->new ArrayList<>());
        int mn=0;
        for(int i=m-1;i>=0;i--){
            List<int[]> rows=new ArrayList<>();
            for(int j=n-1;j>=0;j--){
                mn=Integer.MAX_VALUE;
                if(i==m-1&&j==n-1){
                    mn=0;
                }else if(grid[i][j]>0){
                    int g=grid[i][j];
                    int k=binarySearch(rows,j+g);
                    if(k<rows.size()) mn=Math.min(mn, rows.get(k)[0]);
                    k=binarySearch(cols[j],i+g);
                    if(k<cols[j].size()) mn=Math.min(mn,cols[j].get(k)[0]);

                }
                if(mn==Integer.MAX_VALUE)continue;
                ++mn;
                while(!rows.isEmpty()&&rows.get(rows.size()-1)[0]>=mn){
                    rows.remove(rows.size()-1);
                }
                rows.add(new int[]{mn,j});
                while(!cols[j].isEmpty()&&cols[j].get(cols[j].size()-1)[0]>=mn){
                    cols[j].remove(cols[j].size()-1);
                }
                cols[j].add(new int[]{mn,i});
            }
        }
        return mn<Integer.MAX_VALUE?mn:-1;
    }

    public int binarySearch(List<int[]> list,int target){
        int left=0,right=list.size();
        while(left<right){
            int mid=(left+right)/2;
            if(list.get(mid)[1]>target)left=mid+1;
            else right=mid;
        }
        return left;
    }
}
