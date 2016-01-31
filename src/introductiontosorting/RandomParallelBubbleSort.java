

package introductiontosorting;

import java.util.logging.Level;
import java.util.logging.Logger;


public class RandomParallelBubbleSort extends SortingAlgorithm
{

    public RandomParallelBubbleSort(int size)
    {
        super(size);
    }

    private class RPBSThread extends Thread
    {
        private int A;
        int [] Arr;
        
        public RPBSThread( int [] arr, int a ) 
        { 
            A = a;
            Arr = arr;
        }
        
        @Override
        public void run()
        {
            while ( true )
            {
                if ( compare( Arr, A, A+1 ) > 0 )
                {
                    swap( Arr, A, A+1 );
                }
                try
                {
                    sleep( (int)(Math.random() * 100) );
                } catch (InterruptedException ex)
                {
                    
                }
            }
        }
    }
    
    @Override
    public void sort(int[] arr)
    {
        for ( int i = 0; i < arr.length-1; i++ )
        {
            new RPBSThread( arr, i ).start();
        }
        while ( true ) { }
    }

}
