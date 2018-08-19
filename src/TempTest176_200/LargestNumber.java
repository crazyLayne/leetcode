package TempTest176_200;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
	public static void main(String args[]){
		
	}
	public static String largestNumber(int[] nums){
		int len=nums.length;
		String[] strs=new String[len]; 
		for(int i=0;i<len;i++){
			strs[i]=String.valueOf(nums[i]);
		}
		Arrays.sort(strs, new cmp());
		StringBuffer sb=new StringBuffer();
		for(String s:strs){
			sb.append(s);
		}
        String str=sb.toString();
		return str.charAt(0)=='0'?"0":str;
	}
}
class cmp implements Comparator<String>{
	public  int compare(String s1, String s2){
		return (s2+s1).compareTo(s1+s2);
	}
}

