/*
Given the head of two sorted linked lists consisting of nodes respectively. Merge both lists and return the head of the sorted merged list.

Examples:

Input:
  
Output: 2 -> 3 -> 5 -> 10 -> 15 -> 20 -> 40
Explanation:
   
Input:
  
Output: 1 -> 1 -> 2 -> 4
Explanation:
  
Constraints:
1 ≤ list1.size, list2.size ≤ 103
0 ≤ node->data ≤ 105 */

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

        System.out.println("Enter length of the first LinkedList: ");
        int n = sc.nextInt();

        System.out.println("Enter " + n + " elements of the first LinkedList: ");
        int firstVal = sc.nextInt();
        Node firstHead = new Node(firstVal);
        Node current = firstHead;
        for (int i = 1; i < n; i++) {
            int ele = sc.nextInt();
            Node newNode = new Node(ele);
            newNode.next = null;
            current.next = newNode;
            current = newNode;
        }
        print(firstHead);
        System.out.println();
        System.out.println("Enter length of the second LinkedList: ");
        int m = sc.nextInt();

        System.out.println("Enter " + m + " elements of the first LinkedList: ");
        int secondVal = sc.nextInt();
        Node secondHead = new Node(secondVal);
        current = secondHead;
        for (int i = 1; i < m; i++) {
            int ele = sc.nextInt();
            Node newNode = new Node(ele);
            newNode.next = null;
            current.next = newNode;
            current = newNode;
        }
        print(secondHead);
        System.out.println();
        Node head = sortedMerge(firstHead, secondHead);
        System.out.println("After merging: ");
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
    static Node sortedMerge(Node head1, Node head2) {
        // code here
        Node dummyNode = new Node(-1);
        Node temp = dummyNode;
        Node t1 = head1;
        Node t2 = head2;
        
        while(t1!=null&&t2!=null){
            if(t1.data<t2.data){
                temp.next = t1;
                t1=t1.next;
                temp=temp.next;
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