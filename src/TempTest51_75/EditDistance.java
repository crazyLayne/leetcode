package TempTest51_75;

public class EditDistance {
	public static void main(String args[]){
		String s1="horse";
		String s2="ros";
		System.out.println(minDistance(s1,s2));
	}
	//unsolved
	public int minDistance1(String word1, String word2) {
        if(word1.length()>word2.length()){		//��word1��word2��
        	String word3=word1;
        	word1=word2;
        	word2=word3;
        }
        int len1=word1.length();
        int len2=word2.length();
        //�Ƚ�����word�ཻ���ֵģ��ȿ���word1��ȫ��word2��
        int smn=0;		//��ͬ�ַ���Ŀ
        int xj=len1;		//�ཻ���ֳ���
        for(int i=0;i<=len2-len1;i++){
        	smn=Math.max(samechar(word1,word2.substring(i, i+len1)), smn);
        }
        //���һ����ȫ�ཻ����µ������ͬ�ַ���Ŀ�󣬲����ཻ���ཻ���ȱ�����ڴ�ֵ
        //word1��word2�������Ų��,ѭ���������Զ�̬�仯
		for(int i=1;len1-i>smn;i++){
			if(samechar(word1.substring(i, len1),word2.substring(0, len1-i))>smn){
				smn=samechar(word1.substring(i, len1),word2.substring(0, len1-i));
				xj=len1-i;
			}
		}
		//word1��word2�Ҳ�����Ų��
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
	public int samechar(String s1,String s2){		//s1��s2������ͬ
		int sum=0;
		for(int i=0;i<s1.length();i++){
			if(s1.charAt(i)==s2.charAt(i))sum++;
		}
		return sum;
	}
	//��̬�滮
	public static int minDistance(String word1, String word2) {
		int L1=word1.length();
		int L2=word2.length();
		int[][] dp=new int[L1+1][L2+1];		//dp[i][j]��ʾ��i��j��β��word1��word2���������,i,jΪ0��ʾ������Ϊ��
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
		int a=solve(s1,s2,i-1,j-1,dp)+(s1.charAt(i-1)==s2.charAt(j-1)?0:1);     //s1��s2������һ���ַ�������ͬ���滻����+1
		int b=solve(s1,s2,i-1,j,dp)+1;          //s1����һ���ַ�
		int c=solve(s1,s2,i,j-1,dp)+1;          //s2����һ���ַ�
		dp[i][j]=Math.min(a, Math.min(b, c));
		return dp[i][j];
	}
}
