package trees;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pkohn
 */
public class BinarySearchTreeTest {
    
    public BinarySearchTreeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of insert method, of class BinarySearchTree.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        Object x = null;
        BinarySearchTree instance = new BinarySearchTree();
        instance.insert((Comparable) x);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class BinarySearchTree.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        Object x = null;
        BinarySearchTree instance = new BinarySearchTree();
        instance.remove((Comparable) x);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findMin method, of class BinarySearchTree.
     */
    @Test
    public void testFindMin() {
        System.out.println("findMin");
        BinarySearchTree instance = new BinarySearchTree();
        Object expResult = null;
        Object result = instance.findMin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findMax method, of class BinarySearchTree.
     */
    @Test
    public void testFindMax() {
        System.out.println("findMax");
        BinarySearchTree instance = new BinarySearchTree();
        Object expResult = null;
        Object result = instance.findMax();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of contains method, of class BinarySearchTree.
     */
    @Test
    public void testContains() {
        System.out.println("contains");
        Object x = null;
        BinarySearchTree instance = new BinarySearchTree();
        boolean expResult = false;
        boolean result = instance.contains((Comparable) x);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of makeEmpty method, of class BinarySearchTree.
     */
    @Test
    public void testMakeEmpty() {
        System.out.println("makeEmpty");
        BinarySearchTree instance = new BinarySearchTree();
        instance.makeEmpty();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEmpty method, of class BinarySearchTree.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        BinarySearchTree instance = new BinarySearchTree();
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDuplicates method, of class BinarySearchTree.
     */
    @Test
    public void testGetDuplicates() {
        System.out.println("getDuplicates");
        Object x = null;
        BinarySearchTree instance = new BinarySearchTree();
        int expResult = 0;
        int result = instance.getDuplicates((Comparable) x);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printTree method, of class BinarySearchTree.
     */
    @Test
    public void testPrintTree() {
        System.out.println("printTree");
        BinarySearchTree instance = new BinarySearchTree();
        instance.printTree();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
