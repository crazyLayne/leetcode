package TempTest51_75;

public class MinPathSum {
	public static void main(String args[]){
		
	}
	public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] minPath=new int[m][n];
        minPath[m-1][n-1]=grid[m-1][n-1];
        for(int i=m-2;i>=0;i--){
            minPath[i][n-1]=minPath[i+1][n-1]+grid[i][n-1];
        }
        for(int j=n-2;j>=0;j--){
            minPath[m-1][j]=minPath[m-1][j+1]+grid[m-1][j];
        }
        return judge(grid,minPath,0,0);
    }
    public int judge(int[][] grid, int[][] minPath, int i, int j){         //ÅÐ¶ÏÄ³µã
        if(minPath[i][j]!=0 || i==grid.length-1 || j==grid[0].length-1){           //ÒÑ¸³Öµ
            return minPath[i][j];
        }else{
            minPath[i][j]=grid[i][j]+Math.min(judge(grid,minPath,i+1,j),judge(grid,minPath,i,j+1));
            return minPath[i][j];
        }
    }
}
