package sorts;

/**
 * static methods to manipulate arrays passed to these methods
 *
 * @author MCO264
 */
public class SarrS
{

    public static int[] bubbleSort(int[] array)
    {
        int ixout;  //index for outer loop
        int ixinn;  //index for inner loop
        
        for(ixout = array.length-1; ixout > 1; ixout--) //start at last value
        {
            for(ixinn = 0; ixinn < ixout; ixinn++) 
            {
                if (array[ixinn] > array[ixinn+1])      //if right value > left
                {
                    swap(ixinn, ixinn+1, array);        //call to swap
                }
            }
          
        }
        return array;
    }
    
    public static void swap(int left, int right, int []array)
    {
        int temp = array[right];        //hold value to swap
        array[right] = array[left];     //move higher value to right
        array[left] = temp;             //complete swap by moving lesser value to the left
        
    }

    public static int[] insertSort(int[] array)
    {
        return array;
    }

    public static int [] mergeSort(int [] array)
    {
        // make a copy of the original
        int [] another = new int[array.length];
        for (int ix = 0; ix < array.length; ++ix)
        {
            another[ix] = array[ix];
        }
        
        // sort the copy
        msort(0, another.length-1, another);
        return another;
    }
    
    
    private static void msort(int left, int rite, int [] array)
    {
        
        int size = rite - left;
        int midl = (left + rite )/2;
        
        if (size == 1) 
        {
            if (array[left] < array[rite]) //if left element less than right element
            {
               
                int tmp = array[left]; //hold value of the left element
                
                array[left] = array[rite]; //assign greater value from right side of array
                array[rite] = tmp;  //complete swap with lesser value held in tmp           
            }
        }
        else if (size > 1)
        {
            
            
            msort(left, midl, array);
          
            msort (midl+1, rite, array);
            
            merge(left,midl, midl+1, rite, array);
       
        }
        
    }
    private static void merge(int lmin, int lmax, int rmin, int rmax, int [] array)
    {
        int  []  tmpArr = new int[array.length];
        int ixl = lmin;
        int ixr = rmin;
        int ixt = 0;
        
        while (ixl <= lmax && ixr <= rmax) 
        {
           
            if (array[ixl] > array[ixr])
            {
                tmpArr[ixt++] = array[ixl++];
                
            }
            else
            {
                tmpArr[ixt++] = array[ixr++];
            }
        }
        
        // only one of these two loops will actually run
        while (ixl <= lmax)
        {
            tmpArr[ixt++]= array[ixl++];
        }
        
        while (ixr <= rmax)
        {
            tmpArr[ixt++]= array[ixr++];
        }
        
        
        // now copy back from tmpArr
         ixt = 0;
        for (int ix = lmin; ix <= rmax; ++ix)
        {
            array[ix] = tmpArr[ixt++];
         
        }
       
    }
    
    /**
     * return the index of target in array
     *
     * @param array : int[] - array to search
     * @param target : int - element to search in array
     * @return : int - index, -1 if not found
     */
    public static int binarySearch(int[] array, int target)
    {
        return binarySearch(array, target, Direction.ASC);
    }

    public static int binarySearch(int[] array, int target, Direction dir)
    {
        int index = -1;
        if (array.length > 0)
        {
            int lIndex = 0;
            int rIndex = array.length - 1;

            while (lIndex <= rIndex)
            {
                int mIndex = (rIndex + lIndex) / 2;
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
                        lIndex = mIndex + 1;
                    }
                    else
                    {
                        rIndex = mIndex - 1;
                    }
                }

                else
                {
                    if (dir == Direction.ASC)
                    {
                        rIndex = mIndex - 1;
                    }
                    else
                    {
                        lIndex = mIndex + 1;
                    }
                }
            }

        }
        return index;
    }
}
