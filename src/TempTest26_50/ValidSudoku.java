package TempTest26_50;

public class ValidSudoku {
	public static void main(String args[]){
		char[][] ch={{'.','.','4','.','.','.','6','3','.'},{'.','.','.','.','.','.','.','.','.'},{'5','.','.','.','.','.','.','9','.'},{'.','.','.','5','6','.','.','.','.'},{'4','.','3','.','.','.','.','.','1'},{'.','.','.','7','.','.','.','.','.'},{'.','.','.','5','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'}};
		System.out.print(solution(ch));
	}
	public static boolean solution(char[][] board){
		int[][] Sudoku = new int[27][9];
		int num;
		for(int i=0;i<9;i++)
			for(int j=0;j<9;j++)
				if(board[i][j]!='.'){
					num = board[i][j]-'0';
					if(Sudoku[i][num-1]!=0 || Sudoku[j+9][num-1]!=0 || Sudoku[3*(i/3)+j/3+18][num-1]!=0)
						return false;
					else{
						Sudoku[i][num-1]=1; Sudoku[j+9][num-1]=1; Sudoku[3*(i/3)+j/3+18][num-1]=1;
					}
				}
		return true;
	}
}
