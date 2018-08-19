package TempTest76_100;

import java.util.ArrayList;
import java.util.List;

public class ResoreIPAddresses {
	public static void main(String args[]){
		System.out.println(Integer.valueOf("1234"));
	}
	public static List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        recur(s,list,"",0);
        return list;
    }
    public static void recur(String s, List<String> list, String ss, int st){
        if(s.length()==0)list.add(ss);
        String ts1,ts2;
        for(int i=1;i<=3;i++){
        	if(st+i<=s.length()){
        		ts1=s.substring(st+i);
                ts2=s.substring(st,st+i);
                recur(ts1, list, ss+ts2+".", st+i-1);
        	}
        }
            }
    
//    public static boolean isValid(String s, int st, int ed){
//    	
//    }

}
