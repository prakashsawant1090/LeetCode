//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            ArrayList<Integer> array1 = new ArrayList<Integer>();
            String line = read.readLine();
            String[] tokens = line.split(" ");
            for (String token : tokens) {
                array1.add(Integer.parseInt(token));
            }
            ArrayList<Integer> v = new ArrayList<Integer>();
            int[] arr = new int[array1.size()];
            int idx = 0;
            for (int i : array1) arr[idx++] = i;

            new Solution().mergeSort(arr, 0, arr.length - 1);

            for (int i = 0; i < arr.length; i++) System.out.print(arr[i] + " ");

            System.out.println();

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    static public void merge(int arr[],int l,int mid,int r){
        if(l>=r) return ; 
        ArrayList<Integer> temp = new ArrayList<>();
        int low =l,high = mid+1;
        
        while(low<=mid && high<=r){
            if(arr[low]<= arr[high]) temp.add(arr[low++]);
            else temp.add(arr[high++]);
        }
        
        while(low<=mid) temp.add(arr[low++]);
        while(high<=r) temp.add(arr[high++]);
        
        for(int i=l;i<=r;i++){
            arr[i] =temp.get(i-l);
        }
        
        
    }

    void mergeSort(int arr[], int l, int r) {
        if(l>=r) return;
        int mid = (l+r)/2;
        mergeSort(arr,l,mid);
        mergeSort(arr,mid+1,r);
        merge(arr,l,mid,r);
    }
}
