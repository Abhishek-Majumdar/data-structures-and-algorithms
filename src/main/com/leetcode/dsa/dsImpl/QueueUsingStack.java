package main.com.leetcode.dsa.dsImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class QueueUsingStack {
    Stack<Object> queueUsingStack;

    public QueueUsingStack(){
        this.queueUsingStack = new Stack<>();
    }

    public void enqueue(Object data){
        this.queueUsingStack.push(data);
    }

    public void dequeue(){
        int stackSize = queueUsingStack.size();
        Stack<Object> tmpStack = new Stack<>();

        for(int i=0; i<stackSize; i++){
            tmpStack.push(this.queueUsingStack.pop());
        }
        tmpStack.pop();

        stackSize = tmpStack.size();
        for(int i=0; i<stackSize; i++){
            this.queueUsingStack.push(tmpStack.pop());
        }
    }

    public Object peek(){
        int stackSize = queueUsingStack.size();
        Stack<Object> tmpStack = new Stack<>();
        Object first;

        for(int i=0; i<stackSize; i++){
            tmpStack.push(this.queueUsingStack.pop());
        }
        first = tmpStack.peek();

        for(int i=0; i<stackSize; i++){
            this.queueUsingStack.push(tmpStack.pop());
        }
        return first;
    }

    public static void main(String[] args) {
        QueueUsingStack stackQueue = new QueueUsingStack();
        stackQueue.enqueue(200);
        stackQueue.enqueue(300);
        stackQueue.enqueue(400);
        stackQueue.enqueue(500);
        stackQueue.dequeue();
        stackQueue.dequeue();
        stackQueue.peek();

        System.out.println(stackQueue.peek());
    }
}
