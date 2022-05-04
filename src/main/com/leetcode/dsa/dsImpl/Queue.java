package main.com.leetcode.dsa.dsImpl;

public class Queue {
    Node first;
    Node last;
    int length;

    public Queue(Object data){
        this.first = new Node(data, null);
        this.last = this.first;
        this.length = 1;
    }

    private class Node{
        Object data;
        Node next;

        Node(Object data, Node next){
            this.data = data;
            this.next = next;
        }

        public boolean hasNext(){
            return !(this.next == null);
        }
    }

    public void enqueue(Object data){
        Node newNode = new Node(data, null);
        this.last.next = newNode;
        this.last = newNode;
        length++;
    }

    public void dequeue(){
        this.first = this.first.next;
        length--;
    }

    public Object peek(){
        return this.first.data;
    }

    public static void main(String[] args) {
        Queue queue = new Queue("First");
        queue.enqueue("Second");
        queue.enqueue("Third");
        queue.enqueue("Last");
        queue.dequeue();
        queue.dequeue();

        System.out.println(queue.peek());
        System.out.println(queue);
    }
}
