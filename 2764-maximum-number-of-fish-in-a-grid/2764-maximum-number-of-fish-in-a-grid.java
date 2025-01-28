class Solution {
        public int dfs(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0) {
            return 0;
        }

        int fishcnt = grid[x][y];
        grid[x][y] = 0; 
        fishcnt += dfs(grid, x + 1, y); // down
        fishcnt += dfs(grid, x - 1, y); // up
        fishcnt += dfs(grid, x, y + 1); // right
        fishcnt += dfs(grid, x, y - 1); // left

        return fishcnt;
    }

    public int findMaxFish(int[][] grid) {
        int maxi = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    maxi = Math.max(maxi, dfs(grid, i, j));
                }
            }
        }

        return maxi;
    }
}
