//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class Main {
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
        System.out.println("~");
    }

    // Insert node into the list in a sorted manner
    public static Node insertSorted(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null || head.data >= data) {
            newNode.next = head;
            return newNode;
        }

        Node current = head;
        while (current.next != null && current.next.data < data) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;

        return head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine(); // Consume the newline character
        while (T-- > 0) {
            Node head1 = null;
            Node head2 = null;

            // Reading first linked list input
            String input1 = sc.nextLine();
            String[] elems1 = input1.split(" ");
            for (String elem : elems1) {
                head1 = insertSorted(head1, Integer.parseInt(elem));
            }

            // Reading second linked list input
            String input2 = sc.nextLine();
            String[] elems2 = input2.split(" ");
            for (String elem : elems2) {
                head2 = insertSorted(head2, Integer.parseInt(elem));
            }

            // Merging sorted linked lists
            Solution obj = new Solution();
            Node mergedHead = obj.sortedMerge(head1, head2);
            printList(mergedHead); // Print the merged sorted list
        }
        sc.close();
    }
}

// } Driver Code Ends


/*
  Node is defined as
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
*/

class Solution {
    Node sortedMerge(Node head1, Node head2) {
        Node nhead = null ;
        Node prev = null;
        while(head1 != null && head2!=null){
            if(head1.data < head2.data) {
                if(nhead == null) {
                    nhead = head1;
                    prev = head1;
                }
                else{
                    prev.next = head1;
                    prev = head1;
                } 
                head1 = head1.next;
            }
            else {
                if(nhead == null) {
                    nhead = head2;
                    prev = head2;
                }
                else{
                    prev.next = head2;
                    prev = head2;
                } 
                head2 = head2.next;
            }
        }
        
        // if(head1!= null) System.out.println("Head1"+head1.data);
        // if(head2!= null) System.out.println("Head2"+head2.data);
        
        // System.out.println("prev"+prev.data);
        if(head1!=null) {
             prev.next = head1;
        }
        if(head2!=null){
                prev.next = head2;
        }
        
        return nhead;
    }
}
