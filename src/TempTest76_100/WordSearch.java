package TempTest76_100;

public class WordSearch {
	public static void main(String args[]){
		char[][] board={{'A','B','C','E'},
						{'S','F','C','S'},
						{'A','D','E','E'}};
		String word="ASD";
		System.out.println(exist(board,word));
	}
	public static boolean exist(char[][] board, String word) {
        if(word.length()==0)return true;
        if(board.length==0 || board[0].length==0)return false;
        int m,n;
        m=board.length;
        n=board[0].length;
        boolean board2[][]=new boolean[m][n];   //�ж��ַ�ʹ�������Ĭ��false��ʾδʹ��
        char c=word.charAt(0);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==c){
                    board2[i][j]=true;
                    if(recursion(board,board2,word,i,j,0))
                        return true;
                    board2[i][j]=false;
                }
            }
        }
        return false;
    }
    //  i,j��ʾ��嵱ǰλ�ã�n��ʾword��ǰ�Ա�λ�á�board[i][j]=word.charAt(n);
    public static boolean recursion(char[][] board, boolean[][] board2, String word, int i, int j, int n){
        if(n==word.length()-1)return true;        //�������
        //�������αȽ�wordʣ���ַ���
        char c=word.charAt(++n);
        //c��board[i][j]�������������αȽϡ�
        if(i>0 && board[i-1][j]==c && board2[i-1][j]==false){
            board2[i-1][j]=true;
            if(recursion(board,board2,word,i-1,j,n))
                return true;
            board2[i-1][j]=false;
        }
        if(i<board.length-1 && board[i+1][j]==c && board2[i+1][j]==false){
            board2[i+1][j]=true;
            if(recursion(board,board2,word,i+1,j,n))
                return true;
            board2[i+1][j]=false;
        }
        if(j>0 && board[i][j-1]==c && board2[i][j-1]==false){
            board2[i][j-1]=true;
            if(recursion(board,board2,word,i,j-1,n))
                return true;
            board2[i][j-1]=false;
        }
        if(j<board[0].length-1 && board[i][j+1]==c && board2[i][j+1]==false){
            board2[i][j+1]=true;
            if(recursion(board,board2,word,i,j+1,n))
                return true;
            board2[i][j+1]=false;
        }
        return false;
    }
}
