
package com.kishorenl.collections.tree.code;

import java.util.LinkedList;
import java.util.Queue;
import java.util.HashMap;
import java.util.Map;

public class SideViewsOfBt {

    Node root;
    int max_level = 0;

    // A wrapper over leftViewUtil()
    void leftView() {
        leftViewUtil(root, 1);
    }

    // Basically pre order traversal.
    void leftViewUtil(Node node, int level) {
        // Base Case
        if (node == null)
            return;

        // If this is the first node of its level
        if (max_level < level) {
            System.out.print(" " + node.data);
            max_level = level;
        }

        // Recur for left and right subtrees
        leftViewUtil(node.left, level + 1);
        leftViewUtil(node.right, level + 1);
    }

    // Right side view
    // Level order traversal
    // function to print right view of binary tree
    void printRightView(Node root) {
        if (root == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            // number of nodes at current level
            int n = queue.size();

            // Traverse all nodes of current level
            for (int i = 1; i <= n; i++) {
                Node temp = queue.poll();

                // Print the right most element at
                // the level
                if (i == n)
                    System.out.print(temp.data + " ");

                // Add left node to queue
                if (temp.left != null)
                    queue.add(temp.left);

                // Add right node to queue
                if (temp.right != null)
                    queue.add(temp.right);
            }
        }
    }

    // top view

    class pair {
        int data, height;

        public pair(int data, int height) {
            this.data = data;
            this.height = height;
        }
    }

    // both height and hd are initially set to 0
    void printTopViewUtil(Node root, int height, int hd, Map<Integer, pair> m) {
        // Base Case
        if (root == null)
            return;

        // If the node for particular horizontal distance
        // is not present in the map, add it.
        // For top view, we consider the first element
        // at horizontal distance in level order traversal
        if (!m.containsKey(hd)) {
            m.put(hd, new pair(root.data, height));
        } else {
            pair p = m.get(hd);

            // Careful with this condition.. this is always getting missed.
            // It is easy to assume that it will work without this condition.
            if (p.height > height) {
                m.remove(hd);
                m.put(hd, new pair(root.data, height));
            }
        }

        // Recur for left and right subtree
        printTopViewUtil(root.left, height + 1, hd - 1, m);
        printTopViewUtil(root.right, height + 1, hd + 1, m);
    }

}