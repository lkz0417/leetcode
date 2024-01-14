package biWeek108;

public class T3 {
    int cnt=0;
    int minLen=10000;
    public int minimumBeautifulSubstrings(String s) {
        int n=s.length();
        backtrack(s,0);
        return minLen;
    }
    public void backtrack(String s,int start){
        if(start==s.length()){
            minLen=Math.min(minLen,cnt);
            return;
        }
        if(s.charAt(start)=='0')return;
        for(int i = start; i<s.length();i++){
            String temp=s.substring(start,i+1);
            if(!isLeagl(temp)){
                continue;
            }
            cnt++;
            backtrack(s,i+1);
            cnt--;
        }
    }
    public boolean isLeagl(String s){
        int n=s.length();
        int ans=0;
        int num=1;
        for(int i=n-1;i>=0;i--){
            if(s.charAt(i)!='0'){
                ans+=num;
            }
            num*=2;
        }
        return ans==1||(ans%5==0);
    }


}
class a{
    public static void main(String[] args) {
        T3 t3=new T3();
        int a=t3.minimumBeautifulSubstrings("100111000110111");
        System.out.println(a);
    }


}
