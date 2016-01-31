

package introductiontosorting;


public class CompareAction extends SortAction
{
    protected int A, B;
    public CompareAction( int a, int b )
    {
        A = a;
        B = b;
    }
    
    
    public int getA() { return A; }
    public int getB() { return B; }
}
