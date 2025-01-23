//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      int a[] = new int[n];
      for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
      }
      Solution obj = new Solution();
      int ans[] = obj.replaceWithRank(a,n);
      for(int e : ans)
      System.out.print(e+" ");
      System.out.println();
    
System.out.println("~");
}
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    static int[] replaceWithRank(int arr[], int n) {
     int[] ans = new int[n];
     int[] sortedArr = arr.clone();  
        Arrays.sort(sortedArr);  
        
        HashMap<Integer, Integer> rankMap = new HashMap<>();
        int rank = 1;
        
        for (int x : sortedArr) {
            if (!rankMap.containsKey(x)) {  // Avoid duplicate elements
                rankMap.put(x, rank++);
            }
        }
        
        // Replace original array elements with their ranks
        for (int i = 0; i < n; i++) {
            ans[i] = rankMap.get(arr[i]);
        }
        
        return ans;

  }
}
     