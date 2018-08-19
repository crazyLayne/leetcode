package TempTest1_25;

public class ZigZagConversion {
	public static void main(String args[]){
		String s = "A";
		int numRows=1;
		System.out.println(solution1(s,numRows));
	}
	public static String solution1(String s,int numRows){
		String str="";
		String str1;
		if(numRows==1)
			return s;
		for(int i=1;i<=numRows;i++){
			str1 = substring(s,numRows,i);
			str = str + str1;
		}
		return str;
	}
	
	public static String substring(String s, int numRows, int row){			//返回改行的substring
		String str="";
		int index=row-1;
		int index2;
		if(row==1 || row==numRows){					//第一行
			while(index < s.length()){
				str = str +s.charAt(index);
				index = index+2*numRows-2;
			}
		}else {
			while(index < s.length()){
				str = str + s.charAt(index);
				index2=index+2*(numRows-row);
				if(index2>=s.length()){		//越界
					break;
				}else{
					str = str + s.charAt(index2);
					index = index+2*(numRows-1);
				}
			}
		}
		return str;
	} 

}
