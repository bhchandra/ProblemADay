package com.lab.problemaday.SerDeserTree;

import com.lab.problemaday.SerDeserTree.BInarySearchTree.Node;
import com.lab.problemaday.SerDeserTree.BInarySearchTree.Tree;

/**
 * Given the root to a binary tree, implement serialize(root), which serializes
 * the tree into a string, and deserialize(s), which deserializes the string
 * back into the tree.
 *
 * @author Mitra
 */
public class BinaryTreeSerDeser {

    /**
     * Node(1, Node(2), Node(3)) to 1 2 # # 3 # #.
     * <br> uses # to indicate empty leaf nodes.
     * @param <T>
     * @param root
     * @return
     */
    public <T extends Comparable<T>> String serialize(Node<T> root) {
        if (root == null) {
            return "#";
        }
        return String.format("%s %s %s", root.getData(), serialize(root.getLeft()), serialize(root.getRight()));
    }
    
    //TODO: 
    public <T extends Comparable<T>, Number> Tree<T> deserialize(String treeData, Class<T> nodeDataType) {
        if (treeData == null) {
            return null;
        }

        String[] data = treeData.split(" ");
        
        Tree<T> tree = new Tree<>();
        
        tree.setRoot(deserializeHelper(data, nodeDataType, 0));
        
        return tree;
    }
    
    //TODO:
    private <T extends Comparable<T>, Number> Node<T> deserializeHelper(String[] data, Class<T> nodeDataType, int index){
        
        if(data[index].equals("#")){
            return null;
        }
        Node<T> node = new Node<>();
        
       
        node.setData(nodeDataType.cast(Double.parseDouble(data[index])));
        node.setLeft(deserializeHelper(data, nodeDataType, index+1));
        node.setRight(deserializeHelper(data, nodeDataType, index+2));
        
        return node;
    }
}
