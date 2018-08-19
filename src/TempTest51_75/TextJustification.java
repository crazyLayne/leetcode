package TempTest51_75;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
	public static void main(String args[]){
		String[] words={"a"};
		int width=1;
		fullJustify(words,width);
	}
	public static List<String> fullJustify(String[] words, int maxWidth) {
		List<String> ans=new ArrayList<>();
		String an="";
		char[] bn=new char[maxWidth];
        for(int t=0;t<maxWidth;t++){
			bn[t]=' ';
		}
        if(words.length==0 || maxWidth==0){
            ans.add(an);
            return ans;
        }
        else if(words[0].length()==0 && maxWidth>0){
            an=String.valueOf(bn);
            ans.add(an);
            return ans;
        }
        int l,r;        //判断每行的边界。
        l=0;
        r=l;
        int sum;
        while(r<words.length){
            an="";
        	sum=words[l].length();
        	while(r<words.length-1 && sum<=maxWidth){
                r++;
                sum+=1+words[r].length();
            }
        	if(r>=words.length-1 && sum<=maxWidth){		//最后一行了
        		break;
        	}
            r--;
            sum=0;
            for(int i=l;i<=r;i++){
                sum+=words[i].length();          //单词总长度
            }
            int spc=maxWidth-sum;       //空格个数
            StringBuffer senvspc=new StringBuffer();
            if(l==r){                   //一行只有一个单词
                for(int i=0;i<spc;i++){
            	    senvspc.append(" ");
                }
                an+=words[l]+senvspc.toString();
            }else{
                int envspc=spc/(r-l);       //每个单词间空格平均
                for(int i=0;i<envspc;i++){
            	    senvspc.append(" ");
                }
                int restspc=spc%(r-l);      //剩余空格个数
                for(int i=0;i<restspc;i++){		//多一个空格
            	    an+=words[l+i]+senvspc.toString()+" ";
                }
                for(int i=l+restspc;i<r;i++){	//少一个空格
                	an+=words[i]+senvspc.toString();
                }
                an+=words[r];
            }
            ans.add(an);
            r++;
            l=r;
        }
        for(int t=0;t<maxWidth;t++){
			bn[t]=' ';
		}
        if(l==words.length-1){      //最后一行只剩一个单词了
            for(int i=0;i<words[l].length();i++){
            	bn[i]=words[l].charAt(i);
            }
            an=String.valueOf(bn);
            ans.add(an);
        }else{
        	int k=0;
            for(int i=l;i<words.length-1;i++){
            	for(int j=0;j<words[i].length();j++){
            		bn[k]=words[i].charAt(j);
            		k++;
            	}
            	k++;
            }
            for(int j=0;j<words[words.length-1].length();j++){
            	bn[k]=words[words.length-1].charAt(j);
            	k++;
            }
            an=String.valueOf(bn);
            ans.add(an);
        }
        return ans;
    }

}
