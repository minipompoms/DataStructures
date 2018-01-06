

package sorts;

/**
 *
 * @author akatz17
 * modifications by @pkohn
 */
public class SarrO 
{
    private final int [] array;

    /**
     *
     * @param xArray 
     */
    public SarrO(int[] xArray)
    {
        array = xArray;
    }

    /**
     *
     * @return the array
     */
    public int[] getArray()
    {
        return array;
    }
    
    /**
     *
     */
    public void display()
    {
        for (int ix = 0; ix < array.length; ++ix)
        {        
            System.out.printf("%5d ", array[ix]);
        }
        System.out.println(" ");
    }
    
    /**
     *
     */
    public void bubbleSort()
    {
        int ixinn;      // outer loop index
        int ixout;      // inner loop index
        
        for (ixout = array.length-1; ixout > 1; ixout--)    // start at last value
        {
            for (ixinn = 0; ixinn < ixout; ixinn++)         // if right value > left
            {
                if (array[ixinn] > array[ixinn+1])
                {
                    swap(ixinn, ixinn+1);                   // call to swap
                }
            }
        }
    }
    
    /**
     *
     * @param left index value
     * @param right index value
     */
    public void swap(int left, int right)
    {
        int temp = array[right];
        array[right] = array[left];
        array[left] = temp;
    }
    
    /**
     *
     * @param target
     * @return
     */
    public int binarySearch(int target)
    {
        int index = -1;
        Direction dir = null;
        if (array.length > 0)
        {
            int leftix = 0;
            int rightix = array.length - 1;

            while (leftix <= rightix)
            {
                int mIndex = (rightix + leftix) / 2;
                int mValue = array[mIndex];
                if (mValue == target)
                {
                    index = mIndex;
                    break;
                }
                else if (mValue < target)
                {
                    if (dir == Direction.ASC)
                    {
                        leftix = mIndex + 1;
                    }
                    else
                    {
                        rightix = mIndex - 1;
                    }
                }

                else
                {
                    if (dir == Direction.ASC)
                    {
                        rightix = mIndex - 1;
                    }
                    else
                    {
                        leftix = mIndex + 1;
                    }
                }
            }

        }
        return index;
    }
    

}
