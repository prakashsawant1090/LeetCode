class Solution {
    boolean ispeak(int [][]mat,int x,int y){
        int r = mat.length;
        int c = mat[0].length;
        
        if(y-1 >=0 && mat[x][y-1]>mat[x][y]) return false;
        if(y+1<c && mat[x][y+1]>mat[x][y]) return false;
        if(x-1 >=0 && mat[x-1][y]>mat[x][y]) return false;
        if(x+1< r  && mat[x+1][y]>mat[x][y]) return false;

        return true;

    }
    public int[] findPeakGrid(int[][] mat) {
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(ispeak(mat,i,j)) return new int[]{i,j};
            }
        }

        return new int[]{1,1};
    }
}