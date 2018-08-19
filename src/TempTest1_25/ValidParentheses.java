package TempTest1_25;

public class ValidParentheses {
	public static void main(String args[]){
		
	}
	public static boolean solution(String s){
		char[] chs = new char[2000];
		int p=-1;	//Õ»µ×£¬³õÊ¼Îª¿Õ
		char temp,tempp;
		for(int i=0;i<s.length();i++){
			temp=s.charAt(i);
			if(temp=='('||temp=='['||temp=='{'){
				chs[++p]=temp;
			}else{
                if(p<0)
                    return false;
				tempp=chs[p--];
                switch(tempp){
                    case '(' : if(temp!=')') return false;break;
                    case '{' : if(temp!='}') return false;break;
                    case '[' : if(temp!=']') return false;break;}
			}
		}
		if(p!=-1)
			return false;
		return true;
	}

}
