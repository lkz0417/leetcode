package week349;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T4 {
    public int[] maximumSumQueries(int[] nums1, int[] nums2, int[][] queries) {
        int n=nums1.length,m= queries.length;
        int[][] pair=new int[n][2];
        for(int i=0;i<n;i++){
            pair[i][0]=nums1[i];
            pair[i][1]=nums2[i];
        }
        Arrays.sort(pair,(a,b)->(b[0]-a[0]));
        Integer[] idx=new Integer[m];
        for(int i=0;i<m;i++){
            idx[i]=i;
        }
        Arrays.sort(idx,(a,b)->(queries[b][0]-queries[a][0]));
        int[] ans=new int[m];
        int j=0;
        List<int[]> list= new ArrayList<>();
        for(int i:idx){
            int x=queries[i][0],y=queries[i][1];
            for(;j<n&&pair[j][0]>=x;j++){
                while(!list.isEmpty()&&list.get(list.size()-1)[1]<=pair[j][0]+pair[j][1]){
                    list.remove(list.size()-1);
                }
                if(list.isEmpty()||list.get(list.size()-1)[0]<pair[j][1]){
                    list.add(new int[]{pair[j][1],pair[j][0]+pair[j][1]});
                }
            }
            int pos=lowBound(list,y);
            ans[i]=pos== list.size()?-1:list.get(pos)[1];
        }
        return ans;
    }
    public int lowBound(List<int[]> list,int target){
        int left=0,right=list.size();
        while(left<right){
            int mid=(left+right)>>1;
            if(list.get(mid)[0]>=target){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return left;
    }
}
