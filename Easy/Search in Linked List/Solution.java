/*Given a linked list with the head node and a key, the task is to check if the key is present in the linked list or not. Return true if key is present, else return false.

Example:

Input: key = 3,
      
Output: true
Explanation: 3 is present in Linked List.

Input: key = 4,
   
Output: false
Explanation: 4 is not present in Linked List.

Constraint:
1 ≤ Number of nodes ≤ 105
1 ≤ node.data, key ≤ 105 */

import java.util.*;

class Node{
    int data;
    Node next;

    Node(int data){
        this.data=data;
        this.next = null;
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
        
        Node head = convert(arr);

        System.out.println("Enter value to search: ");
        int key = sc.nextInt();

        System.out.println(searchKey(head, key));
        
        sc.close();
    }
    static Node convert(int arr[]){
        Node head = new Node(arr[0]);
        Node current = head;
        for(int i=1;i<arr.length;i++){
            Node temp = new Node(arr[i]);
            current.next = temp;
            current = temp;
        }
        return head; 
    }
    public static boolean searchKey(Node head, int key) {
        // Code here
        Node temp = head;
        while(temp!=null){
            if(temp.data==key)return true;
            temp=temp.next;
        }
        return false;
    }
}