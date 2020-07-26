package com.kishorenl.collections.tree.code;

public class NodeCountInCompleteBT {
    public int countNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int h = 0;
        Node node = root;
        while (node != null) {
            h++;
            node = node.left;
        }
        return count(h, root);
    }

    public int count(int h, Node node) {
        if (node == null) {
            return 0;
        }
        int v = heightRight(node.left);
        if (v == h - 1) {
            // The left subtree is a perfect binary tree with height h - 1
            // So, we only need to look at the right subtree
            // return (1 << (h - 1)) + count(h - 1, node.right);
            return 1 + /* root */ (1 << (h - 1) - 1) /* Total nodes in left tree with heigh h-1 */
                    + count(h - 1, node.right); /* Total nodes in right tree again recursion */
        } else {

            // The right subtree is perfect binary tree with height h - 2
            // So, we only need to look at the left subtree
            // return (1 << (h - 2)) + count(h - 1, node.left);
            return 1 + (1 << (h - 2) - 1) + count(h - 1, node.left);
        }
    }

    public int heightRight(Node node) {
        if (node == null) {
            return 0;
        }
        int result = 0;
        while (node != null) {
            node = node.right;
            result++;
        }
        return result;
    }
}