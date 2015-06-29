package com.dutch;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] array = new int[] { 1, 1, 3, 2 };
        dutchFlag(array, 2);
        System.out.println(Arrays.toString(array));

    }

    // http://www.csse.monash.edu.au/~lloyd/tildeAlgDS/Sort/Flag/
    private static void dutchFlag(int[] array, int white) {
        int lo = 0;
        int hi = array.length - 1;
        int mid = 0;
        // While there is at least one element in the unknown region.
        while (mid <= hi) {
            if (array[mid] > white) {
                // Prepend to the blue region, decrement the left bound of the region.
                swap(array, mid, hi);
                hi--;
                // We don't shrink the unknown region from the left (mid++) because
                // array[mid] was prepended to the blue region, and something unknown came to the
                // index mid instead of array[mid]
            } else if (array[mid] < white) {
                // Append to the red region, increment the bound of the region.
                // mid++ ??? because we don't need to examine the same element
                // twice
                swap(array, mid, lo);
                mid++;
                lo++;
            } else {
                // Shrink the unknown region
                mid++;
            }
        }
    }

    /*
     * Case (0) a[Mid] is red <, swap a[Lo] and a[Mid]; Lo++; Mid++
     * 
     * 
     * 
     * Case (1) a[Mid] is white, Mid++
     * 
     * 
     * Case (2) a[Mid] is blue >, swap a[Mid] and a[Hi]; Hi--
     */

    private static void swap(int array[], int m, int n) {
        int t = array[m];
        array[m] = array[n];
        array[n] = t;
    }

}
