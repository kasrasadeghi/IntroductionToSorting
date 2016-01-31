/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package introductiontosorting;

import apcscvm.CVMProgram;

/**
 *
 * @author dstigant
 */
public class IntroductionToSorting
{

    public static void launchSortWindow( SortingAlgorithm sort, String title )
    {
        SortControlView cv = new SortControlView();
        new CVMProgram( "Sorting Demo - " + title, 800, 600, cv, cv, sort ).start();
    }
    
    public static void launchComparisonWindow( SortingAlgorithm s1, SortingAlgorithm s2, SortingAlgorithm s3, SortingAlgorithm s4 )
    {
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException
    {
        SortGUI.main( args );
    }
    
}
