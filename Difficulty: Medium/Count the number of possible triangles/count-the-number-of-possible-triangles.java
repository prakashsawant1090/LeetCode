//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            System.out.println(new Solution().countTriangles(arr));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to count the number of possible triangles.
    static int countTriangles(int arr[]) {
        int cnt = 0; 
        Arrays.sort(arr);
        if(arr.length<3) return 0;
        
        int l=0,m=1,r=2;
        while(l<=arr.length - 3){
            m=l+1;r=m+1;
            
            while(m<arr.length-1){
                r = m+1;
                while(r<arr.length){
                    if(arr[l]+arr[m] > arr[r]) cnt++;
                    r++;
                }
                m++;
            }
            l++;
            
        }
        
        
        return cnt;
        
        
    }
}