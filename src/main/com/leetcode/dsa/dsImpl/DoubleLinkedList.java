package main.com.leetcode.dsa.dsImpl;

public class DoubleLinkedList {
    private Node head;
    private Node tail;
    private int length;

    public DoubleLinkedList(Object data){
        this.head = new Node(data, null, null);
        this.tail = this.head;
        length = 1;
    }

    private class Node{
        Object data;
        Node next;
        Node previous;

        public Node(Object data, Node next, Node previous){
            this.data = data;
            this.next = next;
            this.previous = previous;
        }
    }

    private void prepend(Object data){
        Node newNode = new Node(data, null, null);
        newNode.next = this.head;
        this.head.previous = newNode;
        this.head = newNode;
        length++;
    }

    private void append(Object data){
        Node newNode = new Node(data, null, null);
        this.tail.next = newNode;
        newNode.previous = this.tail;
        this.tail = newNode;
        length++;
    }

    private void insert(Object data, int index){
        Node currentNode = this.head;
        int counter = 0;

        if(index ==0){
            this.prepend(data);
            return;
        }

        if(index >= this.length)
            return;

        while(currentNode != null){
            if(counter == index){
                Node newNode = new Node(data, null, null);
                newNode.next = currentNode;
                newNode.previous = currentNode.previous;
                currentNode.previous.next = newNode;
                currentNode.previous = newNode;
                length++;
                return;
            }
            currentNode = currentNode.next;
            counter++;
        }
    }

    public static void main(String[] args) {
        DoubleLinkedList myDoubleLinkedList = new DoubleLinkedList(100);
        myDoubleLinkedList.append(200);
        myDoubleLinkedList.prepend(0);
        myDoubleLinkedList.insert(50, 1);

        System.out.println(myDoubleLinkedList);
    }
}
