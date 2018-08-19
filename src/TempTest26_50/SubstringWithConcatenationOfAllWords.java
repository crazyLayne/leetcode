package TempTest26_50;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstringWithConcatenationOfAllWords {
	public static void main(String args[]){
		String[] words={"a","b"};
		String s="abababab";
		solution(s, words);
	}
	
	public static List<Integer> solution(String s,String[] words){
		List<Integer> lists = new ArrayList<>();
        HashMap<String,Integer> map = new HashMap<>();
		for(int i=0;i<words.length;i++){        //�����е��ʴ���hashmap��������valΪ�õ��ʳ��ִ���
			if(map.containsKey(words[i]))map.put(words[i], map.get(words[i])+1);
			else map.put(words[i], 1);
		}
        int len=words[0].length();
        int n=words.length;
        int maxlen=len*n;
        String str;
        List<String> word = new ArrayList<>();  //��¼�����ڵĵ��ʣ����ڻ�ԭhashmap
        for(int i=0;i<len;i++){         //�ӵ�i��Ԫ�ؿ�ʼ���Ե��ʳ��Ȼ���s
            int k=i;                    //Ų������,ÿ��Ų��һ��len�����ж�Խ��
            while(k+maxlen<=s.length()){          //Խ���ж�
            	int p=k;                    	//��ǰ����λ��
                while(p<k+maxlen){              //p������k~k+maxlen֮�����
                    str=s.substring(p,p+len);   //ȡ����ǰ����
                    if(map.containsKey(str)){
                        map.put(str,map.get(str)-1);
                        word.add(str);
                    }else{
                        break;
                    }
                    p+=len;
                }
                if(word.size()==n){     //������s������ѭ�����Ǹ��Ϸ����
                	if(judgeMap(map))
                		lists.add(k);
                //  һ������һ������Ų����ֱ����һ�����ʲ���words��
                    k=k+len;
                    while(k+maxlen<=s.length()){        //��Խ��
                        String str1=s.substring(k-len,k);                   //ɾ���ĵ���         
                        String str2=s.substring(k+maxlen-len,k+maxlen);     //���ӵĵ���
                        if(!map.containsKey(str2)){
                            break;
                        }else{
                            map.put(str1,map.get(str1)+1);
                            map.put(str2,map.get(str2)-1);
                            if(judgeMap(map)) lists.add(k);
                        }
                        k+=len;
                    }
                }
                //Ų������
                 k=p+len;
                //��ԭhashmap
                for(String strr:word){
                    map.put(strr,map.get(strr)+1);
                }
                word=new ArrayList<>();
            }
        }
		return lists;
	}

	public static boolean judgeMap(HashMap<String,Integer> map){
		for(String str:map.keySet()){
			if(map.get(str)!=0){
				return false;
			}
		}
		return true;
	}
	
}
