package TempTest126_150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordBreakII {
	public static void main(String args[]){
		String s="aaaa";
		List<String> list=new ArrayList<>();
		list.add("aaa");
		list.add("aa");
		list.add("a");
		List<String> res=new ArrayList<>(wordBreak(s,list));
		System.out.println(res);
	}
	public static List<String> wordBreak(String s, List<String> wordDict) {
        HashMap<String, Integer> t=new HashMap<>();
        for(String str:wordDict){
        	t.put(str, 1);
        }
        List<String>[] lists=new ArrayList[s.length()+1];			//存储中间情况
        int[] flag=new int[s.length()+1];
        return dp(s,s.length(),s.length()-1,t,flag,lists);
    }
    
    public static List<String> dp(String s, int i, int j, HashMap<String, Integer> t, int[] flag, List<String>[] lists){
		if(flag[i]==1)return lists[i];
		if(flag[i]==-1)return new ArrayList<String>();
		while(j>=0){
			String str=s.substring(j,i);
			if(t.containsKey(str)){
				if(j==0){
                    List<String> list=new ArrayList<String>();
                    flag[i]=1;
                    list.add(str);
                    lists[i]=list;
                    return list;
                }
				String stemp;
                List<String> L1=new ArrayList<String>(dp(s,j,j-1,t,flag,lists));
                for(int k=0;k<L1.size();k++){
                    stemp=L1.get(k);
                    stemp=stemp+" "+str;
                    L1.set(k,stemp);
                }
                List<String> L2=new ArrayList<String>(dp(s,i,j-1,t,flag,lists));
                for(int k=0;k<L2.size();k++){
                    L1.add(L2.get(k));
                }
                flag[i]=(L1==null)?-1:1;
                lists[i]=L1;
                return L1;
			}
			j--;
		}
        flag[i]=-1;
		return new ArrayList<String>();
	}

}
