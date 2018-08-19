package TempTest76_100;

public class DecodeWays {
	public static void main(String args[]){
		String s="101";
		System.out.println(numDecodings3(s));
		System.out.println(numDecodings2(s));
//		System.out.println(s.charAt(0)-'6');
//		1769472
	}
	public static int numDecodings(String s) {			//递归解法
        int n=s.length()-1;
        if(n<0)return 0;
        return solve(s,0,n);
    }
    public static int solve(String s, int i, int n){          //i指当前解码坐标
        if(s.charAt(i)=='0')return 0;       
        else if(i==n){   //末尾
            return 1;
        }else if(s.charAt(i)=='1'){    //当为1，2时有两种情况
            if(i<n-1){      //存在后两位
                if(s.charAt(i+1)=='0'){         //只能两位一起算
                    return solve(s,i+2,n);
                }else{
                    return solve(s,i+1,n)+solve(s,i+2,n);
                }
            }else{          //i是倒数第二位
                if(s.charAt(i+1)=='0'){         //只能两位一起算
                    return 1;
                }else{
                    return 2;
                }
            }
        }else if(s.charAt(i)=='2'){
            if(i<n-1){      //存在后两位
                if(s.charAt(i+1)=='0'){         //只能两位一起算
                    return solve(s,i+2,n);
                }else if(s.charAt(i+1)-'6'<=0){                     //第二位小于6
                    return solve(s,i+1,n)+solve(s,i+2,n);
                }else{                          //必须分开算
                    return solve(s,i+2,n);
                }
            }else{          //i是倒数第二位
                if(s.charAt(i+1)=='0'){         //只能两位一起算
                    return 1;
                }else if(s.charAt(i+1)-'6'<=0){
                    return 2;
                }else{
                    return 1;
                }
            }
        }else{
            return solve(s,i+1,n);
        }
        
    }

    public static int numDecodings2(String s){
    	int n=s.length();
        if(n<=0)return 0;
        int[] ways=new int[n];
        return solve2(s,0,n-1,ways);
    }
    public static int solve2(String s, int i, int n, int[] ways){
    	if(s.charAt(i)=='0')return 0;  			//错误编码     
        else if(ways[i]!=0){
        	return ways[i];
        }else if(i==n){   //末尾
        	ways[i]=1;
            return 1;
        }else if(s.charAt(i)=='1'){    //当为1，2时有两种情况
            if(i<n-1){      //存在后两位
                if(s.charAt(i+1)=='0'){         //只能两位一起算
                	ways[i]=solve2(s,i+2,n,ways);
                    return ways[i];
                }else{
                	ways[i]=solve2(s,i+1,n,ways)+solve2(s,i+2,n,ways);
                    return ways[i];
                }
            }else{          //i是倒数第二位
                if(s.charAt(i+1)=='0'){         //只能两位一起算
                	ways[i]=1;
                    return 1;
                }else{
                	ways[i]=2;
                    return 2;
                }
            }
        }else if(s.charAt(i)=='2'){
            if(i<n-1){      //存在后两位
                if(s.charAt(i+1)=='0'){         //只能两位一起算
                	ways[i]=solve2(s,i+2,n,ways);
                    return ways[i];
                }else if(s.charAt(i+1)-'6'<=0){                     //第二位小于6
                	ways[i]=solve2(s,i+1,n,ways)+solve2(s,i+2,n,ways);
                    return ways[i];
                }else{                          //必须分开算
                	ways[i]=solve2(s,i+2,n,ways);
                    return ways[i];
                }
            }else{          //i是倒数第二位
                if(s.charAt(i+1)=='0'){         //只能两位一起算
                	ways[i]=1;
                    return 1;
                }else if(s.charAt(i+1)-'6'<=0){
                	ways[i]=2;
                    return 2;
                }else{
                	ways[i]=1;
                    return 1;
                }
            }
        }else{
        	ways[i]=solve2(s,i+1,n,ways);
            return ways[i];
        }
    }

    public static int numDecodings3(String s){
    	int n=s.length();
        if(n<=0)return 0;
        int sum,sum1,sum2;		//头元素为单码的和，头元素为双码的和。
        if(s.charAt(n-1)=='0'){
            if(n-2>=0 && (s.charAt(n-2)=='1' || s.charAt(n-2)=='2')){
                sum2=1;
                sum1=0;
                n--;
            }else{              //非法编码
                return 0;
            }
        }else{
            sum1=1;
            sum2=0;
        }
        sum=sum1+sum2;
        for(int i=n-2;i>=0;i--){	
        	if(s.charAt(i)=='0'){	//新添字符为0，怎需再添一字符
        		i--;                //若i<0,则为非法编码
                if(i>=0 && (s.charAt(i)=='1' || s.charAt(i)=='2')){
                    sum2=sum;
        		    sum1=0;
                }else{
                    return 0;
                }
        	}else{
        		//头元素为单码要考虑是否能和新加入字符组成双码
        		if(s.charAt(i)=='1' || (s.charAt(i)=='2' && s.charAt(i+1)-'6'<=0)){
                	//头元素双码，新加一个字符，直接变单码
                	sum1+=sum2;
                	sum2=sum1-sum2;
                	
        		}else{		//不能加进去，新的头元素必定单码
        			sum1=sum;
        			sum2=0;
        		}

            	sum=sum1+sum2;
        	}
        }
        return sum;
    }
    
}
