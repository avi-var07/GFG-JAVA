/*
class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
*/ 


/*You are given the head of a doubly linked list. You have to reverse the doubly linked list and return its head.

Examples:

Input:
   
Output: 5 <-> 4 <-> 3
Explanation: After reversing the given doubly linked list the new list will be 5 <-> 4 <-> 3.
   
Input: 
   
Output: 196 <-> 59 <-> 122 <-> 75
Explanation: After reversing the given doubly linked list the new list will be 196 <-> 59 <-> 122 <-> 75.
   
Constraints:
1 ≤ number of nodes ≤ 106
0 ≤ node->data ≤ 104 */

import java.util.Scanner;
class Node{
    Node next;
    Node prev;
    int data;

    Node(int data){
        this.data=data;
        this.next=null;
        this.prev=null;
    }
}
class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter "+n+" elements: ");
        int headVal = sc.nextInt();

        Node head = new Node(headVal);
        Node current = head;
        for(int i=1;i<n;i++){
            int ele = sc.nextInt();
            Node temp = new Node(ele);
            current.next=temp;
            temp.prev = current;

            current = temp;

        }

        System.out.println("Original: ");
        print(head);

        System.out.println();

        head = reverse(head);
        System.out.println("Reversed: ");
        print(head);

        sc.close();
    }
    static void print(Node head){
        Node temp = head;
        while(temp!=null){

            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }
    public static Node reverse(Node head) {
        // code here
        
        if(head==null||head.next==null)return head;
        Node current = head;
        Node last = null;
        while(current!=null){
            last = current.prev;
            current.prev = current.next;
            current.next=last;
            
            current = current.prev;
        }
        return last.prev;
    }
}