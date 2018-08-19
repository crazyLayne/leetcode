package TempTest151_175;

public class CompareVersionNumbers {
	public static void main(String args[]){
		System.out.println(compareVersion("1.0","1.1"));
	}
	
	public static int compareVersion(String version1, String version2){
		if(version1==version2)return 0;
        //往后找到第一个小数点，截取小数点前的数字进行比较
        int p1,q1;
        int p2,q2;
        p1=p2=q1=q2=0;
        String s1,s2;
        while(q1<=version1.length() && q2<=version2.length()){		//越界判断
        	s1=version1.substring(p1, q1);
        	s2=version2.substring(p2, q2);
        	if(s1==s2){
        		while(q1<=version1.length() && version1.charAt(q1)!='.')q1++;
        		while(q2<=version2.length() && version2.charAt(q2)!='.')q2++;
        	}else return (Integer.valueOf(s1)>Integer.valueOf(s2))?1:-1;
        }
        if(q1>=version1.length() && q2>=version2.length())return 0;
        else if(q1>=version1.length())return -1; 
//    	if(q2>=version2.length())
    	return 1;
    	
	}

}
