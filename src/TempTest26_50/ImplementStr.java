package TempTest26_50;

public class ImplementStr {
	public static void main(String args[]){
		
	}
	public static int strStr(String haystack, String needle){
		char[] ch1 = haystack.toCharArray();
		char[] ch2 = needle.toCharArray();
		int l1 = ch1.length;
		int l2 = ch2.length;
		int i,j;
		boolean flag;
		for(i=0;i<l1-l2;i++){
			flag = true;
			for(j=0;j<l2;j++){
				if(ch2[j]!=ch1[i+j]){
					flag = false;
					break;
				}
			}
			if(flag)
				return i;
		}
		return -1;
	}

}
