package TempTest26_50;

public class RotateImage {
	public static void main(String args[]){
		
	}
	public static void solution(int [][] matrix){
		int n=matrix.length;
		int temp;
		for(int i=0;i<n;i++){				//¶Ô½ÇÐý×ª
			for(int j=0;j<n-i-1;j++){
				temp=matrix[i][j];
				matrix[i][j]=matrix[n-i][n-j];
				matrix[n-i][n-j]=temp;
			}
		}
		for(int i=0;i<n/2;i++){
			for(int j=0;j<n;j++){
				temp=matrix[i][j];
				matrix[i][j]=matrix[n-i][j];
				matrix[n-i][j]=temp;
			}
		}
	}

}
