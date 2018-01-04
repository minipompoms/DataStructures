package sorts;

/**
 *
 * @author pkohn
 */
public class sortsApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
         testBubbleSort(); 
         test();
            
    }
    
   
    
    private static void test()
    {
       
        System.out.println(":unsorted array:");
        int [] array = { 91, 20, 3, 65, 71, 11, 8, 52, 49, 68 };         
        showArray(array);
        SarrO s = new SarrO(array);        
        s.bubbleSort();  
        System.out.println("sorted array: " );
        s.display();       
    }
    
    
    private static void testBubbleSort()
    {
        int [] array = { 43, 7, 10, 23, 18, 4, 19, 5, 66, 14 };
        System.out.println("unsorted array:");
        showArray(array);
        
        int []sorted = SarrS.bubbleSort(array);
        System.out.println("sorted array: " );
        showArray(sorted); 
  
    }
    
    private static void showArray(int[] array)
    {
        for (int ix = 0; ix < array.length; ++ix)
        {
            System.out.printf("%5d ", array[ix]);
        }
        System.out.println("");
    }
    
    
    
}
