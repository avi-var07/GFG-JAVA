/*Given a link list, modify the list such that all the even numbers appear before all the odd numbers in the modified list. The order of appearance of numbers within each segregation should be the same as that in the original list.

NOTE: Don't create a new linked list, instead rearrange the provided one.

Examples:

Input: Linked list: 17->15->8->9->2->4->6
Output: 8->2->4->6->17->15->9

Explaination: 8,2,4,6 are the even numbers so they appear first and 17,15,9 are odd numbers that appear later.
Input: Linked List: 1 -> 3 -> 5 -> 7
Output: 1->3->5->7

Explaination: There is no even number. So no need for modification.
Constraints:
1 ≤ size of linked list ≤ 105
1 ≤ Each element of the list ≤ 105

 */


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

        head = divide(head);

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

    static Node divide(Node head) {
        // code here
        Node startEven=null, endEven=null;
        Node startOdd=null, endOdd = null;
        Node current = head;
        
        while(current!=null){
            if(current.data%2==0){//even
                if(startEven==null){
                    startEven=current;
                    endEven = startEven;
                }
                else{
                    endEven.next=current;
                    endEven=current;
                }
            }
            else{
                if(startOdd==null){
                    startOdd = current;
                    endOdd  =  startOdd;
                }
                else{
                    endOdd.next = current;
                    endOdd = current;
                }
            }
            current = current.next;
        }
        
    
        if(startEven==null)return startOdd;
        if(startOdd==null)return startEven;
        
        endEven.next = startOdd;
        endOdd.next=null;
        return startEven;
    }
}