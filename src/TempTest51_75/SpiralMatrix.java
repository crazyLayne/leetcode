package TempTest51_75;
import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	public static void main(String args[]){
		int[][] matrix={{1,2,3,4,5,6,7,8,9,10},{11,12,13,14,15,16,17,18,19,20}};
		System.out.println(solution(matrix));
	}
	public static List<Integer> solution(int[][] matrix){
		List<Integer> ans = new ArrayList<>();
		if(matrix.length==0||matrix[0].length==0)return ans;
		solve(matrix,matrix.length,matrix[0].length,0,0,ans);
		return ans;
	}
	public static void solve(int[][] matrix,int m,int n,int a,int b,List<Integer> ans){
		if(a==m-a-1){			//只剩一行或一列，最后的迭代
			for(int i=a;i<n-b;i++){
				ans.add(matrix[a][i]);
			}
		}else if(b==n-b-1){
			for(int i=b;i<m-a;i++){
				ans.add(matrix[i][b]);
			}
		}else{
			for(int i=b;i<n-b;i++){
				ans.add(matrix[a][i]);
			}
			for(int i=a+1;i<m-a;i++){
				ans.add(matrix[i][n-b-1]);
			}
			for(int i=n-b-2;i>=b;i--){
				ans.add(matrix[m-a-1][i]);
			}
			for(int i=m-a-2;i>a;i--){
				ans.add(matrix[i][b]);
			}
			if(a+1<m-a-1 && b+1<n-b-1)solve(matrix,m,n,a+1,b+1,ans);
		}
	}

}
