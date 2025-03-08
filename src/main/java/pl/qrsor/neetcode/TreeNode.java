package pl.qrsor.neetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import jakarta.annotation.Nonnull;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Nonnull
    public static TreeNode fromIntegers(List<Integer> values) {

        TreeNode root = new TreeNode(values.getFirst());
        var queue = new LinkedList<TreeNode>();
        queue.add(root);

        var i = 1;
        while (i < values.size() && !queue.isEmpty()) {
            var current = queue.peek();
            var popFromQueue = false;

            Integer leftVal = values.get(i);
            if (leftVal != null) {
                current.left = new TreeNode(leftVal);
                queue.add(current.left);
                popFromQueue = true;
            }
            i++;

            if (i < values.size() && values.get(i)!=null) {
                current.right = new TreeNode(values.get(i));
                queue.add(current.right);
                popFromQueue = true;
            }
            i++;

            if(popFromQueue) queue.pop();
        }

        return root;
    }

    public List<Integer> toValList() {
        var result = new ArrayList<Integer>();
        var queue = new LinkedList<TreeNode>();
        queue.add(this);

        var index = 0;
        while (!queue.isEmpty()) {
            var node = queue.pop();
            if (node != null) {
                while (result.size() < index) {
                    result.add(null);
                }
                result.add(index, node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
            index++;
        }

        //trim nulls at end
        while(result.getLast()==null) {
            result.removeLast();
        }

        return result;
    }

    @Override
    public String toString() {
        return String.format("%d l:%s r:%s", val, left == null ? "null" : left.val, right == null ? "null" : right.val);
    }
}