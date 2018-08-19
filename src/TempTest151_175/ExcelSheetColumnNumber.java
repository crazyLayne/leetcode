package TempTest151_175;

public class ExcelSheetColumnNumber {
	public static void main(String args[]){
		System.out.println(titleToNumber("AA"));
	}
	
	public static int titleToNumber(String s){
		char[] chs=s.toCharArray();
		int num=0;
		for(char c:chs){
			num*=26;
			num+=c-'A'+1;
		}
		return num;
	}

}
