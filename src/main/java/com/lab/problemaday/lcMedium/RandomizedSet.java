package com.lab.problemaday.lcMedium;


import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
public class RandomizedSet {

    private final List<Integer> valuesList;
    private final Map<Integer, Integer> valueToIndex;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        valuesList = new ArrayList<>();
        valueToIndex = new HashMap<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {

        if (valueToIndex.containsKey(val)) return false;

        valuesList.add(val);

        int index = valuesList.size() - 1;
        valueToIndex.put(val, index);

        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {

        if (!valueToIndex.containsKey(val)) return false;

        Integer index = valueToIndex.get(val);
        int lastIndex = valuesList.size() - 1;
        Collections.swap(valuesList, index, lastIndex);

        Integer swappedValue = valuesList.get(index);
        valueToIndex.put(swappedValue, index); //update index of the swapped value

        valueToIndex.remove(val);
        valuesList.remove(lastIndex); //O(1) deletion for the last index

        return true;

    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        if (valuesList.isEmpty()) throw new IllegalStateException("set is empty!");

        int index = ThreadLocalRandom.current().nextInt(valuesList.size());

        return valuesList.get(index);
    }

    public static void main(String[] args) {
        RandomizedSet set = new RandomizedSet();

        assert set.remove(1) == false;
        assert set.remove(2) == false;

        assert set.insert(1) == true;

        assert set.insert(1) == false;

        set.getRandom(); //no exception

        assert set.remove(1) == true;

        assert set.remove(2) == false;

    }

}


