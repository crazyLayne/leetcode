package TempTest51_75;

public class EditDistance {
	public static void main(String args[]){
		String s1="horse";
		String s2="ros";
		System.out.println(minDistance(s1,s2));
	}
	//unsolved
	public int minDistance1(String word1, String word2) {
        if(word1.length()>word2.length()){		//让word1比word2短
        	String word3=word1;
        	word1=word2;
        	word2=word3;
        }
        int len1=word1.length();
        int len2=word2.length();
        //比较两个word相交部分的，先考虑word1完全在word2中
        int smn=0;		//相同字符数目
        int xj=len1;		//相交部分长度
        for(int i=0;i<=len2-len1;i++){
        	smn=Math.max(samechar(word1,word2.substring(i, i+len1)), smn);
        }
        //求出一个完全相交情况下的最大相同字符数目后，部分相交的相交长度必须高于此值
        //word1从word2左侧依次挪出,循环条件可以动态变化
		for(int i=1;len1-i>smn;i++){
			if(samechar(word1.substring(i, len1),word2.substring(0, len1-i))>smn){
				smn=samechar(word1.substring(i, len1),word2.substring(0, len1-i));
				xj=len1-i;
			}
		}
		//word1从word2右侧依次挪出
		for(int i=len1-1;i>smn;i--){
			if(samechar(word1.substring(i, len1),word2.substring(0, len1-i))>=smn){
				if(i>xj){
					smn=samechar(word1.substring(i, len1),word2.substring(0, len1-i));
					xj=i;
				}
			}
		}
		return len2+len1-xj-smn;
    }
	public int samechar(String s1,String s2){		//s1和s2长度相同
		int sum=0;
		for(int i=0;i<s1.length();i++){
			if(s1.charAt(i)==s2.charAt(i))sum++;
		}
		return sum;
	}
	//动态规划
	public static int minDistance(String word1, String word2) {
		int L1=word1.length();
		int L2=word2.length();
		int[][] dp=new int[L1+1][L2+1];		//dp[i][j]表示以i，j结尾的word1和word2的子序距离,i,j为0表示子序列为空
		return solve(word1,word2,L1,L2,dp);
	}
	public static int solve(String s1, String s2, int i, int j, int[][] dp){
		if(dp[i][j]!=0) return dp[i][j];
		if(i==0 || j==0){
			dp[i][j]=i+j;
			return dp[i][j];
		}
		if(i==1&&j==1){
			dp[i][j]=(s1.charAt(i-1)==s2.charAt(j-1))?0:1;
			return dp[i][j];
		}
		int a=solve(s1,s2,i-1,j-1,dp)+(s1.charAt(i-1)==s2.charAt(j-1)?0:1);     //s1和s2各抵消一个字符，不相同则替换操作+1
		int b=solve(s1,s2,i-1,j,dp)+1;          //s1抵消一个字符
		int c=solve(s1,s2,i,j-1,dp)+1;          //s2抵消一个字符
		dp[i][j]=Math.min(a, Math.min(b, c));
		return dp[i][j];
	}
}
