package interviewQA.StackAndQueues;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    Node head;
    Node tail;
    int capacity;
    Map<Integer,Node> map;

    public LRUCache(int capacity) {
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
        head.prev = null;
        tail.next = null;
        this.capacity = capacity;
        map = new HashMap<>();
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node currNode = map.get(key);
        deleteNode(currNode);
        addNodeToHead(currNode);
        return currNode.val;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node currNode = map.get(key);
            currNode.val = value;
            deleteNode(currNode);
            addNodeToHead(currNode);
        }
        else{
            if(map.size() == capacity){
                Node tailNode = tail.prev;
                deleteNode(tailNode);
                map.remove(tailNode.key);
            }
            Node newNode = new Node(key,value);
            map.put(key,newNode);
            addNodeToHead(newNode);
        }
    }

    public void deleteNode(Node node){
        Node nextNode = node.next;
        Node prevNode = node.prev;
        if(prevNode != null)
            prevNode.next = nextNode;
        if(nextNode != null)
            nextNode.prev = prevNode;
    }

    public void addNodeToHead(Node node){
        Node currHead = head.next;
        node.next = currHead;
        node.prev = head;
        head.next = node;
        currHead.prev = node;
    }
}

class Node{
    int key;
    int val;
    Node next;
    Node prev;

    public Node(int key, int val){
        this.key = key;
        this.val = val;
    }
}
