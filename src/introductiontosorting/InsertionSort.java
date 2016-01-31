

package introductiontosorting;


public class InsertionSort extends SortingAlgorithm
{

    public InsertionSort(int size)
    {
        super(size);
    }

    @Override
    public void sort( int [] arr )
    {
        // We start with the first element is sorted (but not necessarily in its final spot)
        // Starting with the second element and moving right:
        // compare and swap the target element with its left neighbor until it is greater than its left neighbor
        // now we have one more element in the sorted region on the left
        // repeat the process with next element to the right of the sorted region
        
        for (int i = 1; i < arr.length; ++i) 
            for (int j = i; j > 0 && compare(arr, j-1, j) > 0; --j)
                swap(arr, j, j-1);
    }

}
