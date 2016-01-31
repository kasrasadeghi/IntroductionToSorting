

package introductiontosorting;


public class SelectionSort extends SortingAlgorithm
{

    public SelectionSort(int size)
    {
        super(size);
    }

    @Override
    public void sort( int [] arr )
    {
        // the first 0 items on the left are in the correct position.
        // starting at the left, moving right
        // find the smallest element to the right of the sorted region and swap 
        // it into the next unsorted position.  Now the sorted region has one more element
        // repeat until you get to the right side of the array
        for (int i = 0; i < arr.length; ++i) {
            int shortest = i;
            for (int j = i; j < arr.length; ++j) {
                if (compare(arr, shortest, j) > 0)
                    shortest = j;
            }
            swap(arr, i, shortest);
        }
        
    }

}
