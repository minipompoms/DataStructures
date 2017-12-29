package sorts;

import java.io.*;

/**
 *
 * @author katz
 */
public class Sarr
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {

       // testArray();
       //searchArray();
       testBubbleSort(); 
        
        
        
        

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
    private static void testArray()
    {
        int[] array =
        {
            2, 13, 5, 7, 11, 23, 17, 29, 31, 6, 12, 18, 24, 1, 3, 4, 30
        };
        System.out.println("unsorted array:");
        showArray(array);
        
        int[] sorted = SarrS.mergeSort(array);
        
        System.out.println("sorted array:");
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

    private static void searchArray()
    {
        int[] array =
        {
            2, 3, 5, 7, 11, 13, 17, 23, 29, 31
        };

        for (int ix = 0; ix < 33; ++ix)
        {
            int index = SarrS.binarySearch(array, ix, Direction.ASC);
            System.out.printf("%d  index in array:  %d\n", ix, index);
        }
    }
}
