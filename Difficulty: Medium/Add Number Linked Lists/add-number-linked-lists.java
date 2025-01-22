//{ Driver Code Starts
// driver

import java.io.*;
import java.util.*;


// } Driver Code Ends
/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution {
    static Node reverse(Node root){
        Node curr = root;
        Node prev = null;
        
        while(curr!=null){
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
    
    static Node removeZero(Node root){
        Node temp = root;
        
        while(temp!=null){
            if(temp.data!=0) return temp;
            temp =temp.next;
        }
        return temp;
        
    }
    
    static Node addTwoLists(Node num1, Node num2) {
        Node rh1 = removeZero(num1);
        Node rh2 = removeZero(num2);
        Node nh1 = reverse(rh1);
        Node nh2 = reverse(rh2);
        Node sumtail = null;
        Node sumhead = null;
        int carry = 0;
        while(nh1!= null && nh2 !=null){
            int sum = nh1.data + nh2.data + carry;
            Node temp = new Node(sum %10);
            carry = sum/10;
            if(sumhead == null){
              sumhead = temp;
              sumtail = sumhead;
            }
            else {
                sumtail.next = temp;
                sumtail = temp;
            }
            
            nh1 = nh1.next;
            nh2 = nh2.next;
        }
        
        while(nh1!=null){
            int sum = nh1.data  + carry;
            Node temp = new Node(sum %10);
            carry = sum/10;
            sumtail.next = temp;
            sumtail = temp;
            nh1 = nh1.next;
        }
        while(nh2!=null){
            int sum = nh2.data  + carry;
            Node temp = new Node(sum %10);
            carry = sum/10;
            sumtail.next = temp;
            sumtail = temp;
            nh2 = nh2.next;
        }
        
        
        if(carry!=0){
             Node temp = new Node(carry);
             sumtail.next = temp;
        }
        
        
        return reverse(sumhead);
        // return nh2;
    }
}

//{ Driver Code Starts.

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG {

    static void printList(Node n) {
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(read.readLine());
        while (T-- > 0) {

            String str[] = read.readLine().trim().split(" ");
            int n = str.length;

            Node num1 = new Node(Integer.parseInt(str[0]));
            Node tail = num1;
            for (int i = 1; i < n; i++) {
                int val = Integer.parseInt(str[i]);
                tail.next = new Node(val);
                tail = tail.next;
            }

            String str2[] = read.readLine().trim().split(" ");
            int m = str2.length;

            Node num2 = new Node(Integer.parseInt(str2[0]));
            tail = num2;
            for (int i = 1; i < m; i++) {

                tail.next = new Node(Integer.parseInt(str2[i]));
                tail = tail.next;
            }

            Solution g = new Solution();
            Node res = g.addTwoLists(num1, num2);
            printList(res);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends