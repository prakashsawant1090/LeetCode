//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.HashMap;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            ArrayList<Integer> array = new ArrayList<>();

            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int k = Integer.parseInt(br.readLine());

            ArrayList<Integer> ans = new Solution().countDistinct(arr, k);

            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();

            t--;
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
       ArrayList<Integer> ans = new ArrayList<>();
       int left=0,right=k-1;
       HashMap<Integer,Integer> map = new HashMap<>();
       for(int i=0;i<k;i++) map.put(arr[i],map.getOrDefault(arr[i],0)+1);
       
       while(right<arr.length){
           ans.add(map.size());
           
           if(map.get(arr[left])==1) map.remove(arr[left]);
           else map.put(arr[left],map.get(arr[left])-1);
           right++;
           if(right>=arr.length) break;
           map.put(arr[right],map.getOrDefault(arr[right],0)+1);
           left++;
           
       }
       
       return ans;
    }
}
