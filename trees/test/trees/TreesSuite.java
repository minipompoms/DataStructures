package trees;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author pkohn
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({trees.BinarySearchTreeTest.class, trees.TreesAppTest.class})
public class TreesSuite {

    @BeforeClass
    public static void setUpClass() throws Exception 
    {
        
    }

    @AfterClass
    public static void tearDownClass() throws Exception 
    {
    }

    @Before
    public void setUp() throws Exception 
    {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
