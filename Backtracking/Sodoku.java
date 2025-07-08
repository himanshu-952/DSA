public class Sodoku {

    public static void SodokuSolver(int [][] board , int row , int col){

        if(row==board.length){
       print(board);
       System.exit(0);
        }
     int nextrow=row , nextcol=col+1;
     if(nextcol==board.length){
        nextrow=row+1;
        nextcol=0;
     }
     if(board[row][col]!=0){
        SodokuSolver(board, nextrow, nextcol);
        return ;
     }

     for(int i=1 ; i<10 ; i++){

        if(cheaker(board, i, row, col)){
            board[row][col]=i;
            SodokuSolver(board, nextrow, nextcol);
            board[row][col]=0; 
        }
        
     }

    }

    public static void print(int arr[][]){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static boolean cheaker(int [][] board,int no , int row , int col ){

        
        // check 3x3 grid
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if(board[i][j] == no){
                    return false;
                }
            }
        }
        
        //row
        for (int i = 0; i < board.length; i++) {
            if(board[i][col]==no){
                return false;
            }
        }
        //col
        for (int i = 0; i < board.length; i++) {
            if(board[row][i]==no){
                return false;

            }
            
        }
        return true;

    }

    public static void main(String[] args) {
        int[][] sudokuBoard = {
            {5, 1, 7, 6, 0, 0, 0, 3, 4},
            {2, 8, 9, 0, 0, 4, 0, 0, 0},
            {3, 4, 6, 2, 0, 5, 0, 9, 0},
            {6, 0, 2, 0, 0, 0, 0, 1, 0},
            {0, 3, 8, 0, 0, 6, 0, 4, 7},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 9, 0, 0, 0, 0, 0, 7, 8},
            {7, 0, 3, 4, 0, 0, 5, 6, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        SodokuSolver(sudokuBoard, 0, 0);
    }
}
