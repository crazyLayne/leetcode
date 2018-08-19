package TempTest1_25;

import java.util.HashMap;

public class LongestWordInDictionary {
	public static void main(String args[]){
		String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
		System.out.println(solution(words));
	}
	public static String solution(String[] words){
		HashMap map = new HashMap();
		for(int i=0;i<words.length;i++){		//遍历一边字符串数组，初始化map
			map.put(words[i], 1);
		}
		String str="";
		int max=0;
		boolean flag=true;
		for(int i=0;i<words.length;i++){
			if(words[i].length()>max || (words[i].length()==max && words[i].compareTo(str)<0)){
				for(int j=0;j<words[i].length();j++){
					String temp=words[i].substring(0, j+1);
					if(!map.containsKey(temp)){
						flag=false;
						break;
					}
				}
				if(flag){
					str=words[i];
					max=str.length();
				}
			}
		}
		return str;
	}

}
