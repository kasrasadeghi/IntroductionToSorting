

package introductiontosorting;


public abstract class RegionInvariant extends Invariant
{
    protected int A, B;
    
    public RegionInvariant( int [] arr, int a, int b )
    {
        super( arr );
        A = a;
        B = b;
    }
    
    public int getA() { return A; }
    public int getB() { return B; }
    
    public void setA( int a ) { A = a; }
    public void setB( int b ) { B = b; }
    
    public String getInvariantText()
    {
        return super.getInvariantText() + " over indices from " + A + " to " + B;
    }
}
