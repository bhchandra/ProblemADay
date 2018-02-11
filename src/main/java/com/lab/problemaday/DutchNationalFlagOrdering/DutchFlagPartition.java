package com.lab.problemaday.DutchNationalFlagOrdering;

import com.google.common.base.Preconditions;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Rearrange the elements in an array "inList" and an index "pivotIndex" such
 * that all the elements less than inList[pivotIndex]("the pivot") appear first,
 * followed by elements equal to the pivot and followed by elements greater than
 * the pivot.
 *
 * @author MITRA
 */
public class DutchFlagPartition {

    public static <E extends Comparable<E>> void partition(int pivotIndex, List<E> list) {
        Preconditions.checkNotNull(list);
        Preconditions.checkState(pivotIndex >= 0 && pivotIndex < list.size());

        int size = list.size();
        final E pivot = list.get(pivotIndex);

        int smaller = 0;
        for (int i = 0; i < size; i++) {
            if (compare(list.get(i), pivot) < 0) {
                Collections.swap(list, smaller++, i);
            }
        }

        int larger = size - 1;
        for (int i = size - 1; (i >= 0 && (compare(list.get(i), pivot) >= 0)); --i) {
            if (compare(list.get(i), pivot) > 0) {
                Collections.swap(list, larger--, i);
            }
        }

    }

    private static <E extends Comparable> int compare(E a, E b) {
        return a.compareTo(b);
    }

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(0, 1, 2, 0, 2, 1, 1);

        partition(0, list);

        System.out.println(list);

    }

}
