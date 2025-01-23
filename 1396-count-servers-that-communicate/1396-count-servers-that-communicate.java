class Solution {
    public int countServers(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        int rcnt[] = new int[r];
        int ccnt[] = new int [c];
        int tcnt = 0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j] == 1) {
                    rcnt[i]++;
                    ccnt[j]++;
                    tcnt++;
                }
            }
        }

        int isolated = 0;

            for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j] == 1 &&  !(rcnt[i]>=2 || ccnt[j] >=2)) isolated++;
                }}

        return tcnt - isolated;
    }
}