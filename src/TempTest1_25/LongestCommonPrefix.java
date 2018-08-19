package TempTest1_25;

public class LongestCommonPrefix {
	public static void main(String args[]){
		String str="abcdefg";
		System.out.println(str.startsWith("bce"));
	}
//	Approach#1 Horizontal scanning
	public static String solution(String[] strs){
        if(strs.length==0)
            return "";
        String s1=strs[0];
        int min=s1.length();
        int index;
        for(int i=1;i<strs.length;i++){
        	index=0;
            while(index<Math.min(s1.length(),strs[i].length()) && s1.charAt(index)==strs[i].charAt(index))			//假设都合法，不用判定越界
            	index++;
            min=Math.min(index, min);
        }
        return s1.substring(0,min);
	}
	public String longestCommonPrefix(String[] strs) {
	    if (strs == null || strs.length == 0)return "";
        String prefix=strs[0];
	    for (String str : strs){
            while(!str.startsWith(prefix)){
                prefix=prefix.substring(0,prefix.length()-1);
            }
        }
        return prefix;
    }
//	Approach#2 Vertical Scanning
	public static String solution2(String[] strs){
		if(strs.length==0)return "";
		for(int i=0;i<strs[0].length();i++){
			for(int j=1;j<strs.length;j++){
				if(strs[0].charAt(i)!=strs[j].charAt(i))
					return strs[0].substring(0, j);
			}
		}
		return strs[0];
	}
//	Approach#3 Divide and Conquer
	public static String soluiton3(String[] strs){
		if(strs.length==0)return "";
		return divide(strs,0,strs.length-1);
	}
	public static String divide(String[] strs,int pre,int rear){
		String leftpart,rightpart;
		if(pre>=rear)
			return strs[rear];
		else{
			int mid=(rear+pre)/2;
			leftpart = divide(strs, pre, mid);
			rightpart = divide(strs,mid+1,rear);
		}
		return conquer(leftpart,rightpart);
	}
	public static String conquer(String s1,String s2){
		for(int i=0;i<Math.min(s1.length(), s2.length());i++)
			if(s1.charAt(i)!=s2.charAt(i))
				return s1.substring(0, i);
		return s1.substring(0,Math.min(s1.length(), s2.length()));
	}
	
//	Approach#4 Binary search
	public String solution4(String[] strs) {
	    if (strs == null || strs.length == 0)
	        return "";
	    int minLen = Integer.MAX_VALUE;
	    for (String str : strs)
	        minLen = Math.min(minLen, str.length());
	    int low = 1;
	    int high = minLen;
	    while (low <= high) {
	        int middle = (low + high) / 2;
	        if (isCommonPrefix(strs, middle))
	            low = middle + 1;
	        else
	            high = middle - 1;
	    }
	    return strs[0].substring(0, (low + high) / 2);
	}

	private boolean isCommonPrefix(String[] strs, int len){
	    String str1 = strs[0].substring(0,len);
	    for (int i = 1; i < strs.length; i++)
	        if (!strs[i].startsWith(str1))
	            return false;
	    return true;
	}


}
