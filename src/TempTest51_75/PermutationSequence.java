package TempTest51_75;

public class PermutationSequence {
	public static void main(String args[]){
		System.out.println(solution(3,2));
	}
	public static String solution(int n, int k){
		String str="";
		int sum=1;
		for(int i=1;i<=n;i++){
			sum*=i;
		}
        int[]  states = new int[n];
        int shang;
        for(int i=0;i<n-1;i++){		//第i位填啥
        	sum=sum/(n-i);
        	shang=k/sum;
        	k=k%sum;
        	if(k!=0)				//有余数进位
        		shang++;
        	for(int j=0;j<n;j++){
        		if(states[j]!=1)
        			shang--;
        		if(shang==0){
        			str+=(j+1);
        			states[j]=1;
        			break;
        		}
        	}
        }
        for(int j=0;j<n;j++){
    		if(states[j]==0){
    			str+=(j+1);
    		}
    	}
        
        return str;
    }

}
