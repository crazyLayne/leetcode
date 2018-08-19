package TempTest76_100;

public class DecodeWays {
	public static void main(String args[]){
		String s="101";
		System.out.println(numDecodings3(s));
		System.out.println(numDecodings2(s));
//		System.out.println(s.charAt(0)-'6');
//		1769472
	}
	public static int numDecodings(String s) {			//�ݹ�ⷨ
        int n=s.length()-1;
        if(n<0)return 0;
        return solve(s,0,n);
    }
    public static int solve(String s, int i, int n){          //iָ��ǰ��������
        if(s.charAt(i)=='0')return 0;       
        else if(i==n){   //ĩβ
            return 1;
        }else if(s.charAt(i)=='1'){    //��Ϊ1��2ʱ���������
            if(i<n-1){      //���ں���λ
                if(s.charAt(i+1)=='0'){         //ֻ����λһ����
                    return solve(s,i+2,n);
                }else{
                    return solve(s,i+1,n)+solve(s,i+2,n);
                }
            }else{          //i�ǵ����ڶ�λ
                if(s.charAt(i+1)=='0'){         //ֻ����λһ����
                    return 1;
                }else{
                    return 2;
                }
            }
        }else if(s.charAt(i)=='2'){
            if(i<n-1){      //���ں���λ
                if(s.charAt(i+1)=='0'){         //ֻ����λһ����
                    return solve(s,i+2,n);
                }else if(s.charAt(i+1)-'6'<=0){                     //�ڶ�λС��6
                    return solve(s,i+1,n)+solve(s,i+2,n);
                }else{                          //����ֿ���
                    return solve(s,i+2,n);
                }
            }else{          //i�ǵ����ڶ�λ
                if(s.charAt(i+1)=='0'){         //ֻ����λһ����
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
    	if(s.charAt(i)=='0')return 0;  			//�������     
        else if(ways[i]!=0){
        	return ways[i];
        }else if(i==n){   //ĩβ
        	ways[i]=1;
            return 1;
        }else if(s.charAt(i)=='1'){    //��Ϊ1��2ʱ���������
            if(i<n-1){      //���ں���λ
                if(s.charAt(i+1)=='0'){         //ֻ����λһ����
                	ways[i]=solve2(s,i+2,n,ways);
                    return ways[i];
                }else{
                	ways[i]=solve2(s,i+1,n,ways)+solve2(s,i+2,n,ways);
                    return ways[i];
                }
            }else{          //i�ǵ����ڶ�λ
                if(s.charAt(i+1)=='0'){         //ֻ����λһ����
                	ways[i]=1;
                    return 1;
                }else{
                	ways[i]=2;
                    return 2;
                }
            }
        }else if(s.charAt(i)=='2'){
            if(i<n-1){      //���ں���λ
                if(s.charAt(i+1)=='0'){         //ֻ����λһ����
                	ways[i]=solve2(s,i+2,n,ways);
                    return ways[i];
                }else if(s.charAt(i+1)-'6'<=0){                     //�ڶ�λС��6
                	ways[i]=solve2(s,i+1,n,ways)+solve2(s,i+2,n,ways);
                    return ways[i];
                }else{                          //����ֿ���
                	ways[i]=solve2(s,i+2,n,ways);
                    return ways[i];
                }
            }else{          //i�ǵ����ڶ�λ
                if(s.charAt(i+1)=='0'){         //ֻ����λһ����
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
        int sum,sum1,sum2;		//ͷԪ��Ϊ����ĺͣ�ͷԪ��Ϊ˫��ĺ͡�
        if(s.charAt(n-1)=='0'){
            if(n-2>=0 && (s.charAt(n-2)=='1' || s.charAt(n-2)=='2')){
                sum2=1;
                sum1=0;
                n--;
            }else{              //�Ƿ�����
                return 0;
            }
        }else{
            sum1=1;
            sum2=0;
        }
        sum=sum1+sum2;
        for(int i=n-2;i>=0;i--){	
        	if(s.charAt(i)=='0'){	//�����ַ�Ϊ0����������һ�ַ�
        		i--;                //��i<0,��Ϊ�Ƿ�����
                if(i>=0 && (s.charAt(i)=='1' || s.charAt(i)=='2')){
                    sum2=sum;
        		    sum1=0;
                }else{
                    return 0;
                }
        	}else{
        		//ͷԪ��Ϊ����Ҫ�����Ƿ��ܺ��¼����ַ����˫��
        		if(s.charAt(i)=='1' || (s.charAt(i)=='2' && s.charAt(i+1)-'6'<=0)){
                	//ͷԪ��˫�룬�¼�һ���ַ���ֱ�ӱ䵥��
                	sum1+=sum2;
                	sum2=sum1-sum2;
                	
        		}else{		//���ܼӽ�ȥ���µ�ͷԪ�رض�����
        			sum1=sum;
        			sum2=0;
        		}

            	sum=sum1+sum2;
        	}
        }
        return sum;
    }
    
}
