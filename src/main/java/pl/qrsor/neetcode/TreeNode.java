package pl.qrsor.neetcode;

import jakarta.annotation.Nonnull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

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
    public static TreeNode fromIntegers(int first, int... rest) {

        var values = Arrays.stream(rest).boxed().collect(Collectors.toCollection(LinkedList::new));
        TreeNode root = new TreeNode(first);
        var queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (!values.isEmpty()) {
            var current = queue.pop();
            current.left = new TreeNode(values.pop());
            queue.add(current.left);

            if (!values.isEmpty()) {
                current.right = new TreeNode(values.pop());
                queue.add(current.right);
            }
        }

        return root;
    }

    public List<Integer> toValList() {
        var result = new ArrayList<Integer>();
        var queue = new LinkedList<TreeNode>();
        queue.add(this);

        while (!queue.isEmpty()) {
            var node = queue.pop();
            if (node == null) {
                result.add(null);
            } else {
                result.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
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