class Pair{
     int row;
    int col;
    int tm;
     Pair(int row, int col,int tm) {
        this.row = row;
        this.col = col;
        this.tm = tm;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int fresh=0;
        int time=0;
        int m = grid.length;
        int n = grid[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j,0));
                }
                if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
         int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().tm;
            q.remove();

            time = Math.max(time,t);

             for (int k = 0; k < 4; k++) {

                int nrow = r + dr[k];
                int ncol = c + dc[k];

                // Valid same-colored neighbour
                if (nrow >= 0 &&
                    nrow < m &&
                    ncol >= 0 &&
                    ncol < n &&
                    grid[nrow][ncol] == 1) {

                    q.add(new Pair(nrow, ncol,t+1));
                    grid[nrow][ncol] = 2;
                    fresh--;
                }

            }
        }
        if(fresh!=0) return -1;
        else return time;

    }
}
