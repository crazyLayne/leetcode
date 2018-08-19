package TempTest1_25;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
	public static void main(String args[]){
		String test="";
		int longSubstring = mysolution(test);
		System.out.println(longSubstring);
	}
	
	public static int mysolution(String s){
		int Llen,len,long1,long2,now1,now2;						//long1和long2临时存储最长的下标，now1和now2记录当前遍历的下标
		Llen=1;long1=0;long2=0;now1=0;now2=0;		//没有重复直接返回原始字符串
		Map<Character, Integer> map= new HashMap<>();
		for(int i=0;i<s.length();i++){
			if(map.containsKey(s.charAt(i))&&map.get(s.charAt(i))>=now1){
				now2=i-1;
				if((now2-now1+1)>Llen){
					long1=now1;
					long2=now2;
					Llen=long2-long1+1;
				}
				now1=map.get(s.charAt(i))+1;
			}
			map.put(s.charAt(i), i);
		}
		if((s.length()-now1)>Llen){
			long1=now1;
			long2=s.length()-1;
		}
		if(s.equals(""))
			return 0;
		else
			return s.substring(long1, long2+1).length();
	}



	
}
