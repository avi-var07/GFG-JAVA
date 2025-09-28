import java.util.*;
class Node {
    int data;
    Node next;
    Node (int d) {
       data = d;
       next = null;
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
        
        Node head =arrayToList(arr);

        Node temp = head;
        while (temp!=null) {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        
        sc.close();
    }

    public static Node arrayToList(int arr[]) {
        // code here
        Node head = new Node(arr[0]);
        Node current = head;
        
        for(int i=1;i<arr.length;i++){
            Node temp = new Node(arr[i]);
            current.next = temp;
            current = temp;
        }
        return  head;
    }
}