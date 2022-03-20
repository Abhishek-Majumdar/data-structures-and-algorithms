package main.com.leetcode.dsa.dsImpl;

import java.util.*;

class Node{
    int data;

    public Node(int data){
        this.data = data;
    }
}

public class Graph {
    int numberOfNodes;
    Map<Node, Set<Node>> adjacentList;

    public Graph(){
        this.numberOfNodes = 0;
        this.adjacentList = new Hashtable<>();
    }

    public void addVertex(Node vertex){
        if(! this.adjacentList.containsKey(vertex)) {
            this.numberOfNodes += 1;
            this.adjacentList.put(vertex, new HashSet<>());
        }
    }

    public void addEdge(Node node1, Node node2){
        if(this.adjacentList.containsKey(node1)) {
            this.adjacentList.get(node1).add(node2);
        }

        if(this.adjacentList.containsKey(node2)) {
            this.adjacentList.get(node2).add(node1);
        }
    }

    public List<Integer> breadthFirstSearch(Node node){
        if(node == null)
            return Collections.emptyList();

        Node currentNode = node;
        List<Integer> seenData = new ArrayList<>();
        Set<Node> visitedNodes = new HashSet<>();
        List<Node> searchQueue = new ArrayList<>();
        searchQueue.add(currentNode);

        while(!searchQueue.isEmpty()){
            currentNode = searchQueue.remove(0);
            visitedNodes.add(currentNode);
            seenData.add(currentNode.data);

            if(this.adjacentList.get(currentNode) != null && !this.adjacentList.get(currentNode).isEmpty())
                for(Node connNode : this.adjacentList.get(currentNode)){
                    if(! searchQueue.contains(connNode) && ! visitedNodes.contains(connNode))
                        searchQueue.add(connNode);
                }
        }

        return seenData;
    }

    private List<Integer> depthFirstSearchPreOrder(Node node, List<Integer> seenList, Set<Node> visitedNodes){
        if(node == null)
            return Collections.emptyList();

        visitedNodes.add(node);
        seenList.add(node.data);
        if(this.adjacentList.get(node) != null && ! this.adjacentList.get(node).isEmpty()){
            this.adjacentList.get(node).stream().filter(tmpNode -> !visitedNodes.contains(tmpNode))
                    .forEach(fltrTmpNode -> depthFirstSearchPreOrder(fltrTmpNode, seenList, visitedNodes));
        }

        return seenList;
    }

    public List<Integer> depthFirstSearchPreOrder(Node node){
        return this.depthFirstSearchPreOrder(node, new ArrayList<>(), new HashSet<>());
    }

    private List<Integer> depthFirstSearchPostOrder(Node node, List<Integer> seenList, Set<Node> visitedNodes){
        if(node == null)
            return Collections.emptyList();

        visitedNodes.add(node);
        if(this.adjacentList.get(node) != null && ! this.adjacentList.get(node).isEmpty()){
            this.adjacentList.get(node).stream().filter(tmpNode -> !visitedNodes.contains(tmpNode))
                    .forEach(fltrTmpNode -> depthFirstSearchPostOrder(fltrTmpNode, seenList, visitedNodes));
        }
        seenList.add(node.data);

        return seenList;
    }

    public List<Integer> depthFirstSearchPostOrder(Node node){
        return this.depthFirstSearchPostOrder(node, new ArrayList<>(), new HashSet<>());
    }

    public void showConnections(){
        Set<Node> vertices = this.adjacentList.keySet();
        List<Integer> tmpList = new ArrayList<>();
        for(Node vertex : vertices){
            this.adjacentList.get(vertex).forEach(connection -> tmpList.add(connection.data));
            System.out.println(String.format("%s ---> %s", vertex.data, Arrays.toString(tmpList.toArray())));
            tmpList.clear();
        }
    }

    public static void main(String[] args) {
        Graph myGraph = new Graph();
        Node n0 = new Node(0);
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);
        Node n10 = new Node(10);

        myGraph.addVertex(n0);
        myGraph.addVertex(n1);
        myGraph.addVertex(n2);
        myGraph.addVertex(n3);
        myGraph.addVertex(n4);
        myGraph.addVertex(n5);
        myGraph.addVertex(n6);
        myGraph.addVertex(n7);
        myGraph.addVertex(n8);
        myGraph.addVertex(n9);
        myGraph.addVertex(n10);
        myGraph.addEdge(n0, n1);
        myGraph.addEdge(n0, n2);
        myGraph.addEdge(n0, n4);
        myGraph.addEdge(n0, n5);
        myGraph.addEdge(n0, n6);
        myGraph.addEdge(n4, n3);
        myGraph.addEdge(n4, n7);
        myGraph.addEdge(n7, n8);
        myGraph.addEdge(n8, n9);
        myGraph.addEdge(n4, n10);

        //myGraph.showConnections();
        System.out.println(myGraph.depthFirstSearchPostOrder(n0));
    }
}
