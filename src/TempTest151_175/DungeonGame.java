package TempTest151_175;

public class DungeonGame {
	public static void main(String args[]){
		int[][] dungeon={{-2,-3,3},{-5,-10,1},{10,30,-5}};
		System.out.println(calculateMinimumHP(dungeon));
		
	}
	
	public static int calculateMinimumHP(int[][] dungeon){
		if(dungeon.length==0 || dungeon[0].length==0)return 0;
		int m = dungeon.length;
		int n = dungeon[0].length;
		int[][] dp = new int[m][n];
		for(int i=m-1;i>=0;i--){
			for(int j=n-1;j>=0;j--){
				if(i==m-1 && j==n-1)dp[i][j]=Math.max(1, 1-dungeon[i][j]);
				else if(i==m-1){
					dp[i][j]=Math.max(1,dp[i][j+1]-dungeon[i][j]);
				}else if(j==n-1){
					dp[i][j]=Math.max(1,dp[i+1][j]-dungeon[i][j]);
				}else{
					dp[i][j]=Math.max(1, Math.min(dp[i][j+1], dp[i+1][j])-dungeon[i][j]);
				}
			}
		}
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				System.out.print(dp[i][j]+" \t");
			}
			System.out.println();
		}
		return dp[0][0];
	}
	

}
