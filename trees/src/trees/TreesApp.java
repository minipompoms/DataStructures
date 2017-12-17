
package trees;

/**
 *
 * @author pkohn
 */
public class TreesApp {

    /**
     * 
     *@param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        BinarySearchTree<String> xTree = new BinarySearchTree();
        
        xTree.insert("b");
        xTree.insert("a");
        xTree.insert("b");
        xTree.insert("b");
        xTree.insert("b");
        xTree.insert("b");
        xTree.insert("b");
        xTree.insert("b");
        xTree.insert("b");
        xTree.insert("c");
        xTree.insert("a");
        xTree.insert("y");
        xTree.insert("z");
        xTree.insert("y");
        xTree.insert("a");
       
        xTree.insert("a");
        xTree.printTree();
        System.out.println("duplicates of b " + xTree.getDuplicates("b"));
        System.out.println("duplicates of a "+xTree.getDuplicates("a"));
        System.out.println("duplicates of y " + xTree.getDuplicates("y"));
        
    }
    
}
