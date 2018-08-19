package TempTest101_125;

public class ValidPalindrome {
	public static void main(String args[]){
		System.out.print(isPalindrome("0p"));
//		System.out.println(isChar('a'));
	}
	public static boolean isPalindrome(String s) {
        int len=s.length();
        if(len==0)return true;
        int i=0;
        int j=len-1;
        while(i<j){
            while(i<j && isChar(s.charAt(i))==' ')i++;
            while(j>=0 && isChar(s.charAt(j))==' ')j--;
            if(i>=j)return true;
            if(isChar(s.charAt(i))==isChar(s.charAt(j))){
            	i++;
            	j--;
            }
            else return false;
                
        }
        return true;
    }
    public static char isChar(char c){
        if((c-'a'>=0 && c-'a'<=26) || (c-'0'>=0 && c-'0'<=9))return c;
        else if(c-'A'>=0 && c-'A'<=26)return (char)(c+32);
        else return ' ';
    }

}
