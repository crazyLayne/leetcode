package TempTest1_25;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	public static void main(String args[]){
		List<String> strs = new ArrayList<>();
		strs = solution(3);
	}
	public static List<String> solution(int n){
		List<String> strs = new ArrayList<>();
		subsol(strs,"",n,n);
		return strs;
	}
	public static void subsol(List<String> strs, String str, int n1,int n2){
		if(n2==0){		//全部取完
			strs.add(str);
		}
		if(n1>0)
			subsol(strs,str+"(",n1-1,n2);
		if(n1<n2)		//只能取（
			subsol(strs,str+")",n1,n2-1);
	} 

}
