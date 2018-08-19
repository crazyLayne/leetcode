package TempTest26_50;

public class CountAndSay {
	public static void main(String args[]){
		String ss = solution(4);
		System.out.println(ss);
	}
	public static String solution(int n){
		String s = "1";
		char[] ch=s.toCharArray();
		String ss = "";
		char ch1,ch2;
		for(int i=1;i<n;i++){
			ss = "";
			ch1=ch[0];
			int count = 1;
			for(int j=1;j<s.length();j++){
				ch2 = ch[j];
				if(ch1==ch2){
					count++;
				}else{
					ss = ss+(""+count)+ ch1;
					ch1=ch2;
					count=1;
				}
			}
			ss+=""+count+ch1;
			s = ss;
		}
		return s;
	}

}
