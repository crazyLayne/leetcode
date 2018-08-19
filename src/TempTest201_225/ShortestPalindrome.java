package TempTest201_225;

public class ShortestPalindrome {
	public static void main(String args[]){
		System.out.print(shortestPalindrome("aacecaaa"));
	}
	//暴力求解，先判断n是否回文，在判断n-1是否回文，O(n^2)
	public static String shortestPalindrome(String s){
		int len=s.length();
        if(len==0 || len==1)return s;
        int maxR=0;
        int left,right;
        //固定左端,从右向左着第一个回文，即是最长回文
        for(int i=len-1;i>=0;i--){
            left=0;
            right=i;
            boolean flag=true;
            while(left<right){
                if(s.charAt(left)!=s.charAt(right)){flag=false;break;}
                left++;
                right--;
            }
            if(flag){
            	maxR=i;
            	break;
            }
        }
        String str=s.substring(maxR+1,len);
        str=new StringBuilder(str).reverse().toString();
        return str+s;
        
	}

}
