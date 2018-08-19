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
	//����ⷨ
	static int count=0;
    public static int numDistinct1(String s, String t) {
        int m=t.length();
        int n=s.length();
        boolean[][] matrix=new boolean[m+1][n+1];
        matrix[0][0]=true;
        dp(matrix, s, t, 0, 0, m, n);
        return count;
    }
    // �������������ߣ�matrix[0][0]��ʾ�������ַ���Ϊ�ա���(i,j)�����ֲ����������߻����������ߡ�m,n��ʾ����matrix�߽硣
    public static void dp(boolean[][] matrix, String s, String t, int i, int j, int m, int n){
        if(i==m)count++;
        else if(i<m && j<n){       //Խ���ж�
            //������
            if(n-j>m-i){       //s��ʣ���ַ�������Ҫ���ڵ���t��ʣ���ַ������ȣ��������һ�ţ��������һ��
                matrix[i][j+1]=true;
                dp(matrix, s, t, i, j+1, m, n);
            } 
            //��������
            if(t.charAt(i)==s.charAt(j)){       //�����ַ�������һ����ͬ�ַ�
                matrix[i+1][j+1]=true;
                dp(matrix, s, t, i+1, j+1, m, n);
            }
        }
    }
    //��̬�滮
    public static int numDistinct2(String s, String t) {
        int m=t.length();
        int n=s.length();
        int[][] matrix=new int[m+1][n+1];		//��ʾ��i,j���߷�����ʼΪ0�������߱�ʾ-1.
        int[] sChars=new int[256];
        int[] tChars=new int[256];
        for(int i=0;i<s.length();i++){
        	sChars[s.charAt(i)]++;
        }
        for(int j=0;j<t.length();j++){
        	tChars[t.charAt(j)]++;
        }
        for(int k=0;k<256;k++){		//���ж�s���ַ������Ƿ��ܹ���t
    		if(sChars[k]<tChars[k])return 0;
    	}
        //�ǵݹ�dp
        
        
        
        
        
        
        
        
        
        return dp(s , t, matrix, m, n, sChars, tChars);
    }
    public static int dp(String s, String t, int[][] matrix, int i, int j, int[] sChars, int[] tChars){
    	if(matrix[i][j]!=0){		//��ʾ�Ѿ������
    		return matrix[i][j]==-1?0:matrix[i][j];
    	}
    	//		δ�����
    	if(i==0 && j==0){		//���
    		matrix[i][j]=1;
    		return 1;
    	}
    	if(i>j){				//�߽����
    		matrix[i][j]=-1;
    		return 0;
    	}
    	int leftUp=0;
    	int left=0;
    	//����ͬ����ܴ��������Ļ��Ǵ������ģ�����ͬ��ֻ���Ǵ�������
    	if(i>0 && t.charAt(i-1)==s.charAt(j-1)){//�ж��Ƿ������Ϸ�
    		leftUp=dp(s , t, matrix, i-1, j-1, sChars, tChars);		//s��t������һ���ַ������ı�schars��tChars��С��ϵ
    	}
    	//s����һ���ַ���t�ޱ仯���ж�sChars�Ƿ�����tChars
    	char c=s.charAt(j-1);
    	if(sChars[c]>tChars[c]){
    		sChars[c]-=1;
    		left=dp(s , t, matrix, i, j-1, sChars, tChars);
    		sChars[c]+=1;			//������ɣ�Ҫ��ԭ
    	}
		matrix[i][j]=leftUp+left;
		if(matrix[i][j]==0){
			matrix[i][j]=-1;
			return 0;
		}else return matrix[i][j];
    }


    //�ǵݹ鶯̬�滮
    public static int numDistinct(String s, String t) {
        int m=t.length();
        int n=s.length();
        int[][] matrix=new int[m+1][n+1];		//��ʾ��i,j���߷�����ʼΪ0�������߱�ʾ-1.
        int[] sChars=new int[256];
        int[] tChars=new int[256];
        for(int i=0;i<s.length();i++){
        	sChars[s.charAt(i)]++;
        }
        for(int j=0;j<t.length();j++){
        	tChars[t.charAt(j)]++;
        }
        for(int k=0;k<256;k++){		//���ж�s���ַ������Ƿ��ܹ���t
    		if(sChars[k]<tChars[k])return 0;
    	}
        //�ǵݹ鶯̬�滮,����˳������
//        |1234  |
//        | 5678 |       
//        |  9abc|
        for(int i=0;i<=m;i++){
        	for(int j=i;n-j>=m-i;j++){
        		if(i==0 && j==0){		//�������
        			matrix[i][j]=1;
        		}else{
        			int leftUp=0;
            		int left=0;
            		if(i!=0 && t.charAt(i-1)==s.charAt(j-1)){		//����������һ����Ԫ����ͬ
            			leftUp=matrix[i-1][j-1];
            		}
//            		char c=s.charAt(j-1);
//            		if(i!=j && sChars[c]>tChars[c]){		//���������б����sʣ��Ԫ�������ܹ���t
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
