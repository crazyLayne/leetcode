package TempTest26_50;

import java.util.Stack;

public class LongestValidParentheses {
	public static void main(String args[]){
		System.out.println(solution5(")))"));
	}
	public static int solution(String s){
		int len=0;
        int lenn=0;
		int max=0;
		char[] ch = new char[50000];
		char temp;
		int top = -1;		//栈底
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)=='('){		//入栈
				ch[++top]='(';
			}else{						//出栈
				if(top>=0){				//栈不为空
					temp = ch[top--];
					len++;
                    if(top==-1){        //上一个合法已结束
                        len += lenn;
                        max=Math.max(max,len);
                        lenn = len;     //相邻的上一个合法长度    
                        len=0;
                    }
				}else{                  //  栈空来‘）’直接判重新计数
					max=Math.max(len, max);
                    top=-1;
					len=0;
                    lenn=0;
				}
			}
		}
        if(top!=-1){
            max=Math.max(max,len-lenn);
        }else
            max=Math.max(len, max);
		return 2*max;
	}
	//Brute force time limit exceed
	public static int solution1(String s){
		int max = 0;
		for(int i=0;i<s.length()-max;i++){
			int j=i+1;
			for(;j<s.length();j=j+2){
				if(judge(s.substring(i, j+1)) && j-i+1>max){
					max=j-i+1;
				}
			}
		}
		return max;
	}
	public static boolean judge(String s){
		char[] chs = new char[2000];
		int p=-1;	//栈底，初始为空
		char temp;
		for(int i=0;i<s.length();i++){
			temp=s.charAt(i);
			if(temp=='('){
				chs[++p]=temp;
			}else{
                if(p<0)
                    return false;
                temp=chs[p--];
				if(temp!='(') return false;
			}
		}
		if(p!=-1)
			return false;
		return true;
	}

	//动态规划
	public static int solution3(String s) {
        int maxans = 0;
        int dp[] = new int[s.length()];		//dp[i]表示以i结尾的最长合法长度
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                    	  //dp[i-1]+dp[i - dp[i - 1] - 2](此处时连接上一个合法长度)+2
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }

	//栈(time limit exceeded)
	public static int solution4(String s){
		int maxLen=0;
		Stack<Integer> st=new Stack<>();
		st.push(-1);
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)=='('){
				st.push(i);
			}else{
				st.pop();
				if(st.isEmpty()){
					st.push(i);
				}else{
					maxLen=Math.max(maxLen, i-st.peek());
				}
			}
		}
		return maxLen;
	}

	//数组栈
	public static int solution5(String s){
		int maxans = 0;
        int[] st=new int[s.length()];
        int top=0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st[++top]=i;
            } else {
                top--;
                if (top<0) {
                    st[++top]=i;
                } else {
                    maxans = Math.max(maxans, i - st[top]);
                }
            }
        }
        return maxans;
	}
	
	
}
