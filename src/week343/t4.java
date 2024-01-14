package week343;

public class t4 {
    public String smallestBeautifulString(String s, int k) {
        int n=s.length();
        char[] ch=s.toCharArray();
        ch[n-1]++;
        int i=n-1;
        while(i>=0&&i<n){
            if(ch[i]-'a'==k){
                if(i==0){
                    return "";
                }
                ch[i]='a';
                ch[i-1]++;
                i--;
            }else if((i>0&&ch[i-1]==ch[i])||(i>1&&ch[i-2]==ch[i])){
                ch[i]++;
            }else{
                i++;
            }
        }
        return new String(ch);
    }
}
