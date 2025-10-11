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
        System.out.println("After deleting middle: ");
        head = deleteMid(head);
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
    static Node deleteMid(Node head) {
        // This is method only submission.
        // You only need to complete the method.
        if(head==null||head.next==null)return null;
        Node slow = head;
        Node fast = head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast = fast.next.next;
        }
        Node temp = head;
        while(temp.next!=slow)temp=temp.next;
        
        temp.next=slow.next;
        
        return head;
    }
}