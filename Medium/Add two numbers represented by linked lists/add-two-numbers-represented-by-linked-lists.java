//{ Driver Code Starts
// driver

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
        if(root==null) return null;
        Node nxt=null,curr=root,prev=null;
        
        while(curr!=null){
            nxt=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nxt;
        }
        return prev;
    }
    
    static Node addTwolist(Node head1,Node head2){
        Node rev1 = reverse(head1);
        Node rev2 = reverse(head2);
          if(rev1==null && rev2==null)  return new Node(0);
        if(rev1==null) return reverse(rev2);
        if(rev2==null) return reverse(rev1);
        // System.out.println(rev1+" *"+rev2);
         int carry = 0;
        int val = carry + rev1.data+rev2.data;
        Node nhead = new Node(val%10);
        carry =  val/10;
       
        
        Node end = nhead;
        rev1=rev1.next;
        rev2=rev2.next;
        
        while(rev1!= null ||  rev2!=null){
            val=carry;
            if(rev1!=null){
                val+=rev1.data;
                rev1=rev1.next;
            }
               if(rev2!=null){
                val+=rev2.data;
                rev2=rev2.next;
            }
        //   val = carry + rev1.data+rev2.data;  
         Node curr =  new Node(val%10);
          end.next = curr;
          carry = val/10;
          end = curr;
          
        }
        
        
        if(carry!=0){
            end.next = new Node(carry);
        }
        
        return reverse(nhead);
    }
    
    
    static Node addTwoLists(Node num1, Node num2) {
        
        Node temp =num1;
        while(temp!=null && temp.data==0) temp=temp.next;
        num1=temp;
        
        temp=num2;
        while(temp!=null && temp.data==0) temp=temp.next;
        num2=temp;
        return addTwolist(num1,num2);
        
      
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {

            int n = sc.nextInt();
            int val = sc.nextInt();

            Node num1 = new Node(val);
            Node tail = num1;
            for (int i = 0; i < n - 1; i++) {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }

            int m = sc.nextInt();
            val = sc.nextInt();

            Node num2 = new Node(val);
            tail = num2;
            for (int i = 0; i < m - 1; i++) {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }

            Solution g = new Solution();
            Node res = g.addTwoLists(num1, num2);
            printList(res);
        }
    }
}

// } Driver Code Ends