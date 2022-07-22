package main.com.leetcode.dsa.dsImpl;

import java.util.Arrays;

public class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    LinkedList(Object data){
        Node node = new Node(data, null);
        this.head = node;
        this.tail = this.head;
        length = 1;
    }

    private class Node{
        Object data;
        Node next;

        Node(Object data, Node next){
            this.data = data;
            this.next = next;
        }

        private boolean hasNext(){
            return this.next != null;
        }
    }

    private void prepend(Object data){
        Node newNode = new Node(data, this.head);
        this.head = newNode;
        length++;
    }

    private void append(Object data){
        Node newNode = new Node(data, null);
        this.tail.next = newNode;
        this.tail = newNode;
        length++;
    }

    private boolean contains(Object data){
        Node node = this.head;
        while(node != null){
            if(node.data.equals(data))
                return true;
            node = node.next;
        }
        return false;
    }

    private void insert(Object data, int index){
        int counter = 0;
        Node currentNode = this.head;
        Node previousNode = this.head;

        if(index == 0) {
            this.prepend(data);
            return;
        }

        if(index >= this.length){
            this.append(data);
            return;
        }

        while(currentNode != null){
            if(index == counter){
                Node newNode = new Node(data, currentNode);
                previousNode.next = newNode;
                length++;
                return;
            }
            previousNode = currentNode;
            currentNode = currentNode.next;
            counter++;
        }
    }

    private void delete(int index){
        int counter = 0;
        Node currentNode = this.head;
        Node previousNode = this.head;

        while(currentNode != null){
            if(counter == index){
                previousNode.next = currentNode.next;
                currentNode.next = null;
                currentNode.data = null;
                length--;
                return;
            }
            previousNode = currentNode;
            currentNode = currentNode.next;
            counter++;
        }
    }

    private void reverse(){
        if(! this.head.hasNext())
            return;

        Node firstNode = this.head;
        Node secondNode = firstNode.next;
        Node tmpNode;

        this.tail = this.head;
        while(secondNode != null){
            tmpNode = secondNode.next;
            secondNode.next = firstNode;
            firstNode = secondNode;
            secondNode = tmpNode;
        }
        this.head.next = null;
        this.head = firstNode;
    }

    private void printList(){
        Object[] arr = new Object[this.length];
        Node currentNode = this.head;
        int counter = 0;

        while(currentNode != null){
            arr[counter++] = currentNode.data;
            currentNode = currentNode.next;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        LinkedList myLinkedList = new LinkedList(100);
        myLinkedList.append(200);
        myLinkedList.append(300);
        myLinkedList.append(400);

        System.out.println(myLinkedList.length);
        /*System.out.println(myLinkedList.contains(300));*/
        myLinkedList.reverse();
        myLinkedList.printList();
    }
}
