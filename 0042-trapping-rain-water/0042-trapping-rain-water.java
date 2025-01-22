class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int cnt=0;
        int lgreater[] = new int[n];
        int rgreater[] = new int[n];
        int lmax = height[0];
        int rmax = height[n-1];

        for(int i=0;i<n;i++){
            if(height[i] > lmax) lmax = height[i];
            if(height[n-1-i]>rmax) rmax=height[n-1-i];
            lgreater[i] = lmax;
            rgreater[n-1-i] = rmax;
        }

        for(int i=0;i<n;i++){
            cnt += Math.max(Math.min(lgreater[i],rgreater[i]) - height[i],0);
        }


        return cnt;
    }
}