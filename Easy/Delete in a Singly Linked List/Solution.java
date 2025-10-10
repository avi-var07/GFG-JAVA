/*You are given the head of a singly linked list and an integer x. Delete the xth node (1-based indexing) from the singly linked list.

Examples:

Input: x = 1,
    
Output: 2 -> 3 -> 1 -> 7
Explanation: After deleting the node at the 1st position (1-base indexing), the linked list is as
    
Input: x = 5,
    
Output: 2 -> 3 -> 4 -> 5
Explanation: After deleting the node at 5th position (1-based indexing), the linked list is as
    
Constraints:
1 ≤ size of linked list ≤ 105
1 ≤ x ≤ size of linked list */



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
        
        Node head = convertToLinkedList(arr);

        print(head);
        System.out.println();

        System.out.println("Enter the position to delete: ");
        int k = sc.nextInt();

        head = deleteNode(head, k);
        print(head);
        
        sc.close();
    }
    static Node convertToLinkedList(int arr[]){
        Node head = new Node(arr[0]);

        Node current = head;
        for(int i=1;i<arr.length;i++){
            Node temp = new Node(arr[i]);
            current.next=temp;
            current = temp;
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
    static Node deleteNode(Node head, int x) {
        // code here
        if(head==null||head.next==null){
            if(x==1)return null;
        }
        if(x==1){
            Node temp = head;
            head=head.next;
            temp.next=null;
            return head;
        }
        Node temp = head;
        int count=0;
        while(temp.next!=null){
            count++;
            if(count==x-1)break;
            temp=temp.next;
        }
        Node prev = temp;
        prev.next=prev.next.next;
        return head;
    }
}