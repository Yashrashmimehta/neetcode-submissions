class Solution {
    public int numIslands(char[][] grid) {
         int m = grid.length;
        int n = grid[0].length;

        int islands  = 0;

        for(int i=0;i<m;i++){
            for(int j = 0;j<n;j++){
            if(grid[i][j] == '1'){
                islands++;
                bfs(i,j,grid);
            }
        }
        }
        return islands;


    }
    private static void bfs(int r,int c,char[][]grid){
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c});
  
        grid[r][c] = '0';
        int[] delrow = {-1,1,0,0};
        int[] delcol = {0,0,-1,1};
        while(!q.isEmpty()){
            int []curr = q.poll();

            int currow = curr[0];
            int curcol = curr[1];

            for(int k=0;k<4;k++ ){
            int nrow = currow + delrow[k];
            int ncol = curcol + delcol[k];

            if(nrow>=0 && nrow<m && ncol>=0 &&ncol<n && grid[nrow][ncol]=='1'){
                grid[nrow][ncol] = '0';
                q.offer(new int[]{nrow,ncol});
            }
        }


    }
}
}
