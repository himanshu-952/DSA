public class FloodFill {

    public static void helper(int [][] image , int row , int col , int color , int ogcol , boolean visited[][]){

        if(row<0 || col<0 || row>=image.length || col>=image[0].length || visited[row][col] || image[row][col]!=ogcol){
return;
        }
         

         image[row][col]=color;
         visited[row][col]=true;

         helper(image, row, col-1, color, ogcol, visited);
         helper(image, row, col+1, color, ogcol, visited);
         helper(image, row+1, col, color, ogcol, visited);
         helper(image, row-1, col, color, ogcol, visited);

    }

    

    public static void ff(int [][] image , int row , int col , int color){

        boolean visited[][]= new boolean[image.length][image[0].length];
        helper(image, row, col, color, image[row][col] , visited);

    }

    public static void main(String[] args) {
        
    }
}
