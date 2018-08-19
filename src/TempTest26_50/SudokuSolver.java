package TempTest26_50;

public class SudokuSolver {
	public static void main(String args[]){
//		
		char[][] shu={{'.','.','9','7','4','8','.','.','.'},{'7','.','.','.','.','.','.','.','.'},{'.','2','.','1','.','9','.','.','.'},{'.','.','7','.','.','.','2','4','.'},{'.','6','4','.','1','.','5','9','.'},{'.','9','8','.','.','.','3','.','.'},{'.','.','.','8','.','3','.','2','.'},{'.','.','.','.','.','.','.','.','6'},{'.','.','.','2','7','5','9','.','.'}};
		solveSudoku(shu);
		System.out.println(" ");
	}
	public static void solveSudoku(char[][] board){
		int[][] row = new int[9][9];
		int[][] column = new int[9][9];
		int[][] block = new int[9][9];
		int num;
		int count = 0;							//记录不确定的格子数目
		for(int i=0;i<9;i++)					//赋初值状态
			for(int j=0;j<9;j++)
				if(board[i][j]!='.'){
					num = board[i][j]-'0';
					row[i][num-1]=1; 
					column[j][num-1]=1; 
					block[3*(i/3)+j/3][num-1]=1;
				}else count++;
		node[][] nodes = new node[9][9];
		for(int i=0;i<9;i++)
			for(int j=0;j<9;j++){
				nodes[i][j] = new node();
			}
		boolean flag;
		while(count>0){
			flag = false;
			for(int i=0;i<9;i++)
				for(int j=0;j<9;j++){
					if(board[i][j]=='.'){
						//读取并修改改点的nodes,若只有一个可用值则确定
						int Rcount = 0;
						for(int k=0;k<nodes[i][j].count;k++){
							int tempnum = nodes[i][j].val[k]-1;		//目前可填写的数值
							if(row[i][tempnum]!=1 && column[j][tempnum]!=1 && block[3*(i/3)+j/3][tempnum]!=1){
								nodes[i][j].val[Rcount] = tempnum+1;				//nodes前count个数存储的是可填写的数字
								Rcount++;
							}
						}
						nodes[i][j].count = Rcount;
						if(nodes[i][j].count==1){			//只有一个可用值
							char ch = (char) ('0'+nodes[i][j].val[0]);
							board[i][j] = ch;
							flag = true;					//本轮有变化
							count--;						//不确定的格子数减一
							//更新ROW,COLUMN,BLOCK信息
							row[i][nodes[i][j].val[0]-1] = 1;
							column[j][nodes[i][j].val[0]-1] = 1;
							block[3*(i/3)+j/3][nodes[i][j].val[0]-1] = 1;
						}
					}
				}
			if(!flag){			//本轮没变化，需要开始猜
				break;
			}
		}
		if(count!=0){
			solve(board,nodes);		//回溯求解
		}
	}
	public static boolean solve(char[][] board,node[][] nodes){
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				if(board[i][j]=='.'){
					for(int k=0;k<nodes[i][j].count;k++){		//把可用节点一次进行尝试
						board[i][j] = (char) ('0'+nodes[i][j].val[k]);		//先考虑这么填，在判断是否合法
//						disp(board);
						if(Valid(board)){
							if(solve(board,nodes))
								return true;
							else{
								board[i][j] = '.';
//								disp(board);
							}
						}
						board[i][j] = '.';
					}
					return false;
				}
			}                      
		}
		return true;
	}
	
	public static boolean Valid(char[][] board){
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
	public static void disp(char[][] table){
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				System.out.print(table[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
class node{
	int count;
	int[] val;		// 暂定可以填的值
	public node(){			//初始化时，9个值都可以填写
		count = 9;
		val = new int[9];
		for(int i=0;i<9;i++){
			val[i] = i+1;
		}
	}
}

