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
        System.out.println("After sorting: ");
        head = mergeSort(head);
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
    public static Node mergeSort(Node head) {
        // code here
        if(head==null||head.next==null)return head;
        
        Node middle = tortoiseHare(head);
        Node rightHead = middle.next;
        Node leftHead = head;
        middle.next=null;
        
        leftHead = mergeSort(leftHead);
        rightHead = mergeSort(rightHead);
        
        return merge(leftHead, rightHead);
    }
    static Node tortoiseHare(Node head){
        Node slow = head;
        Node fast = head;
        while(fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    static Node merge(Node firstHead, Node secondHead){
        Node dummyNode = new Node(-1);
        Node temp = dummyNode;
        Node t1=firstHead;
        Node t2 = secondHead;
        
        while(t1!=null&&t2!=null){
            if(t1.data<t2.data){
                temp.next=t1;
                temp=temp.next;
                t1=t1.next;
            }
            else{
                temp.next=t2;
                t2=t2.next;
                temp=temp.next;
            }
        }
        if(t1!=null)temp.next=t1;
        else temp.next=t2;
        
        return dummyNode.next;
    }
}