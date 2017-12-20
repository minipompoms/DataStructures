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
    
    private BinarySearchTree<Integer> instance;
    
    public BinarySearchTreeTest() 
    {
        
        
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception
    {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp()
    {
       instance = new BinarySearchTree<>();
       System.out.println("Before");
    }
    
    @After
    public void tearDown() 
    {
        System.out.println("After");
    }

    /**
     * Test of insert method, of class BinarySearchTree.
     */
    @Test
    public void testInsert() 
    {
        System.out.println("insert");
        BinarySearchTree z = new BinarySearchTree();
        
        Integer value = 44+44;
        z.insert(value);
        z.insert(66);
        
        assertTrue(z.contains(value));      
    }

    /**
     * Test of remove method, of class BinarySearchTree.
     */
    @Test
    public void testRemove() 
    {
        System.out.println("remove");
        BinarySearchTree z = new BinarySearchTree();
        
        z.insert(88);
        z.insert(700);
        z.insert(425);
        Integer value = 88;
        
        assertTrue(z.contains(88));
        z.remove(value);
        assertFalse(z.contains(value));
      
    }

    /**
     * Test of findMin method, of class BinarySearchTree.
     */
    @Test
    public void testFindMin() 
    {
        System.out.println("findMin");
        Integer expResult = 200;
        
        instance.insert(200);
        instance.insert(33999);
        instance.insert(9876543);
        
        Object result = instance.findMin();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of findMax method, of class BinarySearchTree.
     */
    @Test
    public void testFindMax() 
    {
        System.out.println("findMax");
        instance.insert(77);
        instance.insert(30);
        instance.insert(43);
        Integer expResult = 77;
        Object result = instance.findMax();
        assertEquals(expResult, result);
       
       
    }

    /**
     * Test of contains method, of class BinarySearchTree.
     */
    @Test
    public void testContains() 
    {
        System.out.println("contains");
        instance.insert(55);
        instance.insert(102);
        boolean expResult = true;
        Integer value = 102;
        boolean result = instance.contains(value);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of makeEmpty method, of class BinarySearchTree.
     */
    @Test
    public void testMakeEmpty() 
    {
        System.out.println("makeEmpty");
        instance.makeEmpty();
        assertTrue(instance.isEmpty());
    }

    /**
     * Test of isEmpty method, of class BinarySearchTree.
     */
    @Test
    public void testIsEmptyFalse() 
    {
        System.out.println("isEmpty");
        
        boolean expResult = false;
        instance.insert(33);
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of getDuplicates method, of class BinarySearchTree.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetDuplicates() throws Exception
    {
        System.out.println("getDuplicates");
        instance.insert(55);
        instance.insert(55);
        instance.insert(21);
        instance.insert(55);
        int expResult = 3;
        int result = instance.getDuplicates((55));
        assertEquals(expResult, result);
        
    }
    
   

    /**
     * Test of printTree method, of class BinarySearchTree.
     */
    @Test
    public void testPrintTree() 
    {
        System.out.println("printTree");
        instance.printTree();
        
    }
    
}
