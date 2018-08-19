package TempTest201_225;

import java.util.Hashtable;

public class IsomorphicStrings {
	public static void main(String args[]){
		System.out.println(isIsomorphic3("ab","aa"));
	}
	//用两个Hashtable来实现一一对应
	public static boolean isIsomorphic(String s, String t){
		if(s.length()!=t.length())return false;
		Hashtable<Character, Character> hash1=new Hashtable<>();
		Hashtable<Character, Character> hash2=new Hashtable<>();
		char c1,c2;
		for(int i=0;i<s.length();i++){
			c1=s.charAt(i);
			c2=t.charAt(i);
			if(!hash1.containsKey(c1) && !hash2.containsKey(c2)){
				hash1.put(c1, c2);
				hash2.put(c2, c1);
			} else if(hash1.containsKey(c1) && hash2.containsKey(c2))return c1==hash2.get(c2)&&c2==hash1.get(c1);
			else return false;
		}
		return true;
	}
	//用一个Hashtable交换st顺序来实现一一对应
	public boolean isIsomorphic2(String s, String t) {
        if(s.length()!=t.length())return false;
		return isSub(s,t)&&isSub(t,s);
    }
    public boolean isSub(String s, String t){
        Hashtable<Character, Character> hash=new Hashtable<>();
		char c1,c2;
		for(int i=0;i<s.length();i++){
			c1=s.charAt(i);
			c2=t.charAt(i);
			if(!hash.containsKey(c1)) hash.put(c1, c2);
			else if(c2!=hash.get(c1))return false;
		}
		return true;
    }
    //用整型数组来实现一一对应
    public static boolean isIsomorphic3(String s, String t){
    	int[] replace12=new int[257];		//腾出一个0来表示未存储
    	int[] replace21=new int[257];
    	int c1,c2;
    	for(int i=0;i<s.length();i++){
    		c1=s.charAt(i)+1;
    		c2=t.charAt(i)+1;
    		if(replace12[c1]==0 && replace21[c2]==0){
    			replace12[c1]=c2;
    			replace21[c2]=c1;
    		}else if(replace12[c1]==c2 && replace21[c2]==c1);
    		else return false;
    	}
    	return true;
    }

}
