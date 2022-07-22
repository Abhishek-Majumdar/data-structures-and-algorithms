package main.com.leetcode.dsa.lcpractice;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        if(head == null)
            return null;

        Node currentNode = head;
        Node newNode = new Node(head.val);
        Node headNode = newNode;
        Node previousNode = newNode;
        currentNode = currentNode.next;

        while(currentNode != null){
            newNode = new Node(currentNode.val);
            previousNode.next = newNode;
            previousNode = newNode;
            currentNode = currentNode.next;
        }

        return headNode;
    }

    public static void main(String[] args) {
        Node n1 = new Node(7);
        Node n2 = new Node(13);
        Node n3 = new Node(11);
        Node n4 = new Node(10);
        Node n5 = new Node(1);

        n1.next = n2;
        n2.next = n3;
        n2.random = n1;
        n3.next = n4;
        n3.random = n5;
        n4.next = n5;
        n4.random = n3;
        n5.random = n1;

        CopyListWithRandomPointer obj = new CopyListWithRandomPointer();
        Node headNodeOfDeepCopy = obj.copyRandomList(n1);
        System.out.println(headNodeOfDeepCopy);

    }
}
