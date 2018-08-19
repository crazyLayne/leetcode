package TempTest51_75;

public class MinDistance {
	public static void main(String args[]){
		String s1="sea";
		String s2="ate";
		System.out.println(minDistance(s1,s2));
	}
	public static int minDistance(String word1, String word2) {
        if(word1.length()>word2.length()){		//��word1��word2��
        	String word3=word1;
        	word1=word2;
        	word2=word3;
        }
        int len1=word1.length();
        int len2=word2.length();
        //�Ƚ�����word�ཻ���ֵģ��ȿ���word1��ȫ��word2��
        int smn=0;		//��ͬ�ַ���Ŀ
        int xj=len1;		//�ཻ���ֳ���
        for(int i=0;i<=len2-len1;i++){
        	smn=Math.max(samechar(word1,word2.substring(i, i+len1)), smn);
        }
        //���һ����ȫ�ཻ����µ������ͬ�ַ���Ŀ�󣬲����ཻ���ཻ���ȱ�����ڴ�ֵ
        //word1��word2�������Ų��,ѭ���������Զ�̬�仯
		for(int i=1;len1-i>smn;i++){
			if(samechar(word1.substring(i, len1),word2.substring(0, len1-i))>smn){
				smn=samechar(word1.substring(i, len1),word2.substring(0, len1-i));
				xj=len1-i;
			}
		}
		//word1��word2�Ҳ�����Ų��
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
	public static int samechar(String s1,String s2){		//s1��s2������ͬ
		int sum=0;
		for(int i=0;i<s1.length();i++){
			if(s1.charAt(i)==s2.charAt(i))sum++;
		}
		return sum;
	}
}
