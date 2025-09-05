package Graphs;

public class NoOfIslands {
    class Solution {
    public int numIslands(char[][] grid) {
        int islands=0;
        int[][] dirs={{0,1},{1,0},{-1,0},{0,-1}};
        boolean[][] visited= new boolean[grid.length][grid[0].length];
        for(int i=0 ; i<grid.length ; i++){
            for(int j=0 ; j<grid[0].length;j++){
                if(!visited[i][j] && grid[i][j]=='1'){
                    dfs(grid , i , j ,visited , dirs);
                    islands++;
                }
            }
        }
        return islands;
    }
    public void dfs(char[][] grid , int r , int c , boolean[][] visited, int[][] dirs){
         visited[r][c]=true;
         for(int[]dir:dirs){
            int nr=dir[0]+r;
            int nc=dir[1]+c;
            if(nr>=0&&nr<grid.length && nc>=0&& nc<grid[0].length && grid[nr][nc]=='1'&& !visited[nr][nc]){
                dfs(grid,nr, nc , visited , dirs );
            }
         }
    }
}
}
