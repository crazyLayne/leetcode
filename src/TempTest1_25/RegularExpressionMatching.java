package TempTest1_25;

//	'.' Matches any single character.
//	'*' Matches zero or more of the preceding element.
//	
//	The matching should cover the entire input string (not partial).
//	
//	The function prototype should be:
//	bool isMatch(const char *s, const char *p)
//	
//	Some examples:
//	isMatch("aa","a") �� false
//	isMatch("aa","aa") �� true
//	isMatch("aaa","aa") �� false
//	isMatch("aa", "a*") �� true
//	isMatch("aa", ".*") �� true
//	isMatch("ab", ".*") �� true
//	isMatch("aab", "c*a*b") �� true

//	�ж�һ���ַ�ʱ��Ҫ����������һ���ַ��Ƿ���ڣ��������Ƿ�Ϊ*��
public class RegularExpressionMatching {
	public static void main(String args[]){
		System.out.println(isMatch("a",".*..a*"));
	}
	
	// Approach #1:Recursion
	public static boolean isMatch(String s, String p){
		if(p.isEmpty())return s.isEmpty();
		if(p.length()==1 && s.length()==1 && (p.charAt(0)=='.' || p.charAt(0)==s.charAt(0))){
			return true;
		}
		if(p.length()>=2){
			if(p.charAt(1)!='*'){
				if(s.length()>0 && (p.charAt(0)=='.' || p.charAt(0)==s.charAt(0))){
					return isMatch(s.substring(1, s.length()),p.substring(1, p.length()));
				}else{
					return false;
				}
			}else if(p.charAt(0)!='.'){			//"a*"�����ַ���Ҫһ��
				int count=0;
				for(int i=0;i<s.length();i++){
					if(s.charAt(i)!=p.charAt(0)){
						break;
					}
					count++;
				}
				for(int i=0;i<=count;i++){		//���ַ�����0����s�и��ַ������
					if(isMatch(s.substring(i,s.length()),p.substring(2,p.length()))){
						return true;
					}
				}
				return false;
			}else{			//�ַ�".*"���Ե��������ַ�
				for(int i=0;i<=s.length();i++){
					if(isMatch(s.substring(i,s.length()),p.substring(2,p.length()))){
						return true;
					}
				}
				return false;
			}
		}
		return false;
	}
	
	public boolean isMatch2(String text, String pattern) {
        if (pattern.isEmpty()) return text.isEmpty();
        boolean first_match = (!text.isEmpty() && 
                               (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));
        
        if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
            return (isMatch(text, pattern.substring(2)) || 
                    (first_match && isMatch(text.substring(1), pattern)));
        } else {
            return first_match && isMatch(text.substring(1), pattern.substring(1));
        }
    }
	
	// Approach #2:DP
//	public static boolean isMatch3(String text, String pattern){
//		int[][] flag=new int[text.length() + 1][pattern.length() + 1];
//        return dp(0, 0, text, pattern,flag);
//	}
//	public static boolean dp(int i,int j, String text, String pattern, int[][] flag){
//		if(flag[i][j]==1)return true;
//		if(flag[i][j]==-1)return false;
//		
//	}
}
