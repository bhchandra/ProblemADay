package com.lab.problemaday.SerDeserTree.BInarySearchTree;

/**
 *
 * @author MITRA
 * @param <T>
 */
public class Tree<T extends Comparable<T>> {

    private Node<T> root;

    public void insert(T d) {
        root = insert(root, d);
    }

    private Node<T> insert(Node<T> node, T d) {
        if (node == null) {
            return new Node<>(d);
        }

        if (node.data.compareTo(d) == 0) {
            return node;
        }

        if (node.data.compareTo(d) > 0) {
            node.right = insert(node.right, d);
        } else {
            node.left = insert(node.left, d);
        }

        return node;
    }

    public boolean search(T d) {
        return search(root, d);
    }

    private boolean search(Node<T> node, T d) {
        if (node == null) {
            return false;
        }

        if (node.data.compareTo(d) == 0) {
            return true;
        }

        if (node.data.compareTo(d) > 0) {
            return search(node.right, d);
        } else {
            return search(node.left, d);
        }

    }

    public void delete(T data) {
        root = delete(root, data);
    }

    private Node<T> delete(Node<T> node, T d) {
        if (node == null) {
            throw new RuntimeException("node to delete cannot be null");
        }
        if (node.data.compareTo(d) > 0) {
            node.right = delete(node.right, d);
        } else if (node.data.compareTo(d) < 0) {
            node.left = delete(node.left, d);
        } else {
            //single child/
            if (node.right == null) {
                return node.left;
            } else if (node.left == null) {
                return node.right;
            //two childs/
            } else {
                node.data = inorderSuccesor(node.right);
                node.right = delete(node.right, node.data);
            }

        }
        return node;
    }

    private T inorderSuccesor(Node<T> n) {
        while (n.left != null) {
            n = n.left;
        }
        return n.data;
    }

}
