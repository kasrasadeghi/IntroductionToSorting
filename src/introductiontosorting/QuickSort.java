

package introductiontosorting;


public class QuickSort extends SortingAlgorithm
{

    public QuickSort(int size)
    {
        super(size);
    }

    private void sortHelper( int [] arr, int A, int B )
    {
        // sort the region from A to B
        // let the element in A be the pivot
        // let L = A, R = B
        // the first goal is to get the pivot in the correct spot with everything
        // to the right greater and everything to the left smaller than the pivot
        // We know that everything to the left of the pivot is smaller
        // Starting at R, moving left, find an element which is smaller than the pivot and swap
        // Now, everything to the right of the pivot is greater.
        // Starting at L, moving right, find an element which is greater than the pivot and swap
        // Now everything left of the pivot is greater
        // repeat this process until L >= R
        // sort the left side and the right side of the region
        
       
    }
    @Override
    public void sort( int [] arr )
    {
        quicksort( arr, 0, arr.length-1 );
    }
    
    public void quicksort(int[] arr, int low, int high) {
        if (low < high) {
            int i = low;
            for (int j = low; j < high; j++)
                if (compare(arr, j, high) <= 0) 
                    swap(arr, i++, j);
            swap(arr, i, high);
            int p = i;
            quicksort(arr, low, p - 1);
            quicksort(arr, p+1, high);
        }
    }

}
