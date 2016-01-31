/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package introductiontosorting;

/**
 *
 * @author DSTIGANT
 */
public class SortingAlgorithmEnvelope extends SortingAlgorithm
{
    private SortingAlgorithm containedAlgorithm;

    public SortingAlgorithmEnvelope( SortingAlgorithm sa ) {
        super(0);
        containedAlgorithm = sa;
    }
    
    public void setSortingAlgorithm( SortingAlgorithm sa )
    {
        containedAlgorithm = sa;
    }
    
    
    public void go()
    {
        containedAlgorithm.go();
    }
    
    public void goFast()
    {
        containedAlgorithm.goFast();
    }
    
    public boolean isStarted()
    {
        return containedAlgorithm.isStarted();
    }
    
    public boolean isDone()
    {
        return containedAlgorithm.isDone();
    }
    
    public void executeNextAction()
    {
        containedAlgorithm.executeNextAction();
    }
        
    protected int compare( int [] arr, int i1, int i2 )
    {
        return containedAlgorithm.compare( arr, i1, i2);
    }
    
    protected void swap( int [] arr, int i1, int i2 )
    {
        containedAlgorithm.swap( arr, i1, i2 );
    }
    
    protected void addInvariant( Invariant i )
    {
        containedAlgorithm.addInvariant( i );
    }
    
    protected void removeInvariant( Invariant i )
    {
        containedAlgorithm.removeInvariant( i );
    }
    
    public int getNumInvariants() { return containedAlgorithm.getNumInvariants(); }
    
    public Invariant getInvariant( int i ) { return containedAlgorithm.getInvariant(i); }
    
    public long getNumSwaps() { return containedAlgorithm.getNumSwaps(); }
    public long getNumCompares() { return containedAlgorithm.getNumCompares(); }
   
    public int getItem( int i )
    {
        return containedAlgorithm.getItem( i );
    }
    
    public SortAction getNextAction()
    {
        return containedAlgorithm.getNextAction();
    }
    
    public int getSize() { return containedAlgorithm.getSize(); }
    
    @Override
    public void sort(int[] arr) 
    {
        containedAlgorithm.sort( arr );
    }
    
}
