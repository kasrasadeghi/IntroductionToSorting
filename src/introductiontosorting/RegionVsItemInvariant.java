

package introductiontosorting;


public class RegionVsItemInvariant extends RegionInvariant
{
    protected int C;
    protected boolean LT;
    
    public RegionVsItemInvariant(int[] arr, int a, int b, int c, boolean lessThan)
    {
        super(arr, a, b);
        C = c;
        LT = lessThan;
    }
    
    public void setC( int c ) { C = c; }

    @Override
    public boolean check()
    {
        for ( int i = A; i <= B; i++ )
        {
            if ( (LT && arr[i] > arr[C]) || (!LT && arr[i] < arr[C] )  )
            {
                return false;
            }
        }
        return true;
    }

}
