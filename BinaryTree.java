package com.samples;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by kkama4 on 9/25/16.
 */
public class BinaryTree {
    // This is the root node of the BT
    Node root;

    // A Node in doubly linked list
    private class Node {
        int val;
        Node left, right;
        boolean marked;
        Node(int val) {
            this.val = val;
        }
    }

    public void insert(int val) {
        root = insert(root, val);
    }

    private Node insert(Node x, int val) {
        if (x == null) return new Node(val);
        else if (x.val >= val) {
            x.left = insert(x.left, val);
        } else if (x.val < val) {
            x.right = insert(x.right, val);
        }

        return x;
    }

    @Override
    public String toString() {
        StringBuilder nodes = new StringBuilder();
        if (root == null) nodes.append("Empty");
        else {
            val(nodes, root);
        }
        return nodes.toString();
    }

    private void val(StringBuilder nodes, Node x) {
        if (x != null) {
            nodes.append(x.val + " ");
            val(nodes, x.left);
            val(nodes, x.right);
        }
    }

    // Tree traversal Depth First Search
    public void inOrderTraverse() {
        inOrderTraverse(root);
    }

    private void inOrderTraverse(Node x) {
        if (x == null) return;
        inOrderTraverse(x.left);
        System.out.print(x.val + " ");
        inOrderTraverse(x.right);
    }

    public void preOrderTraverse() {
        preOrderTraverse(root);
    }

    private void preOrderTraverse(Node root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preOrderTraverse(root.left);
        preOrderTraverse(root.right);
    }

    public void postOrderTraverse() {
        postOrderTraverse(root);
    }

    private void postOrderTraverse(Node root) {
        if (root == null) return;
        postOrderTraverse(root.left);
        postOrderTraverse(root.right);
        System.out.print(root.val + " ");
    }

    public int size() {
        return size(root);
    }

    private int size(Node n) {
        if (n == null) return 0;
        else {
            return (size(n.left) + 1 + size(n.right));
        }
    }

    public boolean isBST() {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBST(Node root, int min, int max) {
        if (root == null) return true;
        if (root.val < min || root.val > max) return false;
        return (isBST(root.left, min, root.val) && isBST(root.right, root.val + 1, max));
    }

    public void printLevelOrder() {
        printLevelOrder(root);
    }

    private void printLevelOrder(Node n) {
        if (n == null) return;
        Queue<Node> queue = new LinkedList<>();
        n.marked = true;
        queue.add(n);
        queue.add(null);


        while (!queue.isEmpty()) {
            Node val = queue.poll();
            if (val != null) {
                System.out.print(val.val + " ");
            } else {
                System.out.println();
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
            }

            if (val != null) {
                if (val.left != null) {
                    if (!val.left.marked) {
                        val.left.marked = true;
                        queue.add(val.left);
                    }
                }
                if (val.right != null) {
                    if (!val.right.marked) {
                        val.right.marked = true;
                        queue.add(val.right);
                    }
                }
            }
        }
    }


    public static void main(String args[]) {
        BinaryTree tree = new BinaryTree();
        int len = args.length;
        for (int i = 0; i < len; i++) {
            tree.insert(Integer.valueOf(args[i]));
        }
        System.out.println(tree);
        tree.inOrderTraverse();
        System.out.println();
        tree.preOrderTraverse();
        System.out.println();
        tree.postOrderTraverse();
        System.out.println("\n" + tree.size());
        System.out.println("isBST: " + tree.isBST());
        tree.printLevelOrder();
    }
}
