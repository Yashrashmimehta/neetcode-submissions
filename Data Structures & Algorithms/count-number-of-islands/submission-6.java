class Solution {

    public int numIslands(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int islands = 0;

        for(int i = 0; i < m; i++) {

            for(int j = 0; j < n; j++) {

                if(grid[i][j] == '1') {

                    islands++;

                    dfs(i, j, grid);
                }
            }
        }

        return islands;
    }

    private static void dfs(int r, int c, char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        // Boundary + water check
        if(r < 0 || c < 0 || r >= m || c >= n || grid[r][c] == '0') {
            return;
        }

        // Mark visited
        grid[r][c] = '0';

        // Visit 4 directions
        dfs(r - 1, c, grid); // up
        dfs(r + 1, c, grid); // down
        dfs(r, c - 1, grid); // left
        dfs(r, c + 1, grid); // right
    }
}