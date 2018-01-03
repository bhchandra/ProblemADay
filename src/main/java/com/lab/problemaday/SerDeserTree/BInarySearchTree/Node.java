package com.lab.problemaday.SerDeserTree.BInarySearchTree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 *
 * @author MITRA
 */
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Node<T extends Comparable<T>> {

    T data;
    Node<T> left;
    Node<T> right;
    
    Node(T data){
        this.data = data;
    }
    
}
