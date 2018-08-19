package TempTest101_125;

public class DistinctSubsequences {
	public static void main(String args[]){
		System.out.println("began");
		System.out.println(numDistinct("xslledayhxhadmctrliaxqpokyezcfhzaskeykchkmhpyjipxtsuljkwkovmvelvwxzwieeuqnjozrfwmzsylcwvsthnxujvrkszqwtglewkycikdaiocglwzukwovsghkhyidevhbgffoqkpabthmqihcfxxzdejletqjoxmwftlxfcxgxgvpperwbqvhxgsbbkmphyomtbjzdjhcrcsggleiczpbfjcgtpycpmrjnckslrwduqlccqmgrdhxolfjafmsrfdghnatexyanldrdpxvvgujsztuffoymrfteholgonuaqndinadtumnuhkboyzaqguwqijwxxszngextfcozpetyownmyneehdwqmtpjloztswmzzdzqhuoxrblppqvyvsqhnhryvqsqogpnlqfulurexdtovqpqkfxxnqykgscxaskmksivoazlducanrqxynxlgvwonalpsyddqmaemcrrwvrjmjjnygyebwtqxehrclwsxzylbqexnxjcgspeynlbmetlkacnnbhmaizbadynajpibepbuacggxrqavfnwpcwxbzxfymhjcslghmajrirqzjqxpgtgisfjreqrqabssobbadmtmdknmakdigjqyqcruujlwmfoagrckdwyiglviyyrekjealvvigiesnvuumxgsveadrxlpwetioxibtdjblowblqvzpbrmhupyrdophjxvhgzclidzybajuxllacyhyphssvhcffxonysahvzhzbttyeeyiefhunbokiqrpqfcoxdxvefugapeevdoakxwzykmhbdytjbhigffkmbqmqxsoaiomgmmgwapzdosorcxxhejvgajyzdmzlcntqbapbpofdjtulstuzdrffafedufqwsknumcxbschdybosxkrabyfdejgyozwillcxpcaiehlelczioskqtptzaczobvyojdlyflilvwqgyrqmjaeepydrcchfyftjighntqzoo"
				,"rwmimatmhydhbujebqehjprrwfkoebcxxqfktayaaeheys"));
		System.out.println(numDistinct2("xslledayhxhadmctrliaxqpokyezcfhzaskeykchkmhpyjipxtsuljkwkovmvelvwxzwieeuqnjozrfwmzsylcwvsthnxujvrkszqwtglewkycikdaiocglwzukwovsghkhyidevhbgffoqkpabthmqihcfxxzdejletqjoxmwftlxfcxgxgvpperwbqvhxgsbbkmphyomtbjzdjhcrcsggleiczpbfjcgtpycpmrjnckslrwduqlccqmgrdhxolfjafmsrfdghnatexyanldrdpxvvgujsztuffoymrfteholgonuaqndinadtumnuhkboyzaqguwqijwxxszngextfcozpetyownmyneehdwqmtpjloztswmzzdzqhuoxrblppqvyvsqhnhryvqsqogpnlqfulurexdtovqpqkfxxnqykgscxaskmksivoazlducanrqxynxlgvwonalpsyddqmaemcrrwvrjmjjnygyebwtqxehrclwsxzylbqexnxjcgspeynlbmetlkacnnbhmaizbadynajpibepbuacggxrqavfnwpcwxbzxfymhjcslghmajrirqzjqxpgtgisfjreqrqabssobbadmtmdknmakdigjqyqcruujlwmfoagrckdwyiglviyyrekjealvvigiesnvuumxgsveadrxlpwetioxibtdjblowblqvzpbrmhupyrdophjxvhgzclidzybajuxllacyhyphssvhcffxonysahvzhzbttyeeyiefhunbokiqrpqfcoxdxvefugapeevdoakxwzykmhbdytjbhigffkmbqmqxsoaiomgmmgwapzdosorcxxhejvgajyzdmzlcntqbapbpofdjtulstuzdrffafedufqwsknumcxbschdybosxkrabyfdejgyozwillcxpcaiehlelczioskqtptzaczobvyojdlyflilvwqgyrqmjaeepydrcchfyftjighntqzoo"
				,"rwmimatmhydhbujebqehjprrwfkoebcxxqfktayaaeheys"));
		
		System.out.println(numDistinct("ccc","c"));
	}
	//常规解法
	static int count=0;
    public static int numDistinct1(String s, String t) {
        int m=t.length();
        int n=s.length();
        boolean[][] matrix=new boolean[m+1][n+1];
        matrix[0][0]=true;
        dp(matrix, s, t, 0, 0, m, n);
        return count;
    }
    // 从左上往右下走，matrix[0][0]表示两个子字符串为空。点(i,j)有两种操作，往右走或者往右下走。m,n表示矩阵matrix边界。
    public static void dp(boolean[][] matrix, String s, String t, int i, int j, int m, int n){
        if(i==m)count++;
        else if(i<m && j<n){       //越界判定
            //往右走
            if(n-j>m-i){       //s中剩余字符串长度要大于等于t中剩余字符串长度，不在最后一排，不在最后一列
                matrix[i][j+1]=true;
                dp(matrix, s, t, i, j+1, m, n);
            } 
            //往右下走
            if(t.charAt(i)==s.charAt(j)){       //两个字符串抵消一个相同字符
                matrix[i+1][j+1]=true;
                dp(matrix, s, t, i+1, j+1, m, n);
            }
        }
    }
    //动态规划
    public static int numDistinct2(String s, String t) {
        int m=t.length();
        int n=s.length();
        int[][] matrix=new int[m+1][n+1];		//表示到i,j的走法，初始为0，不能走表示-1.
        int[] sChars=new int[256];
        int[] tChars=new int[256];
        for(int i=0;i<s.length();i++){
        	sChars[s.charAt(i)]++;
        }
        for(int j=0;j<t.length();j++){
        	tChars[t.charAt(j)]++;
        }
        for(int k=0;k<256;k++){		//先判断s中字符数量是否能构成t
    		if(sChars[k]<tChars[k])return 0;
    	}
        //非递归dp
        
        
        
        
        
        
        
        
        
        return dp(s , t, matrix, m, n, sChars, tChars);
    }
    public static int dp(String s, String t, int[][] matrix, int i, int j, int[] sChars, int[] tChars){
    	if(matrix[i][j]!=0){		//表示已经计算过
    		return matrix[i][j]==-1?0:matrix[i][j];
    	}
    	//		未计算过
    	if(i==0 && j==0){		//起点
    		matrix[i][j]=1;
    		return 1;
    	}
    	if(i>j){				//边界情况
    		matrix[i][j]=-1;
    		return 0;
    	}
    	int leftUp=0;
    	int left=0;
    	//若相同则可能从左上来的或是从左方来的，若不同则只能是从左方来的
    	if(i>0 && t.charAt(i-1)==s.charAt(j-1)){//判断是否还有左上方
    		leftUp=dp(s , t, matrix, i-1, j-1, sChars, tChars);		//s和t都抵消一个字符，不改变schars和tChars大小关系
    	}
    	//s抵消一个字符，t无变化，判断sChars是否还满足tChars
    	char c=s.charAt(j-1);
    	if(sChars[c]>tChars[c]){
    		sChars[c]-=1;
    		left=dp(s , t, matrix, i, j-1, sChars, tChars);
    		sChars[c]+=1;			//计算完成，要还原
    	}
		matrix[i][j]=leftUp+left;
		if(matrix[i][j]==0){
			matrix[i][j]=-1;
			return 0;
		}else return matrix[i][j];
    }


    //非递归动态规划
    public static int numDistinct(String s, String t) {
        int m=t.length();
        int n=s.length();
        int[][] matrix=new int[m+1][n+1];		//表示到i,j的走法，初始为0，不能走表示-1.
        int[] sChars=new int[256];
        int[] tChars=new int[256];
        for(int i=0;i<s.length();i++){
        	sChars[s.charAt(i)]++;
        }
        for(int j=0;j<t.length();j++){
        	tChars[t.charAt(j)]++;
        }
        for(int k=0;k<256;k++){		//先判断s中字符数量是否能构成t
    		if(sChars[k]<tChars[k])return 0;
    	}
        //非递归动态规划,遍历顺序如下
//        |1234  |
//        | 5678 |       
//        |  9abc|
        for(int i=0;i<=m;i++){
        	for(int j=i;n-j>=m-i;j++){
        		if(i==0 && j==0){		//特殊情况
        			matrix[i][j]=1;
        		}else{
        			int leftUp=0;
            		int left=0;
            		if(i!=0 && t.charAt(i-1)==s.charAt(j-1)){		//不在最上面一排且元素相同
            			leftUp=matrix[i-1][j-1];
            		}
//            		char c=s.charAt(j-1);
//            		if(i!=j && sChars[c]>tChars[c]){		//不在最左边斜列且s剩余元素依旧能构成t
            		if(i!=j){
            			left=matrix[i][j-1];
            		}
            		matrix[i][j]=leftUp+left;
        		}
        	}
        }
        return matrix[m][n];
    }

}
