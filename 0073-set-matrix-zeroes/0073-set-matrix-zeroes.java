class Solution {
    static void setrowcolzero(int [][]matrix,int rn,int cn){
        for(int i=0;i<matrix[0].length;i++){
            matrix[rn][i] = 0;
        }

        for(int i=0;i<matrix.length;i++){
            matrix[i][cn] = 0;
        }
    }

    public void setZeroes(int[][] matrix) {
        ArrayList<int[]> pos = new ArrayList<>();
        int r = matrix.length;
        int c = matrix[0].length;

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(matrix[i][j] == 0) pos.add(new int[]{i,j});
            }
        }

        for(int i=0;i<pos.size();i++){
            int curr[] = pos.get(i);

            // System.out.println("i= "+curr[0]+"  j = "+curr[1]);
            setrowcolzero(matrix,curr[0],curr[1]);
        }
    }
}