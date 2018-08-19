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
		for(int i=0;i<words.length;i++){        //将所有单词存入hashmap，并置其val为该单词出现次数
			if(map.containsKey(words[i]))map.put(words[i], map.get(words[i])+1);
			else map.put(words[i], 1);
		}
        int len=words[0].length();
        int n=words.length;
        int maxlen=len*n;
        String str;
        List<String> word = new ArrayList<>();  //记录区间内的单词，用于还原hashmap
        for(int i=0;i<len;i++){         //从第i个元素开始，以单词长度划分s
            int k=i;                    //挪动区间,每次挪动一个len，并判断越界
            while(k+maxlen<=s.length()){          //越界判定
            	int p=k;                    	//当前单词位置
                while(p<k+maxlen){              //p在区间k~k+maxlen之间遍历
                    str=s.substring(p,p+len);   //取出当前单词
                    if(map.containsKey(str)){
                        map.put(str,map.get(str)-1);
                        word.add(str);
                    }else{
                        break;
                    }
                    p+=len;
                }
                if(word.size()==n){     //遍历完s后，跳出循环，是个合法结果
                	if(judgeMap(map))
                		lists.add(k);
                //  一个单词一个单词挪动，直到下一个单词不在words内
                    k=k+len;
                    while(k+maxlen<=s.length()){        //不越界
                        String str1=s.substring(k-len,k);                   //删除的单词         
                        String str2=s.substring(k+maxlen-len,k+maxlen);     //增加的单词
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
                //挪动区间
                 k=p+len;
                //还原hashmap
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
