package TempTest26_50;

public class MultiplyStrings {
	public static void main(String args[]){
		String s1,s2,s;
		s1="9";
		s2="9";
		s=solution(s1,s2);
		System.out.println(s);
	}       
	public static  String solution(String num1,String num2){
		if(num1.equals("0") || num2.equals("0"))
			return "0";
		String str = "";
		int[] product = new int[num1.length()+num2.length()];
		int full = 0;
		int i,j;
		int temp;
		for(i=num1.length()-1;i>=0;i--){
			for(j=num2.length()-1;j>=0;j--){
				temp = ((num1.charAt(i)-'0')*(num2.charAt(j)-'0')+product[num1.length()+num2.length()-2-i-j]+full);
				full = temp/10;
				product[num1.length()+num2.length()-2-i-j] = temp%10;
			}
			while(full>0){
				product[num1.length()+num2.length()-2-i-j] = full%10;
				j--;
				full/=10;
			}
		}
		boolean flag = false;
		for(int k=product.length-1;k>=0;k--){
			if(flag || product[k]!=0){
				flag=true;
				str+=Integer.toString(product[k]);
			}
		}
		return str;
	}
}
