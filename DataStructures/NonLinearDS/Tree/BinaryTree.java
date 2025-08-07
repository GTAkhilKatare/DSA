/*
A binary tree is a type of tree data structure in which the tree have only zero, one or two child nodes.

To create a binary tree, we will use a thing known as dataset.
Basically dataset is a array of values for which the node will be created.

Dataset: ["This is root", "Left of root", null, null, "Right of root", null, null]

The value `null` represents that do not create any node and go back to parent.
*/

package DataStructures.NonLinearDS.Tree;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<T>
{
    Node<T> root;

    BinaryTree()
    {
        this.root = null;
        System.out.println("Tree created successfully.");
    }

    public static void main(String... args)
    {
        String[] dataset = {
            "A",
            "B",
            null,
            null,
            "C",
            null,
            null
        };

        BinaryTree<String> tree = new BinaryTree<>();
        AtomicInteger index = new AtomicInteger(0);

        tree.root = tree.createTree(dataset, index);

        // System.out.print("PRE-ORDER TRAVERSAL: ");
        // tree.preOrder(tree.root);
        // System.out.println();
        // System.out.println();

        // System.out.print("IN-ORDER TRAVERSAL: ");
        // tree.inOrder(tree.root);
        // System.out.println();
        // System.out.println();

        // System.out.print("POST-ORDER TRAVERSAL: ");
        // tree.postOrder(tree.root);
        // System.out.println();
        // System.out.println();

        tree.insert(tree.root, "D");
        tree.insert(tree.root, "E");
        tree.insert(tree.root, "F");
        tree.insert(tree.root, "G");

        System.out.print("LEVEL_ORDER TRAVERSAL: ");
        tree.levelOrder(tree.root);
        System.out.println();
        System.out.println();

        tree.remove(tree.root, "B");

        System.out.print("LEVEL_ORDER TRAVERSAL: ");
        tree.levelOrder(tree.root);
        System.out.println();
        System.out.println();
    }

    private Node<T> createTree(T[] dataset, AtomicInteger index)
    {
        if (index.get() >= dataset.length || dataset[index.get()] == null)
        {
            index.incrementAndGet();
            return null;
        }

        Node<T> node = new Node<>(dataset[index.getAndIncrement()]);
        node.left = createTree(dataset, index);
        node.right = createTree(dataset, index);

        return node;
    }

    private void insert(Node<T> node, T data)
    {
        Node<T> newNode = new Node<>(data);

        if (node == null)
        {
            node = newNode;
            return;
        }

        Queue<Node<T>> queue = new LinkedList<>();
        Node<T> current = null;

        queue.offer(node);

        while (!queue.isEmpty())
        {
            current = queue.poll();

            if (current.left == null)
            {
                current.left = newNode;
                System.out.println("Successfully added node:  " + node.data);
                break;
            }
            else
                queue.offer(current.left);

            if (current.right == null)
            {
                current.right = newNode;
                System.out.println("Successfully added node:  " + node.data);
                break;
            }
            else
                queue.offer(current.right);
        }
    }

    private void remove(Node<T> node, T target)
    {
        if (node == null)
        {
            System.out.println("Tree is empty!");
            return;
        }
        
        if (node.left == null && node.right == null)
        {
            if (node.data.equals(target))
            {
                node = null;
                return;
            }
        }

        Queue<Node<T>> queue = new LinkedList<>();
        Node<T> current = null;
        Node<T> targetNode = null;
        
        queue.offer(node);

        while (!queue.isEmpty())
        {
            current = queue.poll();

            if (current.data.equals(target))
                targetNode = current;

            if (current.left != null)
                queue.offer(current.left);
            
            if (current.right != null)
                queue.offer(current.right);
        }

        if (targetNode != null) 
        {
            targetNode.data = current.data;
            deleteDepeastNode(node, current);
        }

        System.out.println("Successfully removed node: " + target);

    }

    private void deleteDepeastNode(Node<T> node, Node<T> target)
    {
        Queue<Node<T>> queue = new LinkedList<>();
        Node<T> current = node;
        queue.offer(current);

        while(!queue.isEmpty())
        {
            current = queue.poll();

            if (current.left != null)
            {
                if (current.left == target)
                {
                    current.left = null;
                    return;
                }
                else
                    queue.offer(current.left);
            }

            if (current.right != null)
            {
                if (current.right == target)
                {
                    current.right = null;
                    return;
                }
                else
                    queue.offer(current.right);
            }
        }
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
