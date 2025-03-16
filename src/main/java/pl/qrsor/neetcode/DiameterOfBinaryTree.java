package pl.qrsor.neetcode;

import java.util.LinkedList;

public class DiameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        var queue = new LinkedList<TreeNode>();
        queue.add(root);

        int diameter = 0;

        while (!queue.isEmpty()) {
            var current = queue.pop();
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);

            diameter = Math.max(diameter, maxDepth(current.left) + maxDepth(current.right));
        }

        return diameter;
    }

    private int maxDepth(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
    }
}
