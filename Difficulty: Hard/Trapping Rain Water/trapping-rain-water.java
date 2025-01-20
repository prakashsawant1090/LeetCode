//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().maxWater(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int maxWater(int arr[]) {
        int n  = arr.length;
        int left[] = new int[n];
        int right[] = new int[n];
        
        int ans = 0;
        int lmax = arr[0];
        int rmax = arr[n-1];
        for(int i =0 ;i<n ;i++){
            lmax = Math.max(lmax , arr[i]);
            // System.out.println("right = "+(n-1-i));
            rmax = Math.max(rmax,arr[n-1-i]);
            right[n-1-i] = rmax;
            left[i] = lmax;
        }
        
        //for(int i=0;i<n;i++) System.out.println("left "+left[i]+" right "+right[i]);
        for(int i=0;i<n;i++){
            ans+= Math.max(Math.min(left[i],right[i]) - arr[i],0);
            // System.out.println("ans = "+ans);
        }
        
        return ans;
    }
}
