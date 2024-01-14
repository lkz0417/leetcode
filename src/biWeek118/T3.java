package biWeek118;

import java.util.ArrayDeque;
import java.util.Deque;

public class T3 {
    public int minimumCoins(int[] prices){
        int n=prices.length;
        Deque<int[]> queue=new ArrayDeque<>();
        for (int i = n; i > 0;i--){
            while(!queue.isEmpty()&&queue.peekLast()[0]>2*i+1){
                queue.pollLast();
            }
            int f=prices[i-1]+queue.peekLast()[1];
            while(!queue.isEmpty()&&queue.peekFirst()[1]>=f){
                queue.pollFirst();
            }
            queue.offerFirst(new int[]{i,f});
        }
        return queue.peekFirst()[1];
    }
}
