package com.jill;

public class TreeNode<Tree extends Comparable<Tree>> {
    private Tree value;
    public TreeNode<Tree> left;
    public TreeNode<Tree> right;

    //constructor
    public TreeNode(Tree value) {
        this.value = value;
    }

    public void inOrder(TreeNode<Tree> root, BinaryTreeRun treeAction) {
        if (root.left != null) inOrder(root.left, treeAction);
        treeAction.setValue(root.value);
        treeAction.run();
        if (root.right != null) inOrder(root.right, treeAction);
    }

    @Override
    public String toString() {
        String s = "";
        if (left != null) s += left.toString() + "\n";
        s += this.value.toString() + "\n";
        if (right != null) s += right.toString() + "\n";
        return s;
    }

    public boolean hasNext() {
        return this.left != null || this.right != null;
    }

    public Tree getValue() {
        return this.value;
    }

    //find node
    public Tree find(Tree value) {
        if (this.value.equals(value)) return this.value;
        Tree leftFind = null, rightFind = null;
        if (this.left != null) if (this.value.compareTo(value) > 0) leftFind = left.find(value);
        if (leftFind != null) return leftFind;
        if (this.right != null) if (this.value.compareTo(value) < 0) rightFind = right.find(value);
        return rightFind;
    }

    //locate insertion point and insert new node
    public boolean insert(Tree value) {
        if (this.value.compareTo(value) > 0) {
            if (this.left == null) {
                this.left = new TreeNode<>(value);
                return true;
            } else this.left.insert(value);
        }
        if (this.value.compareTo(value) < 0) {
            if (this.right == null) {
                this.right = new TreeNode<>(value);
                return true;
            } else this.right.insert(value);
        }
        return false;
    }

    //remove node from tree
    public TreeNode<Tree> removeNode(TreeNode<Tree> root, Tree value) {
        if (root == null) return null;
        if (this.value.compareTo(value) < 0)
            root.left = removeNode(root.left, value);
        else if (this.value.compareTo(value) > 0)
            root.right = removeNode(root.right, value);
        else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            root.value = findMinNode(root.right).value;
            root.right = removeNode(root.right, root.value);
        }
        return root;
    }

    public TreeNode<Tree> findMinNode(TreeNode<Tree> root) {
        if (root.left != null) return findMinNode(root.left);
        else return root;
    }

}
