package TempTest51_75;

public class Searcha2DMatrix {
	public static void main(String args[]){
		int[][] matrix={{1,3,5,7},{10,11,16,20},{23,30,34,50}};
		int target=3;
		System.out.print(searchMatrix(matrix,target));
	}
	public static boolean searchMatrix(int[][] matrix, int target) {
		if(matrix.length==0||matrix[0].length==0)return false;
        int m=matrix.length;
        int n=matrix[0].length;
        if(target<matrix[0][0] || target>matrix[m-1][n-1])return false;
        if(target>=matrix[m-1][0]){
            for(int i=0;i<n;i++){
                if(target==matrix[m-1][i])return true;
            }
            return false;
        }
        int low,high,mid;
        low=0;
        high=m-1;
        mid=(high+low)/2;
        while(low<high){
            if(matrix[mid][0]==target){
                return true;
            }else if(matrix[mid][0]>target){
                high=mid;
            }else{
                low=mid;
            }
            if(low==high-1)break;
            mid=(high+low)/2;
        }
        for(int i=0;i<n;i++){
            if(matrix[low][i]==target)return true;
        }
        return false;
    }
	public static boolean searchMatrix2(int[][] matrix, int target) {
		if(matrix.length==0||matrix[0].length==0)return false;
        int m=matrix.length;
        int n=matrix[0].length;
        if(target<matrix[0][0] || target>matrix[m-1][n-1])return false;
        int i,j;
        i=m-1;
        j=0;
        while(i>=0&&j<n){
        	if(matrix[i][j]==target)return true;
        	else if(matrix[i][j]<target)j++;
        	else i--;
        }
        return false;
	}
}
