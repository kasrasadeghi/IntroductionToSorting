

package introductiontosorting;


public abstract class Invariant
{
    protected int [] arr;
    
    public Invariant( int [] a )
    {
        arr = a;
    }
    
    public abstract boolean check();
    
    public String getInvariantText()
    {
        return "Invariant";
    }
}
