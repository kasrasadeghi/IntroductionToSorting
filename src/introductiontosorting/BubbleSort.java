

package introductiontosorting;


public class BubbleSort extends SortingAlgorithm
{

    public BubbleSort(int size)
    {
        super(size);
    }

    @Override
    public void sort( int [] arr )
    {
        // Starting at the left side of the array, moving right
        // compare neighbors and if they are out of order, swap them
        // When you reach the right side of the array, you will have
        // moved one more element to the correct position in the array
        // If there are N elements, you must repeat this process N times
        for (int i = 0; i < arr.length - 1; ++i) 
            for (int j = 0; j < arr.length - 1; ++j) 
                if (compare(arr, j, j + 1) >0) {
                    swap(arr, j, j+ 1);
                }
    }
}
