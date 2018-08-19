package TempTest51_75;

public class SpiralMatrix2 {
	public static void main(String args[]){
		System.out.print(solution(3));
	}
	public static int[][] solution(int n){
		int[][] ans = new int[n][n];
		int num=0;
		for(int lay=0;lay<(n+1)/2;lay++){	//层数
			num++;
			int len=n-2*lay;	//每一层的长度
			for(int i=lay;i<lay+len-1;i++)
				ans[lay][i]=num++;
			for(int j=lay;j<lay+len-1;j++)
				ans[j][lay+len-1]=num++;
			for(int i=lay+len-1;i>lay;i--)
				ans[lay+len-1][i]=num++;
			for(int j=lay+len-1;j>lay;j--)
				ans[j][lay]=num++;
			if(num==n*n||num==n*n+1)
				break;
		}
		if(n%2!=0)
			ans[n/2][n/2]=num;
		return ans;
	}

}
