/*
Defines the structure of the node for the tree data structure.
*/

package DataStructures.NonLinearDS.Tree;

public class Node<T>
{
    T data;
    Node<T> left;
    Node<T> right;

    Node (T data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
