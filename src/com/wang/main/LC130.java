package com.wang.main;

public class LC130 {
	public static void solve(char[][] board) {
        if (board.length == 0){
            return;
        }
        
        int n = board.length;
        int m = board[0].length;
        
        for (int i = 0; i < n; i++){
            if (board[i][0] == '0'){
                dfs(board, i, 0);
            }
            if (board[i][m-1] == '0'){
                dfs(board, i, m-1);
            }
            
        }
        
        for (int i = 0; i < m; i++){
            if (board[0][i] == '0'){
               dfs(board, 0, i); 
            }
            if (board[n-1][i] == '0'){
               dfs(board, n-1, i); 
            }
            
        }
        
        for (int i = 0; i < n; i++){
        	System.out.println(String.valueOf(board[i]));
        }
        
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (board[i][j] == '0'){
                    board[i][j] = 'X';
                }
                else if (board[i][j] == '*'){
                    board[i][j] = '0';
                }
            }
        }
        
    }
    
    public static void dfs(char[][] board, int i, int j){
        if (i < 0 || i > board.length || j < 0 || j > board[0].length){
            return;
        }
        if (board[i][j] == '0'){
            board[i][j] = '*';
        }else{
            return;
        }
        
        if (i > 1 && board[i-1][j] == '0'){
        	dfs(board, i-1, j);
        }
        if (i < board.length-2 && board[i+1][j] == '0'){
        	dfs(board, i+1, j);
        }
        if (j > 1 && board[i][j-1] == '0'){
        	dfs(board, i, j-1);
        }
        if (j < board[0].length-2 && board[i][j+1] == '0'){
        	dfs(board, i, j+1);
        }
        
        
    }
}
