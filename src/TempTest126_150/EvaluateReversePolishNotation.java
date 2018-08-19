package TempTest126_150;

public class EvaluateReversePolishNotation {
	public static void main(String args[]){
//		String[] res={"2","1","+","3","*"};
		String[] res={"4","13","5","/","+"};
//		String[] res={"0","3","/"};
		System.out.println(evalRPN(res));
		
	}

	public static int evalRPN(String[] tokens) {
        int len=tokens.length;
        if(len==0)return 0;
        if(len==1)return StringtoInt(tokens[0]);
        int[] st=new int[len];
        int stTop,p;       //栈底，栈顶，当前访问
        stTop=-1;
        int ans;                //运算结果
        for(p=0;p<len;p++){
            if(tokens[p]=="+" || tokens[p]=="-" || tokens[p]=="*" || tokens[p]=="/"){       //出栈俩个，进行运算(运算符不入栈)
                ans=cal(st[stTop-1],st[stTop],tokens[p]);
                stTop-=2;
                st[++stTop]=ans;
            }else{      //入栈
                st[++stTop]=StringtoInt(tokens[p]);     //或者用Integer.valueOf()
            }
        }
        return st[stTop];
//        return stTop;
    }
    public static int StringtoInt(String s){
        int num=0;
        for(int i=0;i<s.length();i++){
            num=num*10+(s.charAt(i)-'0');
        }
        return num;
    }
    public static int cal(int num1, int num2, String operator){
        switch(operator){
            case "+":
                return num1+num2;
            case "-":
                return num1-num2;
            case "*":
                return num1*num2;
            default:
                return num1/num2;
        }
    }
}
