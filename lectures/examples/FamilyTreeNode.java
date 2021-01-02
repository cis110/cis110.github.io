/* FamilyTreeNode.java
 * Benedict Brown
 *
 * Example of a binary tree.  Each node
 * keep track of its father and mother.
 */

public class FamilyTreeNode {
    public String name;
    public FamilyTreeNode father;
    public FamilyTreeNode mother;
    
    public FamilyTreeNode find(String name) {
        if (name.equals(this.name))
            return this;
        
        if (father != null) {
            FamilyTreeNode f = father.find(name);
            if (f != null) return f;
        }
        
        if (mother != null) {
            FamilyTreeNode m = mother.find(name);
            if (m != null) return m;
        }
        
        return null;
    }
}
