/*Given Pointer/Reference to the head of a doubly linked list, the task is to Sort the given doubly linked list using Merge Sort in both non-decreasing and non-increasing order.

Note: Return the head of the sorted non-decreasing doubly linked list. The driver code will print it forward and backward in both directions.

Examples:

Input: LinkedList: 7 ↔ 3 ↔ 5 ↔ 2 ↔ 6 ↔ 4 ↔ 1 ↔ 8
Output:
LinkedList: 1 ↔ 2 ↔ 3 ↔ 4 ↔ 5 ↔ 6 ↔ 7 ↔ 8
LinkedList: 8 ↔ 7 ↔ 6 ↔ 5 ↔ 4 ↔ 3 ↔ 2 ↔ 1
Explanation: After sorting the given linked list in both ways, the resultant matrix will be as shown in the first two lines of the output. The first line shows the output for non-decreasing order, and the next line shows the output for non-increasing order.

Input: LinkedList: 9 ↔ 15 ↔ 0 ↔ -1 ↔ 0
Output:
LinkedList: -1 ↔ 0 ↔ 0 ↔ 9 ↔ 15
LinkedList: 15 ↔ 9 ↔ 0 ↔ 0 ↔ -1
Explanation: After sorting the given linked list in both ways, the resultant list will be -1 → 0 → 0 → 9 → 15 in non-decreasing order and 15 → 9 → 0 → 0 → -1 in non-increasing order.

Constraints:
1 <= number of nodes <= 105
-105 <= node->data <= 105 */

import java.util.Scanner;
class DLLNode{
    DLLNode next;
    DLLNode prev;
    int data;

    DLLNode(int data){
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

        DLLNode head = new DLLNode(headVal);
        DLLNode current = head;
        for(int i=1;i<n;i++){
            int ele = sc.nextInt();
            DLLNode temp = new DLLNode(ele);
            current.next=temp;
            temp.prev = current;

            current = temp;

        }

        System.out.println("Original: ");
        print(head);

        System.out.println();

        head=sortDoubly(head);
        print(head);
        sc.close();
    }
    static void print(DLLNode head){
        DLLNode temp = head;
        while(temp!=null){

            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }
    static DLLNode sortDoubly(DLLNode node){
        if(node==null||node.next==null)return node;
        DLLNode middle = tortoiseHare(node);
        DLLNode rightHead = middle.next;
        DLLNode leftHead = node;
        middle.next=null;
        rightHead.prev = null;

        leftHead = sortDoubly(leftHead);
        rightHead = sortDoubly(rightHead);

        return merge(leftHead, rightHead);
    }
    static DLLNode tortoiseHare(DLLNode head){
        DLLNode slow =head;
        DLLNode fast = head;
        while(fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    static DLLNode merge(DLLNode head1, DLLNode head2){
        DLLNode dummyNode = new DLLNode(-1);
        DLLNode temp  = dummyNode;

        DLLNode t1=head1;
        DLLNode t2 = head2;

        while(t1!=null&&t2!=null){
            if(t1.data<t2.data){
                DLLNode newNode  = new DLLNode(t1.data);
                newNode.prev = temp;
                temp.next=newNode;
                temp=newNode;
                t1=t1.next;
                
            }
            else{
                DLLNode newNode  = new DLLNode(t2.data);
                newNode.prev = temp;
                temp.next=newNode;
                temp=newNode;
                t2=t2.next;

            }
        }
        if(t1!=null){
            temp.next=t1;
            t1.prev=temp;
        }
        else{
            temp.next=t2;
            t2.prev=temp;
        }

        DLLNode front = dummyNode.next;
        front.prev=null;
        dummyNode.next=null;
        
        return front;
    }

}