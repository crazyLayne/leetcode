package TempTest51_75;

public class UniquePaths {
	public static void main(String args[]){
		System.out.print(solution(23,12));
	}
	public static int solution(int m,int n){
		int[] sum=new int[1];
		solve(m-1,n-1,sum);			//m步向下,n步向右
		return sum[0];
	}
	public static void solve(int m,int n,int[] sum){
		if(m==0||n==0){
			sum[0]++;
		}else{
			solve(m-1,n,sum);
			solve(m,n-1,sum);
		}
	}
	
	public int uniquePaths(int m, int n) {
        int[][] paths=new int[m][n];
        return solve(m-1,n-1,paths);
	}
	public int solve(int m,int n,int[][] paths){
		if(m==0||n==0){
			return 1;
		}else if(paths[m][n]!=0){
            return paths[m][n];
        }else{
            paths[m][n]=solve(m-1,n,paths)+solve(m,n-1,paths);
            return paths[m][n];
		}
	}

}
