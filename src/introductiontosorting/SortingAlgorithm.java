

package introductiontosorting;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;


public abstract class SortingAlgorithm 
{
    private long numSwaps;
    private long numCompares;
    private Semaphore lock;
    private SAThread sortThread;
    private int [] arr;
    private ArrayList<Invariant> invariants;
    private SortAction curAction;
    private boolean needLock;
    
    private class SAThread extends Thread
    {
        SortingAlgorithm THIS;
        int [] arr;
        
        SAThread( SortingAlgorithm This, int [] Arr )
        {
            THIS = This;
            arr = Arr;
        }
        
        @Override
        public void run()
        {
            THIS.sort( arr );
        }
    }
    
    public SortingAlgorithm( int size )
    {
        needLock = true;
        numSwaps = 0;
        numCompares = 0;
        lock = new Semaphore(1);
        try
        {
            lock.acquire();
        } catch (InterruptedException ex)
        {
            
        }
        sortThread = null;
        
        arr = new int[size];
        initializeArray( arr );
        
        invariants = new ArrayList<>();
        
        curAction = null;
    }
    
    protected void initializeArray( int [] Arr )
    {
        
        for ( int i = 0; i < Arr.length; i++ )
        {
            Arr[i] = Arr.length - i;
        }
        
        
        for ( int i = 0; i < Arr.length * 4; i++ )
        {
            swapReal( Arr, (int)(Math.random()*Arr.length), (int)(Math.random()*Arr.length) );
        }
                
    }
    
    public void go()
    {
        sortThread = new SAThread( this, arr );
        sortThread.start();
    }
    
    public void goFast()
    {
        needLock = false;
        sort( arr );
    }
    
    public boolean isStarted()
    {
        return sortThread != null;
    }
    
    public boolean isDone()
    {
        return curAction != null;
    }
    
    public void executeNextAction()
    {
        if ( sortThread.isAlive() )
        {
            lock.release( 1 );
        }
        else
        {
            curAction = null;
        }
        
    }
    
    public abstract void sort( int [] arr );
    
    protected int compare( int [] arr, int i1, int i2 )
    {
        try
        {
            curAction = new CompareAction( i1, i2 );
            if ( needLock )
            {
                lock.acquire();
            }
            numCompares++;
            return (int)(Math.signum( arr[i1] - arr[i2] ));
        } catch (InterruptedException ex)
        {
            return -2;
        }
    }
    
    private static void swapReal( int [] arr, int i1, int i2 )
    {
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }
    
    protected void swap( int [] arr, int i1, int i2 )
    {
        try
        {
            curAction = new SwapAction( i1, i2 );
            if ( needLock )
            {
                lock.acquire();
            }
            numSwaps++;
            swapReal( arr, i1, i2 );
        }
        catch ( InterruptedException ex )
        {
            
        }
    }
    
    protected void addInvariant( Invariant i )
    {
        invariants.add( i );
    }
    
    protected void removeInvariant( Invariant i )
    {
        invariants.remove( i );
    }
    
    public int getNumInvariants() { return invariants.size(); }
    
    public Invariant getInvariant( int i ) { return invariants.get( i ); }
    
    public long getNumSwaps() { return numSwaps; }
    public long getNumCompares() { return numCompares; }
   
    public int getItem( int i )
    {
        return arr[i];
    }
    
    public SortAction getNextAction()
    {
        return curAction;
    }
    
    public int getSize() { return arr.length; }
    
}
