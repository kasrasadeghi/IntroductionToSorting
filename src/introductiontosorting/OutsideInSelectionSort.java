

package introductiontosorting;


public class OutsideInSelectionSort extends SortingAlgorithm
{

    public OutsideInSelectionSort(int size)
    {
        super(size);
    }

    @Override
    public void sort(int[] arr)
    {
        int i = 0;
        int j = arr.length - 1;
        
        while ( i <= j )
        {
            int minIndex = i;
            int maxIndex = i;
            
            for ( int k = i + 1; k <= j; k++ )
            {
                if ( compare(arr, minIndex, k) > 0 )
                {
                    minIndex = k;
                }
                else if ( compare( arr, k, maxIndex ) > 0 )
                {
                    maxIndex = k;
                }
            }
            
            if ( minIndex != i )
            {
                swap( arr, i, minIndex );
            }
            if ( maxIndex != j )
            {
                if ( maxIndex == i )
                {
                    swap( arr, j, minIndex );
                }
                else
                {
                    swap( arr, j, maxIndex );
                }
            }
            i++;
            j--;
        }
    }

}
