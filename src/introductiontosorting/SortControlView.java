

package introductiontosorting;

import apcscvm.DefaultControl;
import apcscvm.View;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;


public class SortControlView extends DefaultControl<SortingAlgorithm> implements View<SortingAlgorithm>
{
    private boolean waitForClicks;
    private double timeToNextEvent;
    
    private int ulcx, ulcy, width, height;
    
    private double TIME_BETWEEN_STEPS;
    
    public SortControlView()
    {
        waitForClicks = true;
        TIME_BETWEEN_STEPS = .01;
        timeToNextEvent = TIME_BETWEEN_STEPS;
    }
    
    public void setTimeBetweenSteps( double tbs )
    {
        TIME_BETWEEN_STEPS = tbs;
    }
    
    public void setDimensions( int W, int H )
    {
        width = W;
        height = H;
    }
    
    public void setULC( int ULCx, int ULCy )
    {
        ulcx = ULCx;
        ulcy = ULCy;
    }
    
    @Override
    public void handleTimePassage( SortingAlgorithm sa, int ea, int dt)
    {
        if ( !waitForClicks )
        {
            if ( !sa.isStarted() )
            {
                sa.go();
            }
            timeToNextEvent -= dt;
            if ( timeToNextEvent <= 0 )
            {
                while ( timeToNextEvent <= 0 )
                {
                    sa.executeNextAction();
                    timeToNextEvent += TIME_BETWEEN_STEPS;
                }
            }
            
        }
        else
        {
            timeToNextEvent = TIME_BETWEEN_STEPS;
        }
    }

    @Override
    public void paint(SortingAlgorithm sa, Graphics g, int w, int h)
    {
        g.setColor( Color.BLACK );
        g.drawRect(0, 0, w-1, h-1);
        
        SortViewUtility.paintSortState( g, sa, 0, 0, w, h );        
    }

    public void go()
    {
        waitForClicks = false;
    }
    
    public void stop()
    {
        waitForClicks = true;
    }
    
    @Override
    public void handleMouseClick( SortingAlgorithm sa, int ea, MouseEvent me )
    {
        int x = me.getX();
        int y = me.getY();
       
        if ( waitForClicks )
        {
            if ( !sa.isStarted() )
            {
                sa.go();
            }
            sa.executeNextAction();
        }
    }
    

}
