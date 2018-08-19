package TempTest1_25;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
	public static void main(String args[]){
		String str="IIV";
		System.out.print(solution(str));
	}
	public static int solution(String s){
		if(s=="")
			return 0;
		Map<Character, Integer> map = new HashMap<>();
		map.put('M', 1000);
		map.put('D', 500);
		map.put('C', 100);
		map.put('L', 50);
		map.put('X', 10);
		map.put('V', 5);
		map.put('I', 1);
		int num = 0;
		int index=0;
		while(index<s.length()-1){
			num=map.get(s.charAt(index)) >= map.get(s.charAt(index+1))? num+map.get(s.charAt(index++)): num-map.get(s.charAt(index++))+map.get(s.charAt(index++));
		}
		if(index==s.length()-1)
			num+=map.get(s.charAt(index));
		return num;
	}

}
