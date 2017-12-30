

package sorts;

/**
 *
 * @author akatz17
 */
public class SarrO 
{
    private int [] array;

    public SarrO(int[] xArray)
    {
        array = xArray;
    }

    public int[] getArray()
    {
        return array;
    }
    
    public void bubbleSort()
    {
        int ixinn;
        int ixout;
        
        for (ixout = array.length-1; ixout > 1; ixout--)
        {
            for (ixinn = 0; ixinn < ixout; ixinn++)
            {
                if (array[ixinn] > array[ixinn+1])
                {
                    swap(ixinn, ixinn+1);
                }
            }
        }
    }
    
    public void swap(int left, int right)
    {
        int temp = array[right];
        array[right] = array[left];
        array[left] = temp;
    }
    
    public int BinarySearch(int target)
    {
        return -1;
    }

}
