package main.com.leetcode.dsa.dsImpl;

public class Stack {
    Node top;
    Node bottom;
    int length;

    public Stack(Object data){
        this.bottom = new Node(data, null);
        this.top = this.bottom;
        length = 1;
    }

    class Node {
        Object data;
        Node next;

        Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }

        public boolean hasNext(){
            return !(this.next == null);
        }
    }

    public void push(Object data){
        Node newNode = new Node(data, null);
        this.top.next = newNode;
        this.top = newNode;
        length++;
    }

    public void pop(){
        if(this.length == 1){
            this.top = null;
            this.bottom = null;
        }

        Node current = this.bottom;
        Node previous = this.bottom;

        while(current.hasNext()){
            previous = current;
            current = current.next;
        }

        this.top = previous;
        this.top.next = null;
        length--;
    }

    public Object peek(){
        return this.top.data;
    }

    public Stack reverse(){
        if(this.length == 1)
            return this;

        Stack.Node first = this.bottom;
        Stack.Node second = first.next;
        Stack.Node tempNode = null;

        this.top = this.bottom;
        while(second != null){
            tempNode = second.next;
            second.next = first;
            first = second;
            second = tempNode;
        }
        this.bottom.next = null;
        this.bottom = first;

        return this;
    }

    public static void main(String[] args) {
        Stack stack = new Stack("Bottom");
        stack.push("Middle1");
        stack.push("Middle2");
        stack.push("Top");

        stack.reverse();
        System.out.println(stack.length);
        System.out.println(stack.peek());
    }
}
