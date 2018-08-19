package TempTest1_25;

import java.util.Arrays;

public class LongestPalindromiSubstring {
	public static void main(String args[]){
		String s = "ddddabac";
		System.out.println(solution2(s));
//		System.out.println(ifPalin(s));
	}
	
//	Approach#1 Longest Common Substring	
	public static String solution1(String s){
		if(s==null)
			return "";
		StringBuffer sb = new StringBuffer(s);
		String re = new String(sb.reverse().toString());
		int l = re.length();
		int[][] LCSubstr = new int [l+1][l+1];
		int longindex=0,longlength=1;
		int i,j;
		for(i=0;i<l;i++){
			for(j=0;j<l;j++){
				char ch1=s.charAt(i),ch2=re.charAt(j);
				if(ch1==ch2){		//������ͬ�ַ����ж�i��j֮ǰ�Ƿ�����ͬԪ�أ�
					LCSubstr[i+1][j+1] = LCSubstr[i][j]+1;
					if(longlength<LCSubstr[i+1][j+1]){
						if(ifPalin(s.substring(i+1-LCSubstr[i+1][j+1],i+1))){
							longindex = i;
							longlength = LCSubstr[i+1][j+1];
						}
					}
				}
			}
		}
		return s.substring(longindex+1-longlength,longindex+1);
	}
	public static boolean ifPalin(String s){
		for(int i=0;i<s.length()/2;i++){
			if(s.charAt(i)!=s.charAt(s.length()-i-1))
				return false;
		}
		return true;
	}
	
//	Approach #3(Dynamic Programming)
	public static String solution2(String s){
		if(s==null)
			return "";
		int longlength=1,longindex=0;
		int drift;
		for(int i=0;i<s.length();i++){			//������
			drift=1;
			while((i-drift>=0&&i+drift<s.length())&&s.charAt(i-drift)==s.charAt(i+drift)){
				if((2*drift+1)>longlength){
					longindex=i-drift;
					longlength=2*drift+1;
				}
				drift++;
			}
		}
		for(int i=0;i<s.length()-1;i++){		//ż����
			drift=0;
			while((i-drift>=0&&i+1+drift<s.length())&&s.charAt(i-drift)==s.charAt(i+1+drift)){
				if((2*drift+2)>longlength){
					longindex=i-drift;
					longlength=2*drift+2;
				}
				drift++;
			}			
		}
		return s.substring(longindex, longindex+longlength);
	}
	
	public String longestPalindrome4(String s) {
        int len=s.length();
		if(len==0 || len==1)return s;
        String str="";
        int maxlen=-1;
        for(int i=0;i<=2*len-2;i++){      //遍历中间位置
            int index1=i/2;
            int index2=(i+1)/2;
            while(index1>=0 && index2<len && s.charAt(index1)==s.charAt(index2)){
                index1--;
                index2++;
            }
            index1++;
            index2--;
            if(index2-index1>maxlen){
                maxlen=index2-index1;
                str=s.substring(index1,index2+1);
            }
        }
        return str;
    }


}
