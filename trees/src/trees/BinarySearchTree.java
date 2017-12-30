package trees;


/**
 * Implements an unbalanced binary search tree. Note that all "matching" is
 * based on the compareTo method.
 *
 * @author Mark Allen Weiss
 *   slightly modified by @akatz
 * @param <AnyType>
 * 
 * A BinarySearchTree to handle 
 * duplicate entries by keeping count.
 * additional modifications by @pkohn
 */


public class BinarySearchTree<AnyType extends Comparable<? super AnyType>>
{

    /**
     * The tree root.
     */
    private BinaryNode<AnyType> root;
   

    /**
     * Construct the tree.
     */
    public BinarySearchTree()
    {
        root = null;
        
    }

    /**
     * Insert into the tree; duplicates are counted
     *
     * @param x the item to insert.
     */
    public void insert(AnyType x)
    {
        root = insert(x, root);
    }

    /**
     * Remove from the tree. Nothing is done if x is not found.
     *
     * @param x the item to remove.
     */
    public void remove(AnyType x)
    {
        root = remove(x, root);
    }

    /**
     * Find the smallest item in the tree.
     *
     * @return smallest item or null if empty.
     */
    public AnyType findMin()
    {
        AnyType retVal = null;
        if (!isEmpty())
        {
            retVal = findMin(root).element;
        }
        return retVal;
    }

    /**
     * Find the largest item in the tree.
     *
     * @return the largest item of null if empty.
     */
    public AnyType findMax()
    {
         AnyType retVal = null;
        if (!isEmpty())
        {
            retVal = findMax(root).element;
        }
        return retVal;
    }

    /**
     * Find an item in the tree.
     *
     * @param x the item to search for.
     * @return true if  found.
     */
    public boolean contains(AnyType x)
    {
        return contains(x, root);
    }

    /**
     * Make the tree logically empty.
     */
    public void makeEmpty()
    {
        root = null;
    }

    /**
     * Test if the tree is logically empty.
     *
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty()
    {
        return root == null;
    }

    /**
     *
     * @param x
     * @return the duplicate count
     */
    public int getDuplicates(AnyType x)
    {
        BinaryNode <AnyType> t = root; // the node that roots the tree.
       
       return countDuplicates(x, t);   //returns count of duplicates
    }
    /**
     * Print the tree contents in sorted order.
     */
    public void printTree()
    {
        if (isEmpty())
        {
            System.out.println("Empty tree");
        }
        else
        {
            printTree(root);
        }
    }
   
    ////////////////////////////////////////////////
    //  private methods accessing tree structure  //
    ///////////////////////////////////////////////
    
    /**
     * Internal method to insert into a subtree.
     *
     * @param x the item to insert.
     * @param t the node that roots the subtree.
     * @return the new root of the subtree.
     */
    private BinaryNode<AnyType> insert(AnyType x, BinaryNode<AnyType> t)
    {
        if (t == null)
        {
            return new BinaryNode<>(x, null, null);
        }

        int compareResult = x.compareTo(t.element);

        if (compareResult < 0)
        {
            t.left = insert(x, t.left);
          
        }
        else if (compareResult > 0)
        {
            t.right = insert(x, t.right);
           
           
        }
        else if (compareResult == 0)
        {
            t.count++;
        }
       
        return t;
    }

    /**
     * Internal method to remove from a subtree.
     *
     * @param x the item to remove.
     * @param t the node that roots the subtree.
     * @return the new root of the subtree.
     */
    private BinaryNode<AnyType> remove(AnyType x, BinaryNode<AnyType> t)
    {
        if (t == null)
        {
            return t;   // Item not found; do nothing
        }
        int compareResult = x.compareTo(t.element);

        if (compareResult < 0)
        {
            t.left = remove(x, t.left);
           
        }
        else if (compareResult > 0)
        {
            t.right = remove(x, t.right);
            
        }
        else if (t.left != null && t.right != null) // Two children
        {
            t.element = findMin(t.right).element;
            t.right = remove(t.element, t.right);
        }
        else
        {
            t = (t.left != null) ? t.left : t.right;
        }
        t.count--;
        return t;
    }

    /**
     * Internal method to find the smallest item in a subtree.
     *
     * @param t the node that roots the subtree.
     * @return node containing the smallest item.
     */
    private BinaryNode<AnyType> findMin(BinaryNode<AnyType> t)
    {
        if (t == null)
        {
            return null;
        }
        else if (t.left == null)
        {
            return t;
        }
        return findMin(t.left);
    }

    /**
     * Internal method to find the largest item in a subtree.
     *
     * @param t the node that roots the subtree.
     * @return node containing the largest item.
     */
    private BinaryNode<AnyType> findMax(BinaryNode<AnyType> t)
    {
        if (t != null)
        {
            while (t.right != null)
            {
                t = t.right;
            }
        }

        return t;
    }

    /**
     * Internal method to find an item in a subtree.
     *
     * @param x is item to search for.
     * @param t the node that roots the subtree.
     * @return node containing the matched item.
     */
    private boolean contains(AnyType x, BinaryNode<AnyType> t)
    {
        if (t == null)
        {
            return false;
        }

        int compareResult = x.compareTo(t.element);

        if (compareResult < 0)
        {
            return contains(x, t.left);
        }
        else if (compareResult > 0)
        {
            return contains(x, t.right);
        }
        else
        {
            return true;    // Match
        }
    }

  
    /**
     * Internal method to print a subtree in sorted order.
     *
     * @param t the node that roots the subtree.
     */
    private void printTree(BinaryNode<AnyType> t)
    {
        if (t != null)
        {
            printTree(t.left);
            System.out.println(t.element + " " + t.count); //revised to include count
            printTree(t.right);
            
        }
    }
 
 

  
    /**
     * Internal method to count duplicates.
     *
     * @param x is item to search for.
     * @param t the node that roots the subtree.
     * @return duplicate count of node containing the matched item.
     */
    private int countDuplicates(AnyType x, BinaryNode<AnyType> t)
    {
      
        if(x.compareTo(t.element) > 0)      //will search right side for item in tree
        {
            return countDuplicates(x, t.right); //breaks if found
        }
        else if(x.compareTo(t.element) < 0) //continues searching to left
        {
            return countDuplicates(x, t.left); 
        }
        else
            
       return t.count; //if no match will return 1 as default
        
    }
 

    // Basic node stored in unbalanced binary search trees
    private static class BinaryNode<AnyType>
    {
        AnyType element;            // The data in the node
        int count = 1;              // Keep track of the count
        BinaryNode<AnyType> left;   // Left child
        BinaryNode<AnyType> right;  // Right child
        

        // Constructors
        BinaryNode(AnyType theElement)
        {
            this(theElement, null, null);
        }

        BinaryNode(AnyType theElement, BinaryNode<AnyType> lt, BinaryNode<AnyType> rt)
        {
            element = theElement;
            left = lt;
            right = rt;
            count = 1;
        }
        
       
        
     
    }

}