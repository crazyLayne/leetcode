package TempTest201_225;

public class CountPrimes {
	public static void main(String args[]){
		System.out.println(conutPrimes3(15000));
	}
	public static int conutPrimes(int n){
		int count=0;
        for(int i=2;i<n;i++){       //1不是素数,也不是合数
            if(isPrimes(i))count++;
        }
        return count;
	}
	public static boolean isPrimes(int n){
		for(int i=2;i<=Math.sqrt(n);i++){
			if(n%i==0)return false;
		}
		return true;
	}
	//找到一个素数后，将它小于n的倍数都标记
	public static int conutPrimes2(int n){
		int count=0;
		boolean[] visit=new boolean[n];
		for(int i=2;i<n;i++){
			if(!visit[i] && isPrimes(i)){
				visit[i]=true;
                count++;
                int temp=i*2;
                while(temp<n){
                    visit[temp]=true;
                    temp+=i;
				}
			}
		}
		return count;
	}
	//从前往后找倍数
	public static int conutPrimes3(int n){
		boolean[] visit=new boolean[n];
		visit[0]=true;visit[1]=true;
		for(int i=2;i<=Math.sqrt(n);i++){
			if(!visit[i]){
				for(int j=i*2;j<n;j+=i){
					visit[j]=true;
				}
			}
		}
		int count=0;
		for(boolean flag:visit){
			if(!flag)count++;
		}
		return count;
	}	

}
