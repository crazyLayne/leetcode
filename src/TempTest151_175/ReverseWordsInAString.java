package TempTest151_175;

public class ReverseWordsInAString {
	public static void main(String args[]){
		String s="the sky is blue";
		System.out.println(reverseWords(s));
	}
	public static String reverseWords(String s){

		StringBuffer sb=new StringBuffer();
		int st=0;
		for(int i=0;i<=s.length();i++){
			if(i==s.length() || s.charAt(i)==' '){
				sb.insert(0, s.substring(st, i)+" ");
				st=i+1;
			}
		}
		sb.length();
		return sb.length()>0?sb.deleteCharAt(s.length()).toString():"";
	}
	

}
