import static java.lang.System.*;

class Tree {

    private class Node {
        String key;
        Queue<Integer> value;
        Node left;
        Node right;
    }
    private Node root;

    private void debugHelper(Node tree, int depth) {
        // Your code here might be recursive
        throw new UnsupportedOperationException();
    }

    private void outputHelper(Node tree) {
        // Your code here might be recursive
        throw new UnsupportedOperationException();
    }

    public void insert(String key, Integer linenum) {
        // Insert a word into the tree
        throw new UnsupportedOperationException();
    }

    public void debug() {
        // Show debug output of tree
        debugHelper(root, 0);
    }

    public void output() {
        // Show sorted words with lines where each word appears
        outputHelper(root);
    }

}
