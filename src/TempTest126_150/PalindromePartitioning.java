package TempTest126_150;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
	public static void main(String args[]){
		System.out.println(partition("aab"));
	}
	public static List<List<String>> partition(String s) {
        int len=s.length();
        List<List<String>>[] lists=new ArrayList[len];//�洢�Ե�i���ַ���β��List��ÿ��λ�ü������Ͳ�Ϊ�գ���Ϊ�ض����ڻ��ģ������ַ��ֿ���
        
        
        return dp(s, len-1,len-1,lists);
    }
	// ��ed��β����st��ͷ,������ed��β��list
    public static List<List<String>> dp(String s, int st, int ed, List<List<String>>[] lists){
    	if(lists[ed]!=null){
    		return lists[ed];
    	} 
        while(st>=0){
        	if(isPalind(s,st,ed)){
        		if(st==0){		//��һ������
        			List<String> newL=new ArrayList<>();
        			List<List<String>> newLists=new ArrayList<>();
        			newL.add(s.substring(st,ed+1));
        			newLists.add(newL);
        			return newLists;
        		}else for(List<String> L:dp(s,st-1,st-1,lists)){	//���������֮ǰ������list�������»���add
        			L.add(s.substring(st,ed+1));
        		}
        	}
        	st--;
        }
        return new ArrayList<>();
    }
    
    
    public static boolean isPalind(String s, int st, int ed){
        while(st<ed){
            if(s.charAt(st)!=s.charAt(ed))return false;
        }
        return true;
    }

}
