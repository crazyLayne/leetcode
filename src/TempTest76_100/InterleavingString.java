package TempTest76_100;

public class InterleavingString {
	public static void main(String args[]){
//		"bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa"
//		"babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab"
//		"babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab"
//		s1 = "aabcc",
//				s2 = "dbbca", 
//				When s3 = "aadbbcbcac", return true.
//				When s3 = "aadbbbaccc", return false. 
		String s1="bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa";
		String s2="babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab";
		String s3="babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab";
		System.out.println(isInterleave(s1,s2,s3));
	}
	public static boolean isInterleave(String s1, String s2, String s3) {
//        if(s1.length()+s2.length()!=s3.length())return false;
//        return solve(s1,s2,s3);
		
//		int n1=s1.length();
//    	int n2=s2.length();
//    	if(n1+n2!=s3.length())return false;
//    	int[][] board=new int[n1+1][n2+1];
//    	return solve2(s1,s2,s3,0,0,board);
		
		return solve3(s1,s2,s3);
		
    }
	//递归求解
    public static boolean solve(String s1,String s2, String s3){
        if(s1.length()==0){
            if(s2.equals(s3))return true;
            else return false;
        }
        if(s2.length()==0){
            if(s1.equals(s3))return true;
            else return false;
        }
        char c1=s1.charAt(0);
        char c2=s2.charAt(0);
        char c3=s3.charAt(0);
        if(c1==c3 && c2==c3){
            if(solve(s1.substring(1,s1.length()),s2,s3.substring(1,s3.length())) || solve(s1,s2.substring(1,s2.length()),s3.substring(1,s3.length())))return true;
            else return false;
        }else if(c1==c3){
            return solve(s1.substring(1,s1.length()),s2,s3.substring(1,s3.length()));
        }else if(c2==c3){
            return solve(s1,s2.substring(1,s2.length()),s3.substring(1,s3.length()));
        }else{
            return false;
        }
        
    }
    
    //2-D动态规划
    public static boolean solve2(String s1,String s2,String s3, int i, int j, int[][] board){
    	if(board[i][j]==1){
    		return true;
    	}
    	if(board[i][j]==-1){
    		return false;
    	}
    	//若当前位置没计算过
    	if(i==s1.length()){
    		for(int k=j;k<s2.length();k++){
    			if(s2.charAt(k)!=s3.charAt(i+k)){
    				board[i][j]=-1;
    				return false;
    			}
    		}
    		board[i][j]=1;
			return true;
    	}
    	if(j==s2.length()){
    		for(int k=i;k<s1.length();k++){
    			if(s1.charAt(k)!=s3.charAt(j+k)){
    				board[i][j]=-1;
    				return false;
    			}
    		}
    		board[i][j]=1;
			return true;
    	}
        char c1=s1.charAt(i);
        char c2=s2.charAt(j);
        char c3=s3.charAt(i+j);
        if(c1==c3 && c2==c3){
            if(solve2(s1,s2,s3,i+1,j,board) || solve2(s1,s2,s3,i,j+1,board)){
            	board[i][j]=1;
        		return true;
        	}else{
        		board[i][j]=-1;
        		return false;
        	}
        }else if(c1==c3){
        	if(solve2(s1,s2,s3,i+1,j,board)){
        		board[i][j]=1;
        		return true;
        	}else{
        		board[i][j]=-1;
        		return false;
        	}
        }else if(c2==c3){
        	if(solve2(s1,s2,s3,i,j+1,board)){
        		board[i][j]=1;
        		return true;
        	}else{
        		board[i][j]=-1;
        		return false;
        	}
        }else{
        	board[i][j]=-1;
            return false;
        }
    }

    public static boolean solve3(String s1, String s2, String s3){
    	if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        boolean dp[][] = new boolean[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                } else {
                    dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
    public static boolean solve4(String s1,String s2,String s3){
    	if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        boolean dp[] = new boolean[s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[j] = true;
                } else if (i == 0) {
                    dp[j] = dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                } else if (j == 0) {
                    dp[j] = dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                } else {
                    dp[j] = (dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }
            }
        }
        return dp[s2.length()];
    }
}
