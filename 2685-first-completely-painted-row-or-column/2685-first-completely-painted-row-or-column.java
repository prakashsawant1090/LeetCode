class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        HashMap<Integer,int [] > map = new HashMap<>();
        int r = mat.length;
        int c  = mat[0].length;
        int [] row = new int[r];
        int col[] = new int[c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                map.put(mat[i][j],new int[]{i,j});
            }
        }

        for(int i=0;i<arr.length;i++){
            int [] curr = map.get(arr[i]);
            row[curr[0]]++;
            col[curr[1]]++;
            if(row[curr[0]] == c || col[curr[1]] == r) return i;
        }

        return -1;
    }
}