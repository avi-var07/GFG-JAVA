/*Given a root of a Binary Tree, return its boundary traversal in the following order:

Left Boundary: Nodes from the root to the leftmost non-leaf node, preferring the left child over the right and excluding leaves.

Leaf Nodes: All leaf nodes from left to right, covering every leaf in the tree.

Reverse Right Boundary: Nodes from the root to the rightmost non-leaf node, preferring the right child over the left, excluding leaves, and added in reverse order.

Note: The root is included once, leaves are added separately to avoid repetition, and the right boundary follows traversal preference not the path from the rightmost leaf.

Examples:

Input: root = [1, 2, 3, 4, 5, 6, 7, N, N, 8, 9, N, N, N, N]
Output: [1, 2, 4, 8, 9, 6, 7, 3]
Explanation:

Input: root = [1, N, 2, N, 3, N, 4, N, N] 
Output: [1, 4, 3, 2]
Explanation:

Left boundary: [1] (as there is no left subtree)
Leaf nodes: [4]
Right boundary: [3, 2] (in reverse order)
Final traversal: [1, 4, 3, 2]
Constraints:
1 ≤ number of nodes ≤ 105
1 ≤ node->data ≤ 105

 */
import java.util.*;
class Node{
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data=data;
    }
}
class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter node (-1: stop): ");
        
        Node root = buildTree(sc);

        ArrayList<Integer>ans = boundaryTraversal(root);

        for(int ele: ans)System.out.print(ele+" ");
        sc.close();
    }
    static Node buildTree(Scanner sc){

        int val = sc.nextInt();
        if(val==-1)return null;

        Node root = new Node(val);
        root.left=buildTree(sc);
        root.right=buildTree(sc);

        return root;
    }
    static ArrayList<Integer> boundaryTraversal(Node root) {
        // code here
        ArrayList<Integer>ans = new ArrayList<>();
        if(root==null)return ans;
        if(!isLeaf(root))ans.add(root.data);
        left(root, ans);
        leaves(root,ans);
        right(root, ans);
        
        return ans;
        
    }
    static void left(Node root, ArrayList<Integer>ans){
        Node curr = root.left;
        while(curr!=null){
            if(!isLeaf(curr))ans.add(curr.data);
            if(curr.left!=null)curr=curr.left;
            else curr=curr.right;
        }
    }
    static void right(Node root, ArrayList<Integer>ans){
        Node curr = root.right;
        Stack<Integer>st = new Stack<>();
        while(curr!=null){
            if(!isLeaf(curr))st.add(curr.data);
            if(curr.right!=null)curr=curr.right;
            else curr=curr.left;
        }
        while(!st.isEmpty())ans.add(st.pop());
    }
    static void leaves(Node root, ArrayList<Integer>ans){
        if(isLeaf(root)){
            ans.add(root.data);
            return;
        }
        if(root.left!=null)leaves(root.left, ans);
        if(root.right!=null)leaves(root.right, ans);
    }
    static boolean isLeaf(Node node){
        return node.left==null&&node.right==null;
    }
}