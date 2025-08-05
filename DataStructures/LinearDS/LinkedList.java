/*
A linked list is a data structure where things are store using nodes. Each node carry the data and the address of next node.

The structure of the node is like:
-----------------------------------
| Data | Next node memory address |
-----------------------------------

And the linked list will look like:
            --------------------      --------------------      --------------------
Head -----> | Data | Next node | ---> | Data | Next node | ---> | Data | Next node | ---> null
            --------------------      --------------------      --------------------
                                                                        (TAIL)

In the linked list, the first node is known as head and the last node is known as tail.
We can also, modify the structure of the node by making it able to store multiple data, but the general way is this to represent it.
*/

package DataStructures.LinearDS;

// The structure of the node
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


public class LinkedList<T>
{
    private Node<T> head;


    LinkedList () 
    { 
        this.head = null;
        System.out.println("Linked list created successfully.");
    }


    public static void main(String... args)
    {
       LinkedList<String> list = new LinkedList<>();
       list.insert("Data 1");
       list.insert("Data 2");
       list.insert("Data 3");
       list.insert("Data 4");
       list.insert("Data 5");

       list.remove("Data 1");

       list.printList();
    }


    private void insert(T data)
    {
        Node<T> newNode = new Node<>(data);

        // Inserting the node
        if (head == null)
            head = newNode;

        else 
        {
            Node<T> current = head;
            while(current.next != null)
                current = current.next;
            
            current.next = newNode;
        }

        System.out.println("Successfully entered the data: " + data);
    }

    private void remove(T key)
    {
        if (head == null)
        {
            System.out.println("Linked list is empty!");
            return;
        }

        Node<T> current = head;
        Node<T> previous = null;

        if (current.data == key)
        {
            head = current.next;
        }
        else 
        {
            while (current != null)
            {
                if (current.data == key) 
                {
                    previous.next = current.next;
                    break;
                }

                previous = current;
                current = current.next;
            }
        }

        if (current == null)
            System.out.println(key + " was not found in list!");
        else
            System.out.println(key + " removed successfully.");

    }

    private void printList()
    {
        if (head == null)
        {
            System.out.println("Linked list is empty!");
            return;
        }

        Node<T> current = head;

        System.out.print("Linked List: [");
        while(current.next != null)
        {
            System.out.print(current.data + "  --->  ");
            current = current.next;
        }
        System.out.println(current.data + "]");
    }
}
