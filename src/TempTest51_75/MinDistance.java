package TempTest51_75;

public class MinDistance {
	public static void main(String args[]){
		String s1="sea";
		String s2="ate";
		System.out.println(minDistance(s1,s2));
	}
	public static int minDistance(String word1, String word2) {
        if(word1.length()>word2.length()){		//让word1比word2短
        	String word3=word1;
        	word1=word2;
        	word2=word3;
        }
        int len1=word1.length();
        int len2=word2.length();
        //比较两个word相交部分的，先考虑word1完全在word2中
        int smn=0;		//相同字符数目
        int xj=len1;		//相交部分长度
        for(int i=0;i<=len2-len1;i++){
        	smn=Math.max(samechar(word1,word2.substring(i, i+len1)), smn);
        }
        //求出一个完全相交情况下的最大相同字符数目后，部分相交的相交长度必须高于此值
        //word1从word2左侧依次挪出,循环条件可以动态变化
		for(int i=1;len1-i>smn;i++){
			if(samechar(word1.substring(i, len1),word2.substring(0, len1-i))>smn){
				smn=samechar(word1.substring(i, len1),word2.substring(0, len1-i));
				xj=len1-i;
			}
		}
		//word1从word2右侧依次挪出
		for(int i=len1-1;i>smn;i--){
			if(samechar(word1.substring(i, len1),word2.substring(0, len1-i))>=smn){
				if(i>xj){
					smn=samechar(word1.substring(i, len1),word2.substring(0, len1-i));
					xj=i;
				}
			}
		}
		return len2+len1-xj-smn;
    }
	public static int samechar(String s1,String s2){		//s1和s2长度相同
		int sum=0;
		for(int i=0;i<s1.length();i++){
			if(s1.charAt(i)==s2.charAt(i))sum++;
		}
		return sum;
	}
}
