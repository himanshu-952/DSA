public class GridWays {

    public static int gridways(int row , int col , int i , int j){
   
    if(i==row-1 && j==col-1){
        return 1;
    }
    if(i>=row || j>=col){
        return 0 ;
    }
   
    int right= gridways(row, col, i, j+1);
    int down = gridways(row, col, i+1, j);

    return down+right;
       
    }

    public static void main(String[] args) {
        System.out.println(gridways(4, 5, 0, 0));
    }
}
