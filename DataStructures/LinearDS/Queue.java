/*
The queue data structure is similar to stack data structure.
The way to store data in queue is same as the stack. But the difference comes in the way they work on the data.

The stack uses Last in first out (LIFO) where as the queue uses First in first out (FIFO).
In FIFO, the data inserted at first will be removed first.

In stack, the insertion of data and removing of data is done from top only, but in queue the insertion takes place from tail and removing takes place from head.

There is also another type of queue known as double ended queue, in which the insertion and deletion takes place at both end.
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


public class Queue<T>
{
    Node<T> head;
    Node<T> tail;

    Queue()
    {
        this.head = null;
        this.tail = null;
        System.out.println("Queue created successfully.");
    }

    public static void main(String... args)
    {
        Queue<String> queue = new Queue<>();
        System.out.println("Is queue empty? " + queue.isEmpty());

        queue.enqueue("Data 1");
        queue.enqueue("Data 2");
        queue.enqueue("Data 3");
        queue.enqueue("Data 4");
        queue.enqueue("Data 5");

        System.out.println("Is queue empty? " + queue.isEmpty());

        System.out.println("Top element: " + queue.front());
        System.out.println("Bottom element: " + queue.rear());

        queue.dequeue();
        queue.dequeue();

        System.out.println("Top element: " + queue.front());
        System.out.println("Bottom element: " + queue.rear());

    }

    private void enqueue(T data)
    {
        Node<T> newNode = new Node<>(data);

        if (head == null)
        {
            head = newNode;
            tail = newNode;
        }

        else
        {
            tail.next = newNode;
            tail = newNode;
        }

        System.out.println("Successfully inserted: " + data);
    }

    private void dequeue()
    {
        if (head == null)
            System.out.println("Queue is empty!");

        else 
        {
            Node<T> temp = head;
            head = head.next;
            
            temp.next = null;
            System.out.println("Successfully removed: " + temp.data);

            // If we remove the last element then.
            if (head == null)
                tail = null;
        }
    }

    private T front()
    {
        if (head == null)
            return null;

        else
            return head.data;
    }

    private T rear()
    {
        if (tail == null)
            return null;

        else
            return tail.data;
    }

    private boolean isEmpty()
    {
        if (head == null)
            return true;
        else
            return false;
    }
}
