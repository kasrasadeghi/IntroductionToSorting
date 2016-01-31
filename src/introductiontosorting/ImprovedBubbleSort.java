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
public class ImprovedBubbleSort extends SortingAlgorithm
{

    public ImprovedBubbleSort(int size) {
        super(size);
    }

    @Override
    public void sort(int[] arr) 
    {
        // Like BubbleSort, but:
        // a) stop if you go from one side to the other without making any swaps
        // b) on each traversal down the array, stop when you get to the elements 
        //    that are already sorted
        
        for (int i = 0; i < arr.length - 1; ++i) 
            for (int j = 0; j < arr.length - 1 - i; ++j) 
                if (compare(arr, j, j + 1) > 0) {
                    swap(arr, j, j+1);
                }
    }
}
