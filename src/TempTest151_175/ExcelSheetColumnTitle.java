package TempTest151_175;

public class ExcelSheetColumnTitle {
	public static void main(String args[]){
		System.out.print(convertToTitle(52));
	}
	
	public static String convertToTitle(int n){
		String str="";
		int rem;
		while(n!=0){
			rem=n%26;
			n/=26;
			if(rem==0){
				str = "Z" + str;
				n--;
			}else{
				str = String.valueOf((char)(rem-1+'A'))+str;
			}
		}
		return str;
	}
}
