/*You are given the head of a linked list and the number k, You have to return the kth node from the end of linkedList. If k is more than the number of nodes, then the return -1.

Examples

Input: LinkedList: 1->2->3->4->5->6->7->8->9, k = 2
Output: 8
Explanation: The given linked list is 1->2->3->4->5->6->7->8->9. The 2nd node from end is 8.

Input: LinkedList: 10->5->100->5, k = 5
Output: -1
Explanation: The given linked list is 10->5->100->5. Since 'k' is more than the number of nodes, the output is -1.

Constraints:
1 ≤ number of nodes ≤ 106
1 ≤ node->data , x ≤ 106
1 ≤ k ≤ 106 */

/* Structure of node
class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
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
    // Function to find the data of kth node from
    // the end of a linked list.
    static int getKthFromLast(Node head, int k) {
        // Your code here
        int len = 0;
        Node temp = head;
        while(temp!=null){
            len++;
            temp=temp.next;
        }
        int pos = len-k+1;
        temp=head;
        int count = 0;
        while(temp!=null){
            count++;
            if(count==pos)return temp.data;
            temp=temp.next;
        }
        return -1;
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
        
        System.out.println("Enter the kth node from end you want: ");
        int k = sc.nextInt();

        System.out.println("Kth from the last is: "+getKthFromLast(head, k));

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