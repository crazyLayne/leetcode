package TempTest176_200;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

public class RepeatedDNASequences {
	public static void main(String args[]){
//		System.out.println(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
		System.out.println();
	}
	
	public static List<String> findRepeatedDnaSequences(String s){
		String substr;
		Hashtable<String, Integer> hash=new Hashtable<>();
		List<String> list=new ArrayList<>();
		for(int i=0;i+10<=s.length();i++){
			substr = s.substring(i, i+10);
			if(hash.containsKey(substr)){
				if(hash.get(substr)!=-1){
					list.add(substr);
					hash.put(substr, -1);
				}
			}else hash.put(substr, 1);
		}
		return list;
	}

	public static List<String> findRepeatedDnaSequences2(String s){
		Set<String> visited = new HashSet<String>();
        Set<String> ans = new HashSet<String>();
        for (int i = 0; i + 9 < s.length(); i++) {
            String str = s.substring(i, i + 10);
            if (!visited.add(str))
                ans.add(str);
        }
        return new ArrayList(ans);
	}
	
}
