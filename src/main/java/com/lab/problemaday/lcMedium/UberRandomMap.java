package com.lab.problemaday.lcMedium;

import lombok.AllArgsConstructor;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Asked by Uber
 *
 * <p>
 * https://leetcode.com/discuss/interview-question/297880/uber-phone-interview-map-with-getrandom-api
 * <p>
 * Not my solution
 */
public class UberRandomMap {

    // Design a data structure that supports all following operations in average O(1) time:

    /**
     * class RandomMap {
     * void put(int key, int value);
     * Integer get(int key);
     * Integer getRandom(); // this should return a random value with equal probability
     * void remove(int key);
     * }
     */

    @AllArgsConstructor(staticName = "of")
    private static class KeyValue {
        private int key;
        private int value;
    }

    //
    private final Map<Integer, Integer> keyToIndex;
    private final List<KeyValue> keyValues;


    private UberRandomMap() {
        keyToIndex = new HashMap<>();
        keyValues = new ArrayList<>();
    }

    public static UberRandomMap create() {
        return new UberRandomMap();
    }


    void put(int key, int value) {

        //if the key is already present, change the mapping of the new value
        Integer index = keyToIndex.get(key);
        if (index != null) {
            KeyValue keyValue = keyValues.get(index);
            keyValue.value = value;
        } else {
            keyValues.add(KeyValue.of(key, value));
            keyToIndex.put(key, keyValues.size() - 1);
        }
    }

    Integer get(int key) {
        Integer index = keyToIndex.get(key);
        if (index == null) return null;
        else return keyValues.get(index).value;
    }

    Integer getRandom() { // this should return a random value with equal probability

        if (keyValues.isEmpty()) throw new IllegalStateException("can't call getRandom on an empty map.");

        int index = ThreadLocalRandom.current().nextInt(keyValues.size());

        return keyValues.get(index).value;

    }

    void remove(int key) {

        if (!keyToIndex.containsKey(key)) return;

        Integer index = keyToIndex.get(key);

        int lastIndex = keyValues.size() - 1;

        Collections.swap(keyValues, index, lastIndex);

        keyValues.remove(lastIndex); //since it is the last index, it just nullifies the entry.
        keyToIndex.remove(key);
    }


    public static void main(String[] args) {


        UberRandomMap map = UberRandomMap.create();

        map.put(1, 10);
        map.put(2, 20);
        map.put(3, 30);
        map.put(4, 40);
        map.put(5, 50);


        assert map.get(1) == 10;
        assert map.get(2) == 20;

        map.put(1, 11);

        assert map.get(1) == 11;


        assert map.getRandom() != null;


    }

}
