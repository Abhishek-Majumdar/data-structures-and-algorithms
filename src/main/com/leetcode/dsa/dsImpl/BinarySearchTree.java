package main.com.leetcode.dsa.dsImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class BinarySearchTree {
    Node root;

    private class Node{
        int data;
        Node left;
        Node right;

        public Node(int data, Node left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public BinarySearchTree(){
        this.root = null;
    }

    public BinarySearchTree(int data){
        this.root = new Node(data, null, null);
    }

    public void insert(int data){
        if(this.root == null){
            this.root = (new BinarySearchTree(data)).root;
            return;
        }

        Node currentNode = this.root;
        while(currentNode != null){
            if(currentNode.left == null && data <= currentNode.data){
                currentNode.left = new Node(data, null, null);
                return;
            }
            else if(currentNode.right == null && data > currentNode.data){
                currentNode.right = new Node(data, null, null);
                return;
            }
            else
                currentNode = data < currentNode.data ? currentNode.left : currentNode.right;
        }
    }

    public Node contains(int data){
        Node currentNode = this.root;
        while(currentNode != null){
            if(currentNode.data == data)
                return currentNode;
            currentNode = data < currentNode.data ? currentNode.left : currentNode.right;
        }
        return null;
    }

    //TODO
    public void remove(int data){
        if(this.contains(data) == null)
            return;

        if(this.root.data == data)
            this.root = null;

        Node nodeToRemove = this.contains(data);
        Node currentNode = this.root;
        boolean isLeaf = false;
        boolean hasSingleChild = false;

        while(currentNode != null){
            isLeaf = nodeToRemove.right == null && nodeToRemove.left == null;
            hasSingleChild = nodeToRemove.right == null || nodeToRemove.left == null;

            if(currentNode.left == nodeToRemove){
                //Simplest case when node to remove is a leaf
                if(isLeaf)
                    currentNode.left = null;
                //When node to remove has only one child; bypass
                else if(hasSingleChild){

                }
                //For removing nodes with 2 children; decide successor/predecessor
                else{

                }
            }

            if(currentNode.right == nodeToRemove){
                //Simplest case when node to remove is a leaf
                if(isLeaf)
                    currentNode.right = null;
                //When node to remove has only one child; bypass
                else if(hasSingleChild){

                }
                //For removing nodes with 2 children; decide successor/predecessor
                else{

                }
            }
            currentNode = data < currentNode.data ? currentNode.left : currentNode.right;
        }

    }

    public List<Integer> breadthFirstSearch(){
        if(this.root == null)
            return null;

        List<Integer> seenData = new ArrayList<>();
        List<Node> searchQueue = new ArrayList<>();
        Node currentNode = this.root;
        searchQueue.add(currentNode);

        while(searchQueue.size() > 0){
            currentNode = searchQueue.remove(0);
            seenData.add(currentNode.data);
            if(currentNode.left != null)
                searchQueue.add(currentNode.left);
            if(currentNode.right != null)
                searchQueue.add(currentNode.right);
        }

        return seenData;
    }

    private List<Integer> breadthFirstSearchRecursive(List<Node> searchQueue, List<Integer> seenData){
        if(this.root == null)
            return Collections.emptyList();

        if(searchQueue.isEmpty())
            return seenData;
        Node currentNode = searchQueue.remove(0);
        seenData.add(currentNode.data);
        if(currentNode.left != null)
            searchQueue.add(currentNode.left);
        if(currentNode.right != null)
            searchQueue.add(currentNode.right);

        return breadthFirstSearchRecursive(searchQueue, seenData);
    }

    public List<Integer> breadthFirstSearchRecursive(){
        List<Node> queue = new ArrayList<>();
        queue.add(this.root);

        return this.breadthFirstSearchRecursive(queue, new ArrayList<>());
    }

    private List<Integer> depthFirstSearchInOrder(Node node, List<Integer> seenData){
        if(node.left != null){
            depthFirstSearchInOrder(node.left, seenData);
        }
        seenData.add(node.data);
        if(node.right != null){
            depthFirstSearchInOrder(node.right, seenData);
        }
        return seenData;
    }

    public List<Integer> depthFirstSearchInOrder(){
        return this.depthFirstSearchInOrder(this.root, new ArrayList<>());
    }

    private List<Integer> depthFirstSearchPreOrder(Node node, List<Integer> seenData){
        seenData.add(node.data);
        if(node.left != null){
            depthFirstSearchPreOrder(node.left, seenData);
        }
        if(node.right != null){
            depthFirstSearchPreOrder(node.right, seenData);
        }

        return seenData;
    }

    public List<Integer> depthFirstSearchPreOrder(){
        return this.depthFirstSearchPreOrder(this.root, new ArrayList<>());
    }

    private List<Integer> depthFirstSearchPostOrder(Node node, List<Integer> seenData){
        if(node.left != null){
            depthFirstSearchPostOrder(node.left, seenData);
        }
        if(node.right != null){
            depthFirstSearchPostOrder(node.right, seenData);
        }
        seenData.add(node.data);

        return seenData;
    }

    public List<Integer> depthFirstSearchPostOrder(){
        return this.depthFirstSearchPostOrder(this.root, new ArrayList<>());
    }

    public boolean validateBinarySearchTree(){
        boolean result = false;


        return result;
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(9);
        bst.insert(4);
        bst.insert(20);
        bst.insert(15);
        bst.insert(1);
        bst.insert(6);
        bst.insert(170);

        /*System.out.println(bst);
        System.out.println(bst.contains(20) != null);*/

        System.out.println(bst.depthFirstSearchPostOrder());
    }
}
