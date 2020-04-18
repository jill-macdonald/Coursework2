package com.jill;

public abstract class BinaryTreeRun<Tree> implements Runnable {

    private Tree value;

    public void setValue(Tree value) {
        this.value = value;
    }

    public Tree getValue() {
        return value;
    }
}
