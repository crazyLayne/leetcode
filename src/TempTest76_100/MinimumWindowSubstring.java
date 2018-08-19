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
		int l,r;			//记录window左右变化情况
		l=0;
		r=0;
		//第一遍从左往右先找到包括所有的值
		MinimumWindowSubstring mws=new MinimumWindowSubstring();
		window w=mws.new window(0,0,hash);		//记录最小window左右坐标
		char c;
		for(;r<s.length();r++){
			c=s.charAt(r);
			if(hash.containsKey(c))hash.put(c, hash.get(c)+1);
			if(w.judge(t,target)){				//当匹配时记录目前最小window
				w.right=r;
				break;
			}
		}
		if(!w.judge(t,target))return "";		//一遍走完不匹配
		while(r<s.length()){			//开始挪动window
			while(l<=r && r<s.length()){				//先挪左边
				c=s.charAt(l);
				if(w.hash.containsKey(c)){
					w.hash.put(c, w.hash.get(c)-1);
					if(w.hash.get(c)<target.get(c)){		//左挪导致不匹配，右挪补全
						char cc;
						r++;
						while(r<s.length()){
							cc=s.charAt(r);
							if(cc==c){	//补全以后比较是否缩小了window
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
					}else{						//不包括，就直接过
						if(r-l-1<w.right-w.left){		//r-l-1
							w.right=r;
							w.left=l+1;
						}
					}
				}else{						//不包括，就直接过
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
		HashMap<Character, Integer> hash;		//内部存在的各个字符数量
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
