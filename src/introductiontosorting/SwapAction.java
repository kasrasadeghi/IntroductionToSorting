

package introductiontosorting;


public class SwapAction extends SortAction
{
    protected int A, B;
    
    public SwapAction( int a, int b )
    {
        A = a;
        B = b;
    }
    
    public int getA() { return A; }
    public int getB() { return B; }
    
}
