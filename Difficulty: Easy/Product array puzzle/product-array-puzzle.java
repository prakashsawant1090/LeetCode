//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            Solution ob = new Solution();
            int[] ans = new int[n];
            ans = ob.productExceptSelf(arr);

            for (int i = 0; i < n; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
            System.out.println("~");
            t--;
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public static int[] productExceptSelf(int arr[]) {
        int ans[] = new int[arr.length];
        long prod = 1;
        int zcnt = 0;
        for(int x:arr){
            if(x==0){
                zcnt++;
                if(zcnt>=2) return ans;
            }
            else prod *=x;
            
            
        }
        
        // System.out.println(prod+" "+zcnt);
        
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0) ans[i] = (int)prod;
            else if(zcnt == 1) ans[i] = 0;
            else ans[i] = (int)prod / arr[i];
            

        }
        
        return ans;
        
    }
}
