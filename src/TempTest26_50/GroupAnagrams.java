package TempTest26_50;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
	public static void main(String args[]){
		String str="a";
		int a=10;
		str=str+a;
		System.out.println(str);
	}
	public static List<List<String>> solution(String[] strs){
		List<List<String>> ans = new ArrayList<>();
		List<String> an = new ArrayList<>();
		boolean flag;
		for(int i=0;i<strs.length;i++){
			flag=false;
			for(int j=0;j<ans.size();j++){			//遍历现有链表
				an=ans.get(j);
				if(judge(an.get(0),strs[i])){		//找到相同
					an.add(strs[i]);
					flag=true;
					break;
				}
			}
			if(!flag){								//没有相同
				List<String> ann = new ArrayList<>();
				ann.add(strs[i]);
				ans.add(ann);
			}
		}
		return ans;
	}
	public static boolean judge(String s1,String s2){
		if(s1.length()!=s2.length())
			return false;
		int[] chs1 = new int[26];
		int[] chs2 = new int[26];
		for(int i=0;i<s1.length();i++){
			chs1[s1.charAt(i)-'a']++;
			chs2[s2.charAt(i)-'a']++;
		}
		for(int i=0;i<26;i++)
			if(chs1[i]!=chs2[i])return false;
		return true;
	}
	public static List<List<String>> solution2(String[] strs){
		List<List<String>> ans = new ArrayList<>();
		List<String> an = new ArrayList<>();
		Map<String,List> map = new HashMap<>();
		int[] chs = new int[26];
		char ch;
		String str;
		for(int i=0;i<strs.length;i++){
			str="";
			Arrays.fill(chs, 0);
			for(int j=0;j<strs[i].length();j++){
				ch=strs[i].charAt(j);
				chs[ch-'a']++;
			}
			for(int j=0;j<26;j++){
				str=str+"#"+chs[j];
			}
			if(map.containsKey(str)){
				an = map.get(str);
				an.add(strs[i]);
			}else{
				List<String> ann = new ArrayList<String>();
				ann.add(strs[i]);
				map.put(str, ann);
			}
		}
		return ans;
	}
	 public List<List<String>> solution3(String[] strs) {
	        if (strs.length == 0) return new ArrayList();
	        Map<String, List> ans = new HashMap<String, List>();
	        int[] count = new int[26];
	        for (String s : strs) {
	            Arrays.fill(count, 0);
	            for (char c : s.toCharArray()) count[c - 'a']++;
	            
	            StringBuilder sb = new StringBuilder("");
	            for (int i = 0; i < 26; i++) {
	                sb.append('#');
	                sb.append(count[i]);
	            }
	            String key = sb.toString();
	            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
	            ans.get(key).add(s);
	        }
	        return new ArrayList(ans.values());
	    }
}
