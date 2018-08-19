package TempTest26_50;

//Some examples:
//isMatch("aa","a") → false
//isMatch("aa","aa") → true
//isMatch("aaa","aa") → false
//isMatch("aa", "*") → true
//isMatch("aa", "a*") → true
//isMatch("ab", "?*") → true
//isMatch("aab", "c*a*b") → false

public class WildcardMatching {
	public static void main(String args[]){
		System.out.println(isMatch("aab","*a*b*"));
	}
	public static boolean isMatch(String s, String p) {
        int[][] flag=new int[s.length()+1][p.length()+1];
        return dp(0,0,s,p,flag);
    }
    public static boolean dp(int i, int j, String s, String p, int[][] flag){
        if(j==p.length()) return i==s.length();			//p到头了
        if(i==s.length()){
        	if(p.charAt(j)=='*'){
        		return dp(i,j+1,s,p,flag);
        	}else{
        		return false;
        	}
        } 
        if(flag[i][j]==1)return true;
        if(flag[i][j]==-1)return false;
        char cs=s.charAt(i);
        char cp=p.charAt(j);
        if(cp=='?' || cs==cp){      //i+1,j+1
            if(i<s.length() && dp(i+1,j+1,s,p,flag)){
                flag[i][j]=1;
                return true;
            }
        }else if(cp=='*'){     //i,j+1(*表示0个字符) or i+1,j(*表示任意多个字符)
            if((i<s.length() && dp(i+1,j,s,p,flag)) || dp(i,j+1,s,p,flag)){
                flag[i][j]=1;
                return true;
            }
        }
        flag[i][j]=-1;
        return false;
    }

}
