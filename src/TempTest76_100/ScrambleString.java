package TempTest76_100;

public class ScrambleString {
	public static void main(String args[]){
//		System.out.print(isScramble("1234","4321"));
//		System.out.print(isScramble("ccabcbabcbabbbbcbb","bbbbabccccbbbabcba"));
		System.out.print("abc".substring(1));
	}

	public static boolean isScramble(String s1,String s2){
		int len=s1.length();
		char[] chs1 = s1.toCharArray();
		char[] chs2 = s2.toCharArray();
		int[][][] flag=new int [len][len][len];			//s1开始节点坐标，s2开始节点坐标，往后取的长度
		return isS(chs1, 0, chs1.length-1, chs2, 0, chs2.length-1, flag);
	}
	// L1,R1是chs1的左右位置，L2,R2是chs2的左右位置
	public static boolean isS(char[] chs1, int L1, int R1, char[] chs2, int L2, int R2, int[][][] flag){
		if(flag[L1][L2][R1-L1]==1)return true;
		if(flag[L1][L2][R1-L1]==-1)return false;
		if(L1==R1){			//一个点
			boolean temp = chs1[L1]==chs2[L2];
			flag[L1][L2][0] = temp?1:-1;  
			return temp;
		}else{
			int len=0;		//遍历分割点
			while(len<R1-L1){ 
				if(isS(chs1, L1, L1+len, chs2, L2, L2+len, flag)){		//都往前面取len比较
					flag[L1][L2][len]=1;
					if(isS(chs1, L1+len+1, R1, chs2, L2+len+1, R2, flag)){
						flag[L1+len+1][L2+len+1][R1-(L1+len+1)]=1;
						flag[L1][L2][R1-L1]=1;
						return true;
					}
					flag[L1+len+1][L2+len+1][R1-(L1+len+1)]=-1;
				}else flag[L1][L2][len]=-1;
				
				if(isS(chs1, L1, L1+len, chs2, R2-len, R2, flag)){ 		//chs1往前取len，chs2往后取len
					flag[L1][R2-len][len]=1;
					if(isS(chs1, L1+len+1,R1, chs2, L2, R2-len-1, flag)){
						flag[L1+len+1][R2-len-1][R1-(L1+len+1)]=1;
						flag[L1][L2][R1-L1]=1;
						return true;
					}
					flag[L1+len+1][R2-len-1][R1-(L1+len+1)]=-1;
				}else flag[L1][R2-len][len]=-1; 
				len++;
			}
			return false;//遍历完毕
			
		}
	}
	// time out
	public static boolean isScramble2(String s1, String s2){		
		int len=s1.length();
		char[] chs1 = s1.toCharArray();
		char[] chs2 = s2.toCharArray();
		return iss(chs1, 0, chs1.length-1, chs2, 0, chs2.length-1);
	}
	// L1,R1是chs1的左右位置，L2,R2是chs2的左右位置
	public static boolean iss(char[] chs1, int L1, int R1, char[] chs2, int L2, int R2){
		if(L1==R1){			//一个点
			return chs1[L1]==chs2[L2];
		}else{
			int len=0;		//遍历分割点
			while(len<R1-L1){ 
				if(iss(chs1, L1, L1+len, chs2, L2, L2+len)){		//都往前面取len比较
					if(iss(chs1, L1+len+1, R1, chs2, L2+len+1, R2)){
						return true;
					}
				}
				if(iss(chs1, L1, L1+len, chs2, R2-len, R2)){ 		//chs1往前取len，chs2往后取len
					if(iss(chs1, L1+len+1,R1, chs2, L2, R2-len-1)){
						return true;
					}
				} 
				len++;
			}
			return false;//遍历完毕
			
		}
	}
	//
	public static boolean isScramble3(String s1, String s2){
		if (s1.equals(s2)) return true;
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 != len2) return false;
        
        int[] count = new int[26];
        
        for (int i = 0; i < len1; i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) return false;
        }
        
        for (int i = 1; i < len1; i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) && 
               isScramble(s1.substring(i), s2.substring(i))) 
                return true;
            if (isScramble(s1.substring(0, i), s2.substring(len1 - i)) &&
               isScramble(s1.substring(i), s2.substring(0, len1 - i)))
                return true;
        }
        return false;
	}
	
	public boolean isScramble4(String s1, String s2) {
        if (s1 == s2) return true;
        int n=s1.length();
		boolean[][][] dp=new boolean[n][n][n+1];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                dp[i][j][1] = s1.charAt(i) == s2.charAt(j);
            }
        }
        for (int len = 2; len <= n; ++len) {
            for (int i = 0; i <= n - len; ++i) {
                for (int j = 0; j <= n - len; ++j) {
                    for (int k = 1; k < len; ++k) {
                        if ((dp[i][j][k] && dp[i + k][j + k][len - k]) || (dp[i + k][j][len - k] && dp[i][j + len - k][k])) {
                            dp[i][j][len] = true;
                        }
                    }
                }
            }
        }
        return dp[0][0][n];

    } 
}
