package TempTest126_150;

public class SurroundedRegions {
	public static void main(String args[]){
		
	}
	public void solve(char[][] board) {
        if(board.length==0 || board[0].length==0)return;
        int m=board.length;
        int n=board[0].length;
        boolean[][] visit=new boolean[m][n];
        for(int i=0;i<m;i++){       //第一行和最后一行
            if(board[i][0]=='O') dfs(i, 0, board, visit);
            if(board[i][n-1]=='O') dfs(i, n-1, board, visit);
        }
        for(int i=0;i<n;i++){       //第一列和最后一列
            if(board[0][i]=='O') dfs(0, i, board, visit);
            if(board[m-1][i]=='O') dfs(m-1, i, board, visit);
        }
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                if(board[i][j]=='O' && !visit[i][j]) board[i][j]='X';
    }
    //遍历点（x，y）相邻的0，并标记visit
    public void dfs(int x, int y, char[][] board, boolean[][] visit){
        if(x<0 || x>=board.length || y<0 || y>=board[0].length)return;
        if(visit[x][y])return;
        if(board[x][y]=='O'){
            visit[x][y]=true;
            dfs(x+1, y, board, visit);
            dfs(x-1, y, board, visit);
            dfs(x, y+1, board, visit);
            dfs(x, y-1, board, visit);
        }
    }

}
