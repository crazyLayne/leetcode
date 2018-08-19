package TempTest126_150;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class WordBreak {
	public static void main(String args[]){
		String s="aaaaaaaaaaaaabaaaaaaaaaaaa";
		List<String> list=new ArrayList<String>();
		list.add("aaaa");
		list.add("aaa");
		list.add("aa");
		list.add("a");
		System.out.println(wordBreak(s,list));
	}
	public static boolean wordBreak(String s, List<String> wordDict) {
		Hashtable<String, Integer> t=new Hashtable<>();
        for(String str:wordDict){
        	t.put(str, 1);
        }
        int[] flags=new int[s.length()+1];
        return dp(s,s.length(),s.length()-1,t,flags);
    }
	//	i表示s结尾的位置,j表示开始截取单词的位置
	public static boolean dp(String s, int i, int j, Hashtable<String, Integer> t, int[] cond){
		if(cond[i]==1)return true;
		if(cond[i]==-1)return false;
		while(j>=0){
			String str=s.substring(j,i);
			if(t.containsKey(str)){
				if(j==0)return true;
				boolean temp=dp(s,j,j-1,t,cond) || dp(s,i,j-1,t,cond);
				cond[i]=temp?1:-1;
				return temp;
			}
			j--;
		}
		cond[i]=-1;
		return false;
	}

}
