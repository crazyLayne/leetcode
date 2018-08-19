package TempTest51_75;

public class LengthofLastWord {
	public static void main(String args[]){
		
	}
	public int solution(String s){
		s=s.trim();	
//		int n=s.length()-1;
//		while(n>=0 && s.charAt(n)==' '){
//			s=s.substring(0, n);
//			n--;
//		}
		return s.length()-s.lastIndexOf(" ")-1;
	}

}
