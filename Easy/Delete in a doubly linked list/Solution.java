/*You are given a Doubly Linked List and an integer x. Remove the node at position x (positions are 1-indexed) from the list, and return the head of the updated list.

Examples:

Input: x = 3,
   
Output: 1 <-> 3
Explanation: After deleting the node at position 3 (position starts from 1), the updated linked list is 1 <-> 3.
   
Input: x = 1,
   
Output: 5 <-> 2 <-> 9
Explanation: After deleting the node at position 1, the updated linked list is 5 <-> 2 <-> 9.
   
Constraints:
1 ≤ x ≤ size of the linked list ≤ 106
0 ≤ node->data ≤ 104 */

import java.util.*;

class Node{
    int data;
    Node next;
    Node prev;

    Node(int data){
        this.data=data;
        this.next = null;
        this.prev=null;
    }
}

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements: ");
        int n = sc.nextInt();
        System.out.println("Enter " + n + " elements:");
        int arr[] = new int[n];
        for(int i = 0; i < n; i++) 
        arr[i] = sc.nextInt();
        
        Node head = convertToLinkedList(arr);

        print(head);
        System.out.println();

        System.out.println("Enter the position to delete: ");
        int k = sc.nextInt();

        head = delPos(head, k);
        print(head);
        
        sc.close();
    }
    static Node convertToLinkedList(int arr[]){
        Node head = new Node(arr[0]);

        Node previous = head;
        for(int i=1;i<arr.length;i++){
            Node temp = new Node(arr[i]);
            temp.prev = previous;
            previous.next=temp;
            previous = temp;
        }
        return head;
    }
    static void print(Node head){
        Node temp  = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }
    static public Node delPos(Node head, int x) {
        // code here
        
        Node temp = head;
        int count=0;
        while(temp!=null){
            count++;
            if(count==x)break;
            temp=temp.next;
        }
        Node back = temp.prev;
        Node front  = temp.next;
        if(back==null&&front==null)return null;
        
        if(back==null){
            head=head.next;
            temp.next=null;
            head.prev=null;
            
            return head;
        }
        if(front==null){
            back.next=null;
            temp.prev=null;
            return head;
        }
        
        back.next=temp.next;
        front.prev=temp.prev;
        temp.prev=null;
        temp.next=null;
        return head;
    }
}