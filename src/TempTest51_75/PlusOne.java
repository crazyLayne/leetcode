package TempTest51_75;

public class PlusOne {
	public static void main(String args[]){
		
	}
	public static int[] solution(int[] digits){
		int len = digits.length;
		int[] ans = new int[len+1];
		int i;
		for(i=len-1;i>0;i--){
			if(digits[i]!=9){
				ans[i+1]=digits[i]+1;
				i=-1;
				break;
			}else{
				digits[i]=0;
			}
		}
		if(i==0&&digits[i]==9){
			ans[0]=1;
			ans[1]=0;
			return ans;
		}else if(i==0){
			digits[i]++;
		}
		return digits;
	}

}
