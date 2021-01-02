/* BinaryTreeNode.java
 * Benedict Brown
 *
 * Example of a binary tree.
 *
 * Each node has two children, which or typically
 * named "left" and "right" to corresond to a
 * drawing of the tree.
 */

public class BinaryTreeNode {
    public String name;             // the contents of the node
    private BinaryTreeNode left;    // left child
    private BinaryTreeNode right;   // right child
    
    // insert strings into the tree in sorted order
    public void insertSorted(BinaryTreeNode n) {
        // n.name < name compares memory addresses
        if (n.name.compareTo(name) < 0) { // compares alphabetically
            System.out.println("Inserting " + n.name +
                               " in the left child of " + name);
            if (left == null) left = n;
            else left.insertSorted(n);
        } else {
            System.out.println("Inserting " + n.name +
                               " in the right child of " + name);
            if (right == null) right = n;
            else right.insertSorted(n);
        }
    }
  
    // print out the tree nodes in sorted order
    // (left sub-tree, then current node, then right sub-tree)
    private String inOrder() {
        String s = "";
        if (left != null)
            s += left.inOrder();
        s += name + "\n";
        if (right != null)
            s += right.inOrder();
        
        return s;
    }
    
    // print out the tree in pre-order
    // (left sub-tree, then right sub-tree, then current node)
    private String preOrder() {
        String s = "";
        s += name + "\n";
        if (left != null)
            s += left.preOrder();
        if (right != null)
            s += right.preOrder();
        
        return s;
    }
    
    // print out the tree in post-order
    // (right sub-tree, then left sub-tree, then current node)
    private String postOrder() {
        String s = "";
        if (left != null)
            s += left.postOrder();
        if (right != null)
            s += right.postOrder();
        s += name + "\n";
        
        return s;        
    }
    
    // string representation of tree, starting at this node
    public String toString() {
        return inOrder() + "\n" +
            preOrder() + "\n" +
            postOrder();
    }

    // find a node containing the string "name", or return null if none exists
    public BinaryTreeNode find(String name) {
        return null;
    }
  
    public static void main(String[] args) {
        // create a root node
        BinaryTreeNode root = new BinaryTreeNode();

        // StdIn reads input from the keyboard
        root.name = StdIn.readString();
        
        while (!StdIn.isEmpty()) {
            BinaryTreeNode n = new BinaryTreeNode();
            n.name = StdIn.readString();
            
            root.insertSorted(n);
        }

        // print the tree
        System.out.println("The completed tree is:");
        System.out.println(root);

        // now look for a string in the tree
        System.out.println();
        System.out.println("Searching for: " + args[0]);
        BinaryTreeNode foundNode = root.find(args[0]);
        System.out.println(foundNode);
    }
}
