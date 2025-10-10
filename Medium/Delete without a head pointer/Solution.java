/*You are given a node del_node of a Singly Linked List where you have to delete this given node from the linked list but you are not given the head of the list.

After deleting the given node:

The number of nodes in the linked list should decrease by one.
All the values before & after the del_node node should be in the same order.
Note: It is guaranteed that there exists a node with a value equal to the del_node value and it will not be the last node of the linked list.

Examples:

Input: Linked List = 1 -> 2, del_node = 1
Output: 2
Explanation: After deleting 1 from the linked list, we have remaining nodes as 2.
 
Input: Linked List = 10 -> 20 -> 4 -> 30, del_node = 20
Output: 10->4->30
Explanation: After deleting 20 from the linked list, we have remaining nodes as 10, 4, 30.

Constraints:
2 ≤ number of nodes ≤ 106  
1 ≤ node->data ≤ 106 */



import java.util.Scanner;
class Node{
    Node next;
    int data;

    Node(int data){
        this.data = data;
        this.next=null;
    }
}
class Solution {
    public static void deleteNode(Node del_node) {
        // code here
        del_node.data=del_node.next.data;
        del_node.next = del_node.next.next;
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter length of the LinkedList: ");

        int n = sc.nextInt();

        System.out.println("Enter "+n+ " elements of the LinkedList: ");
        int val = sc.nextInt();
        Node head = new Node(val);
        Node current = head;
        for(int i=1;i<n;i++){
            int ele = sc.nextInt();
            Node newNode = new Node(ele);
            newNode.next = null;
            current.next = newNode;
            current = newNode;
        }

        System.out.println("Enter node to delete: ");
        int nodeValue = sc.nextInt();
        
        Node node = findNode(head, nodeValue);


        deleteNode(node);

        print(head);
        
        sc.close();

    }
    static Node findNode(Node head, int val){
        Node temp = head;
        while(temp!=null &&temp.next!=null){
            if(temp.data==val)return temp; //kyuli last node ko delete nhi krskte leetCode mei condition mei
            temp=temp.next;
        }
        return null;
    }
    static void print(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+"  ");
            temp=temp.next;
        }
    }
}