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


// User function Template for Java

class Solution {

    public int maxWater(int arr[]) {
        int max = Integer.MIN_VALUE;
        int l = 0,n = arr.length,r=arr.length-1;
        
        while(l<r){
          int b = r-l;
          int h = Math.min(arr[l],arr[r]);
          max = Math.max(max,b*h);
          if(arr[l]<arr[r]) l++;
          else r--;
        }
        
        
        if(max == Integer.MIN_VALUE )  return 0;
        return max;
    }
}