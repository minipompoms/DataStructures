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
        testMergeSort();
        testBubbleSortSarrO();
        testBinarySearch();
            
    }
    
   
    private static void testBinarySearch()
    {
        int [] array = { 100, 150, 200, 225, 250, 50, 300, 125, 175, 275, 25};
        System.out.println("\nArray values:");
        showArray(array);    
        int key = 150;
       
        SarrO b = new SarrO(array);         
        b.bubbleSort();   
        int index = b.index(array, key);    
        
        System.out.println("\nNumber " + key + " found in slot " + (index+1));
        b.display();

    }
   
    private static void testBubbleSort()
    {
        int [] array = { 43, 7, 10, 23, 18, 4, 19, 5, 66, 14, 1 };
        System.out.println("\nunsorted array:");
        showArray(array);
        
        int []sorted = SarrS.bubbleSort(array);
        System.out.println("\n(bubbleSort) sorted array: " );
        showArray(sorted); 
    }
    
    private static void testBubbleSortSarrO()
    {
        System.out.println("\n:unsorted array:");
        int [] arrayB = { 91, 20, 3, 65, 71, 11, 8, 52, 49, 68, 2 };         
        showArray(arrayB);
        SarrO b = new SarrO(arrayB);        
        b.bubbleSort();  
        System.out.println("\n(SarrO bubbleSort) sorted array: " );
        b.display();
    }
    
    private static void testMergeSort()
    {
        int [] array = { 28, 88, 1, 40, 309, 31, 93, 10, 222, 6, 777 };
        System.out.println("\nunsorted array:");
        showArray(array);
        
        int[] sorted = SarrS.mergeSort(array);
        System.out.println("\n(mergeSort) descending sorted array:" );
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
