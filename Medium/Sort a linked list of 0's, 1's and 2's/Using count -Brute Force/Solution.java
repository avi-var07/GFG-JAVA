/*Given the head of a linked list where nodes can contain values 0s, 1s, and 2s only. Your task is to rearrange the list so that all 0s appear at the beginning, followed by all 1s, and all 2s are placed at the end.

Examples:

Input: head = 1 → 2 → 2 → 1 → 2 → 0 → 2 → 2
   
Output: 0 → 1 → 1 → 2 → 2 → 2 → 2 → 2
Explanation: All the 0s are segregated to the left end of the linked list, 2s to the right end of the list, and 1s in between. The final list will be:
   
Input: head = 2 → 2 → 0 → 1
   
Output: 0 → 1 → 2 → 2
Explanation: After arranging all the 0s, 1s and 2s in the given format, the output will be:
   
Constraints:
1 ≤ no. of nodes ≤ 106
0 ≤ node->data ≤ 2 */


import java.util.Scanner;

class Node {
    Node next;
    int data;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter length of the LinkedList: ");
        int n = sc.nextInt();

        System.out.println("Enter " + n + " elements of the LinkedList: ");
        int val = sc.nextInt();
        Node head = new Node(val);
        Node current = head;
        for (int i = 1; i < n; i++) {
            int ele = sc.nextInt();
            Node newNode = new Node(ele);
            newNode.next = null;
            current.next = newNode;
            current = newNode;
        }
        print(head);
        System.out.println();
        head=segregate(head);

        print(head);
        sc.close();
    }
    static void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "  ");
            temp = temp.next;
        }
    }
    public static Node segregate(Node head) {
        // code here
        int count0 = 0, count1=0, count2=0;
        
        Node temp =head;
        while(temp!=null){
            if(temp.data==0)count0++;
            if(temp.data==1)count1++;
            else count2++;
            
            temp=temp.next;
            
        }
        temp=head;
        while(temp!=null){
            if(count0!=0){
                temp.data=0;
                count0--;
            }
            else if(count1!=0){
                temp.data=1;
                count1--;
            }
            else{
                temp.data=2;
                count2--;
            }
            temp=temp.next;
        }
        
        return head;
    }
}