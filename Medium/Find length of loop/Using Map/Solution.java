/*Given the head of a linked list, determine whether the list contains a loop. If a loop is present, return the number of nodes in the loop, otherwise return 0.

Note: Internally, pos(1 based index) is used to denote the position of the node that tail's next pointer is connected to. If pos = 0, it means the last node points to null, indicating there is no loop. Note that pos is not passed as a parameter.

Examples:

Input: pos = 2,
   
Output: 4
Explanation: There exists a loop in the linked list and the length of the loop is 4.
Input: pos = 3,
   
Output: 3
Explanation: The loop is from 19 to 10. So length of loop is 19 → 33 → 10 = 3.
Input: pos = 0,
    
Output: 0
Explanation: There is no loop.
Constraints:
1 ≤ number of nodes ≤ 105
1 ≤ node->data ≤ 104
0 ≤ pos < number of nodes

 */

import java.util.*;
class Node{
    int data;
    Node next;

    Node(int data){
        this.data=data;
        this.next=null;
    }
}
class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of elements: ");
        int  n = sc.nextInt();

        System.out.println("Enter "+n+" elements: ");
        int headVal = sc.nextInt();

        Node head = new Node(headVal);
        Node current = head;
        for(int i = 1;i<n;i++){
            int ele = sc.nextInt();
            Node temp = new Node(ele);
            current.next = temp;
            current = temp;
        }

        print(head);
        System.out.println();
        System.out.println(lengthOfLoop(head));
        sc.close();
    }
    static void print(Node head){
        Node temp =head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }
    public static int lengthOfLoop(Node head) {
        // code here
        Map<Node, Integer> map = new HashMap<>();
        Node temp =head;
        int timer= 0;
        while(temp!=null){
            if(map.containsKey(temp))return timer - map.get(temp);

            map.put(temp, timer);
            timer++;
            temp=temp.next;
        }
        return 0;
    }
}