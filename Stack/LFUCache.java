package StackAndQueue;

import java.util.*;

class LFUCache {

    class Node {
        int key, value, freq;
        Node prev, next;
        Node(int k, int v) {
            key = k;
            value = v;
            freq = 1;
        }
    }

    class DLL {
        Node head, tail;
        int size;
        DLL() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }
        void addFirst(Node node) {
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
            node.prev = head;
            size++;
        }
        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }
        Node removeLast() {
            if (size > 0) {
                Node last = tail.prev;
                remove(last);
                return last;
            }
            return null;
        }
    }

    private int capacity, minFreq;
    private Map<Integer, Node> keyNode;
    private Map<Integer, DLL> freqList;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        keyNode = new HashMap<>();
        freqList = new HashMap<>();
    }

    public int get(int key) {
        if (!keyNode.containsKey(key)) return -1;
        Node node = keyNode.get(key);
        updateFreq(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (keyNode.containsKey(key)) {
            Node node = keyNode.get(key);
            node.value = value;
            updateFreq(node);
        } else {
            if (keyNode.size() == capacity) {
                DLL minList = freqList.get(minFreq);
                Node toRemove = minList.removeLast();
                keyNode.remove(toRemove.key);
            }
            Node node = new Node(key, value);
            keyNode.put(key, node);
            minFreq = 1;
            freqList.computeIfAbsent(1, k -> new DLL()).addFirst(node);
        }
    }

    private void updateFreq(Node node) {
        int oldFreq = node.freq;
        DLL oldList = freqList.get(oldFreq);
        oldList.remove(node);
        if (oldFreq == minFreq && oldList.size == 0) {
            minFreq++;
        }
        node.freq++;
        freqList.computeIfAbsent(node.freq, k -> new DLL()).addFirst(node);
    }
}

