

package introductiontosorting;

import java.awt.Color;
import java.awt.Graphics;


public class SortViewUtility 
{
    private static void paintInvariant( Graphics g, Invariant i, int size, int ulcx, int ulcy, int width, int height )
    {
        boolean b = i.check();
        double w = width*(3/4.0) / size;
        
        if ( i instanceof RegionInvariant )
        {
            RegionInvariant ri = (RegionInvariant)i;
            int A = ri.getA();
            int B = ri.getB();
            
            if ( b )
            {
                g.setColor( Color.GREEN.brighter() );
            }
            else
            {
                g.setColor( Color.RED.brighter() );
            }
            
            //g.drawRect( 100 + (int)(A*w), 100, (int)((B-A+1)*w), 400 );
            g.drawRect( (int)(ulcx + width/8.0 + A*w), (int)(ulcy + height/6.0), (int)((B-A+1)*w), (int)(height*2/3.0) );
        }
    }
    
    private static void paintInvariants( Graphics g, int size, SortingAlgorithm sortAlgorithm, int ulcx, int ulcy, int width, int height )
    {
        int nv = sortAlgorithm.getNumInvariants();
        for ( int i = 0; i < nv; i++ )
        {
            paintInvariant( g, sortAlgorithm.getInvariant(i), size, ulcx, ulcy, width, height );
        }
    }
    
    private static void paintItem( Graphics g, int itemNumber, int item, int size, Color fill, int ulcx, int ulcy, int width, int height )
    {
        double w = width * (3/4.0) / size;
        double uh = height * (2/3.0) / size;
        g.setColor(fill);
        
        g.fillRect( (int)(ulcx + width/8.0 + (itemNumber * w)), (int)(ulcy + height*5/6.0 - item * uh), Math.max(1, (int) w), (int) (item * uh));
        if ( w > 3 )
        {
            g.setColor(Color.BLACK);
            g.drawRect( (int)(ulcx + width/8.0 + (itemNumber * w)), (int)(ulcy + height*5/6.0 - item * uh), Math.max(1, (int) w), (int) (item * uh));
        }
    }
    
    
    public static void paintSortState( Graphics g, SortingAlgorithm sortAlgorithm, int ulcx, int ulcy, int width, int height )
    {
        int s = sortAlgorithm.getSize();
        
        for ( int i = 0; i < s; i++ )
        {
            int item = sortAlgorithm.getItem( i );
            paintItem( g, i, item, s, Color.BLUE, ulcx, ulcy, width, height );
        }
        
        SortAction sa = sortAlgorithm.getNextAction();
        if (sa != null)
        {
            if (sa instanceof SwapAction)
            {
                SwapAction swap = (SwapAction) sa;
                paintItem(g, swap.getA(), sortAlgorithm.getItem(swap.getA()), s, Color.RED, ulcx, ulcy, width, height );
                paintItem(g, swap.getB(), sortAlgorithm.getItem(swap.getB()), s, Color.RED, ulcx, ulcy, width, height );
            } 
            else if (sa instanceof CompareAction)
            {
                CompareAction comp = (CompareAction) sa;
                paintItem(g, comp.getA(), sortAlgorithm.getItem(comp.getA()), s, Color.GREEN, ulcx, ulcy, width, height );
                paintItem(g, comp.getB(), sortAlgorithm.getItem(comp.getB()), s, Color.GREEN, ulcx, ulcy, width, height );
            }
        }
        
        long numCompares = sortAlgorithm.getNumCompares();
        long numSwaps = sortAlgorithm.getNumSwaps();
        
        g.setColor( Color.BLACK );
        
        //g.drawString( "compares: " + numCompares, 50, 50 );
        g.drawString( "compares:" + numCompares, (int)(ulcx + width/16.0), (int)(ulcy + height/12.0) );
        g.drawString( "swaps: " + numSwaps, (int)(ulcx + width/16.0), (int)(ulcy + height/6.0) );
        
        
        paintInvariants( g, s, sortAlgorithm, ulcx, ulcy, width, height );
    }
}
