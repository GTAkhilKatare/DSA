/*
A Binary Search Tree (BST) is a type of binary tree where each node follows a specific ordering rule:

1. Left Subtree: contains only nodes with values less than the current node’s value.
2. Right Subtree: contains only nodes with values greater than the current node’s value.
*/

package DataStructures.NonLinearDS.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree<T extends Comparable<T>> 
{
    Node<T> root;

    BinarySearchTree()
    {
        this.root = null;
        System.out.println("Binary Search Tree (BST) created successfully.");
    }

    public static void main(String... args)
    {
        BinarySearchTree<Character> tree = new BinarySearchTree<>();
        tree.insert('C');
        tree.insert('A');
        tree.insert('B');
        tree.insert('D');
        tree.insert('E');

        System.out.print("LEVEL_ORDER TRAVERSAL: ");
        tree.levelOrder(tree.root);
        System.out.println();
        System.out.println();

        tree.remove('A');
        tree.remove('E');

        System.out.print("LEVEL_ORDER TRAVERSAL AFTER DELETION: ");
        tree.levelOrder(tree.root);
        System.out.println();
        System.out.println();
    }

    private void insert(T data)
    {
        Node<T> newNode = new Node<>(data);

        if (root == null)
        {
            root = newNode;
            System.out.println("Successfully inserted node: " + data);
        }

        else
        {
            Node<T> current = root;
            while (current != null)
            {
                if (data.compareTo(current.data) < 0)
                {
                    if (current.left == null)
                    {
                        current.left = newNode;
                        System.out.println("Successfully inserted node: " + data);
                        break;
                    }
                    else
                        current = current.left;
                }
                else if (data.compareTo(current.data) > 0)
                {
                    if (current.right == null)
                    {
                        current.right = newNode;
                        System.out.println("Successfully inserted node: " + data);
                        break;
                    }
                    else
                        current = current.right;
                }

                else
                {
                    System.out.println("Node with data " + data + " is already present!");
                    break;
                }
            }
        }
    }
    
    private void remove(T target)
    {
        root = removeRecursive(root, target);
    }

    private Node<T> removeRecursive(Node<T> node, T target)
    {
        if (node == null)
        {
            System.out.println("Could not found the node: " + target);
            return null;
        }

        if (target.compareTo(node.data) < 0)
            node.left = removeRecursive(node.left, target);

        else if (target.compareTo(node.data) > 0)
            node.right = removeRecursive(node.right, target);
        
        else
        {
            if (node.left == null && node.right == null)
                return null;

            else if (node.left == null)
                return node.right;
            
            else if (node.right == null)
                return node.left;

            else
            {
                Node<T> successor = findSuccessor(node.right);
                node.data = successor.data;
                root.right = removeRecursive(node.right, successor.data);
            }
        }

        return node;
    }

    private Node<T> findSuccessor(Node<T> node) {
        while (node.left != null)
            node = node.left;

        return node;
    }

    private void preOrder(Node<T> node)
    {
        if (node == null)
            return;


        System.out.print(node.data + " | ");
        preOrder(node.left);
        preOrder(node.right);
    }

    private void inOrder(Node<T> node)
    {
        if (node == null)
            return;


        inOrder(node.left);
        System.out.print(node.data + " | ");
        inOrder(node.right);
    }

    private void postOrder(Node<T> node)
    {
        if (node == null)
            return;


        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " | ");
    }

    private void levelOrder(Node<T> node)
    {
        if (node == null)
            return;


        Queue<Node<T>> queue = new LinkedList<>();
        Node<T> current = null;

        queue.offer(node);
        
        while (!queue.isEmpty())
        {
            current = queue.poll();
            System.out.print(current.data + " | ");

            if (current.left != null)
                queue.offer(current.left);

            if (current.right != null)
                queue.offer(current.right);
        }
    }
}
