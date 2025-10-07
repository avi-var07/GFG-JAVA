/*You are given the head of a linked list, You have to return the value of the middle node of the linked list.

If the number of nodes is odd, return the middle node value.
If the number of nodes is even, there are two middle nodes, so return the second middle node value.
Examples:

Input: 
   
Output: 3
Explanation: The given linked list is 1->2->3->4->5 and its middle is 3.
   
Input:
   
Output: 7 
Explanation: The given linked list is 2->4->6->7->5->1 so, there are two middle node 6 and 7, return the second middle node as 7.
   
Constraints:
1 ≤ no. of nodes ≤ 105
1 ≤ node->data ≤ 105 */


/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
} */


import java.util.Scanner;

class Node{
    int data;
    Node next;

    Node(int data){
        this.data=data;
        this.next=null;
    }
}
class Solution {
    static int getMiddle(Node head) {
        // code here
        int len = 0;
        Node temp = head;
        while(temp!=null){
            len++;
            temp = temp.next;
        }
        temp = head;
        
        for(int i=1;i<=len/2;i++)temp=temp.next;
        
        return temp.data;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter "+n+" elements: ");
        int headValue = sc.nextInt();

        Node head = new Node(headValue);
        Node current = head;

        for(int i=1;i<n;i++){
            int val = sc.nextInt();
            Node temp = new  Node(val);
            current.next=temp;
            current = temp;
        }
       

       System.out.println("Element present at the middle of the linked list is: "+getMiddle(head));


       sc.close();
    }
    static void print(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }
}