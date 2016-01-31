

package introductiontosorting;


public class AscendingRegionInvariant extends RegionInvariant
{

    public AscendingRegionInvariant(int [] arr, int a, int b)
    {
        super(arr, a, b);
    }

    @Override
    public boolean check()
    {
        for ( int i = A; i < B - 1; i++ )
        {
            if ( arr[i] > arr[i+1] )
            {
                return false;
            }
        }
        return true;
    }
    
    public String getInvariantText()
    {
        return super.getInvariantText() + " is increasing";
    }

}
