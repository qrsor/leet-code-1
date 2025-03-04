package pl.qrsor.neetcode;

import java.util.LinkedList;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return null;

        var queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (!queue.isEmpty()) {
            var node = queue.pop();
            var tmp = node.left;
            node.left = node.right;
            node.right = tmp;

            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }

        return root;
    }
}
