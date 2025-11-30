import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();
        myStack ms = new myStack(n);
        System.out.println("Enter "+n+" operations: ");
        int top = -1;
        int st [] = new int[n];
        sc.nextLine();
        for(int i=0;i<n;i++){
            System.out.println("Enter operation: 'push', 'pop', 'top', 'size' ");
            String op = sc.nextLine().toLowerCase();
            switch (op) {
                case "push":
                    if(ms.isFull()){
                        System.out.println("Stack overflow");
                        break;
                    }
                        
                    
                    System.out.println("Enter value to push: ");
                    int ele = sc.nextInt();
                    sc.nextLine();
                    ms.push(ele);
                    
                    break;
                case "pop":
                    if(ms.isEmpty()){
                        System.out.println("Stack underflow");
                        break;
                    }

                    System.out.println("Element popped: "+st[top]);
                    ms.pop();
                    break;
                
            
                case "top":
                    if(ms.isEmpty()){
                        System.out.println("Stack is empty!");
                        break;
                    }
                    System.out.println("Element at top is: "+ms.peek());
                    break;
                
                
                default:
                    System.out.println("Enter either: 'push', 'pop', 'top', 'size' ");
                    break;
            }
        }        

        sc.close();
    }
}
class myStack extends Solution{
    int top;
    int st[];
    public myStack(int n) {
        // Define Data Structures
        st = new int [n];
        top=-1;
    }

    public boolean isEmpty() {
        // check if the stack is empty
        return top==-1;
    }

    public boolean isFull() {
        // check if the stack is full
        return top==st.length-1;
    }

    public void push(int x) {
        // Inserts x at the top of the stack
        if(isFull())return;
        st[++top] = x;
    }

    public void pop() {
        // Removes an element from the top of the stack
        if(isEmpty())return;
        top--;
    }

    public int peek() {
        // Returns the top element of the stack
        if(!isEmpty())return  st[top];
        return -1;
        
    }
}