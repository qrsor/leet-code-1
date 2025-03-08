package pl.qrsor.neetcode;

import java.util.Stack;

public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {

        if(root==null) return 0;

        int depth = 0;
        Stack<TreeNode> wq = new Stack<>();
        Stack<TreeNode> path = new Stack<>();

        wq.push(root);

        TreeNode current;
        while (!wq.empty()) {
            current = wq.peek();
            if (!path.empty() && current == path.peek()) {
                if (path.size() > depth)
                    depth = path.size();
                path.pop();
                wq.pop();
            } else {
                path.push(current);
                if (current.right != null)
                    wq.push(current.right);
                if (current.left != null)
                    wq.push(current.left);
            }
        }

        return depth;
    }
}
