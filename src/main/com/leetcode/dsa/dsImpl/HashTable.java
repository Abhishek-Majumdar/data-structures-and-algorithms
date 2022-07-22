package main.com.leetcode.dsa.dsImpl;

import java.util.ArrayList;

//TODO : Revisit after linked list and implement using nodes.
public class HashTable {

    class Node{
        int hashCode;
        Object key;
        Object value;
        Node next;

        Node(int hashCode, Object key, Object value, Node next){
            this.hashCode = hashCode;
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private ArrayList<Node> data;

    public HashTable(int size){
        this.data = new ArrayList<Node>(size);
    }

    private int hashCode(String key){
        int hash = 0;

        for(int i=0; i<key.length(); i++){
            hash = this.data.isEmpty() ? 0 :
                    (hash + key.charAt(i) * i) % this.data.size();
        }
        return hash;
    }

    public void setData(Object obj1, Object obj2){
        int address = hashCode(obj1.toString());
        Node existingBucket;
        Node currentNode;
        Node lastnode;
        Node newObject = new Node(address, obj1, obj2, null);

        if(address > this.data.size()-1){
            this.data.add(address, newObject);
            return;
        }

        if(this.data.get(address) == null) {
            this.data.add(address, newObject);
        }
        //Hash Collision
        else{
            existingBucket = this.data.get(address);
            currentNode = existingBucket;
            lastnode = currentNode;
            while(currentNode != null){
                lastnode = currentNode;
                currentNode = currentNode.next;
            }
            lastnode.next = newObject;
        }

    }

    public Object getData(Object obj1){
        int address = hashCode(obj1.toString());
        Node currentBucket = this.data.get(address);

        if(currentBucket == null)
            return null;
        if(currentBucket.next == null)
            return currentBucket.value;

        while(currentBucket != null){
            if(currentBucket.key.equals(obj1))
                return currentBucket.value;
            else
                currentBucket = currentBucket.next;
        }

        return null;
    }

    public static void main(String[] args) {
        HashTable myHashTable = new HashTable(5);
        myHashTable.setData("Green", 100);
        myHashTable.setData("Red", 200);
        myHashTable.setData("Pink", 300);
        myHashTable.setData("Blue", 300);
        System.out.println(myHashTable.getData("Red"));
    }
}
