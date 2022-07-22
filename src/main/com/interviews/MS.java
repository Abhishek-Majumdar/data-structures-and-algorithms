package main.com.interviews;

public class MS {

    class Node{
        int data;
        Node next;
    }

    public Node reverseLinkedList(Node head){

        if(head == null || head.next == null)
            return null;

        Node firstNode = head;
        Node secondNode = head.next;
        Node tmpNode;

        firstNode.next = null;

        while(secondNode != null){
            tmpNode = secondNode.next;
            secondNode.next = firstNode;
            firstNode = secondNode;
            secondNode = tmpNode;
        }

        return firstNode;
    }

}
