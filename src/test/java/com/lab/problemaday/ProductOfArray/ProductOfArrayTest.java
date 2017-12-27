package com.lab.problemaday.ProductOfArray;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author MITRA
 */
public class ProductOfArrayTest {

    public ProductOfArrayTest() {
    }

    /**
     * Test of productArray method
     */
    @Test
    public void testProductArray() {
        System.out.println("productArray");
        //1.
        int[] arr = new int[]{1, 2, 3, 4, 5};
        long[] expResult = new long[]{120, 60, 40, 30, 24};
        long[] result = ProductOfArray.productArray(arr);
        assertArrayEquals(expResult, result);

        //2.
        int[] arr2 = new int[]{3, 2, 1};
        long[] expResult2 = new long[]{2, 3, 6};
        long[] result2 = ProductOfArray.productArray(arr2);
        assertArrayEquals(expResult2, result2);

    }

}
