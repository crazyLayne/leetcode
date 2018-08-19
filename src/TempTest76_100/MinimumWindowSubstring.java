package TempTest76_100;

import java.util.HashMap;

public class MinimumWindowSubstring {
	public static void main(String args[]){
		String a,b;
		a="bba";
		b="ab";
		System.out.println(minWindow(a,b));;
	}
	public static String minWindow(String s, String t) {
		if(s.length()==0 || t.length()==0 || s.length()<t.length())return "";
		HashMap<Character, Integer> hash=new HashMap<>();
		HashMap<Character, Integer> target=new HashMap<>();
		char ccc;
		for(int i=0;i<t.length();i++){
			ccc=t.charAt(i);
			if(hash.containsKey(ccc)){
				target.put(ccc, target.get(ccc)+1);
			}else{
				hash.put(ccc, 0);
				target.put(ccc, 1);
			}
		}		
		int l,r;			//��¼window���ұ仯���
		l=0;
		r=0;
		//��һ������������ҵ��������е�ֵ
		MinimumWindowSubstring mws=new MinimumWindowSubstring();
		window w=mws.new window(0,0,hash);		//��¼��Сwindow��������
		char c;
		for(;r<s.length();r++){
			c=s.charAt(r);
			if(hash.containsKey(c))hash.put(c, hash.get(c)+1);
			if(w.judge(t,target)){				//��ƥ��ʱ��¼Ŀǰ��Сwindow
				w.right=r;
				break;
			}
		}
		if(!w.judge(t,target))return "";		//һ�����겻ƥ��
		while(r<s.length()){			//��ʼŲ��window
			while(l<=r && r<s.length()){				//��Ų���
				c=s.charAt(l);
				if(w.hash.containsKey(c)){
					w.hash.put(c, w.hash.get(c)-1);
					if(w.hash.get(c)<target.get(c)){		//��Ų���²�ƥ�䣬��Ų��ȫ
						char cc;
						r++;
						while(r<s.length()){
							cc=s.charAt(r);
							if(cc==c){	//��ȫ�Ժ�Ƚ��Ƿ���С��window
								w.hash.put(c, w.hash.get(c)+1);
								if(r-l-1<w.right-w.left){		//r-l-1
									w.right=r;
									w.left=l+1;
								}
								break;
							}else{
								if(w.hash.containsKey(cc))w.hash.put(cc, w.hash.get(cc)+1);
							}
							r++;
						}
					}else{						//����������ֱ�ӹ�
						if(r-l-1<w.right-w.left){		//r-l-1
							w.right=r;
							w.left=l+1;
						}
					}
				}else{						//����������ֱ�ӹ�
					if(r-l-1<w.right-w.left){		//r-l-1
						w.right=r;
						w.left=l+1;
					}
				}
				l++;
			}
		}
		
		
        return s.substring(w.left,w.right+1);
    }
	class window{
		int left;
		int right;
		HashMap<Character, Integer> hash;		//�ڲ����ڵĸ����ַ�����
		window(int l, int r, HashMap<Character, Integer> h){
			left=l;
			right=r;
			hash=h;
		}
		boolean judge(String t,HashMap target){
			for(int i=0;i<t.length();i++){
				if((int)hash.get(t.charAt(i)) < (int)target.get(t.charAt(i)))return false;
			}
			return true;
		}
	}

}
