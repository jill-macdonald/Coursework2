package com.jill;

public class BinaryTree<Tree extends Comparable<Tree>> {
    private TreeNode<Tree> root;

    //constructor
    public boolean add(Tree value) {
        if (root == null) {
            root = new TreeNode<>(value);
            return true;
        }
        return root.insert(value);
    }

    public void remove(Tree value) {
        this.root = root.removeNode(root, value);
    }

    @Override
    public String toString() {
        if (root != null) return root.toString();
        else return null;
    }

    public void inOrder(BinaryTreeRun treeAction) {
        root.inOrder(root, treeAction);
    }

    public Tree find(Tree value) {
        return root.find(value);
    }

    public TreeNode getRoot() {
        return root;
    }
}

