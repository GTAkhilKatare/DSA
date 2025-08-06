/*
The stack is a data structure in which the data is kept on top of each other.
It's just like books kept on top of each other over the table.

Imagine it like this:

  (HEAD)
| Data 3 |
----------
| Data 2 |
----------
| Data 1 |
----------
  (TAIL)

The stack works on Last in first out (LIFO), in which the data comes at last will be removed first.
We can implement the stack using both array and linked list.
*/

package DataStructures.LinearDS;


final class Node<T>
{
    T data;
    Node<T> next;

    Node(T data)
    {
        this.data = data;
        this.next = null;
    }
}


public class Stack<T>
{
    Node<T> head;

    Stack ()
    {
        this.head = null;
        System.out.println("Stack created successfully.");
    }

    public static void main(String... args)
    {
        Stack<String> stack = new Stack<>();
        System.out.println("Is stack empty? " + stack.isEmpty());

        stack.push("Data 1");
        stack.push("Data 2");
        stack.push("Data 3");
        stack.push("Data 4");
        stack.push("Data 5");

        System.out.println("Is stack empty? " + stack.isEmpty());

        System.out.println("Top element: " + stack.top());

        System.out.println("Removed: " + stack.pop());
        System.out.println("Removed: " + stack.pop());

        System.out.println("Top element: " + stack.top());
    }

    private void push(T data)
    {
        Node<T> newNode = new Node<>(data);

        if (head == null)
            head = newNode;
        
        else 
        {
            newNode.next = head;
            head = newNode;
        }

        System.out.println("Successfully inserted data: " + data);
    }

    private T pop()
    {
        if (head == null)
           return null;
           
        else
        {
            T returnValue = head.data;
            head = head.next;

            return returnValue;
        }
    }

    private T top()
    {
        if (head == null)
            return null;

        else
            return head.data;
    }

    private boolean isEmpty()
    {
        if (head == null)
            return true;
        else
            return false;
    }

}
