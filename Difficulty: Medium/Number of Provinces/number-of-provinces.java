//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    
    static void dfs(ArrayList<ArrayList<Integer>> adj,boolean visited[],int curr){
        visited[curr] = true;
        
        for(int x=0;x<adj.size();x++) {
            if(adj.get(curr).get(x)==1 && visited[x]==false){
                dfs(adj,visited,x);
            }
        }
    }
    
    
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
       int ans =0;
       boolean visited[] = new boolean[V];
       
      for(int i=0;i<V;i++){
          if(visited[i]==false) {
              ans++;
              dfs(adj,visited,i);
          }
      }
    
    // for(int i=0;i<adj.get(0).size();i++){
    //     System.out.print(adj.get(0).get(i)+" ");
    // }
       
       return ans;
    }
};