package main.java.dataStructures;

/**
 * Created by Влад on 19.01.2019.
 */
public class MyHashMap<K, V> {
    private float loadFactor;
    private Node<K, V>[] table;
    private int size;
    private int capacity;

    class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;
        int hash;

        public Node(K key, V value, Node<K, V> next, int hash) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.hash = hash;
        }
    }

    public MyHashMap() {
        this(16);
    }

    @SuppressWarnings({"rawtypes","unchecked"})
    public MyHashMap(int capacity) {
        this.capacity = capacity;
        loadFactor = 0.75f;
        table = (Node<K,V>[]) new Node[capacity];
    }

    public int size() {
        return size;
    }

    public void put(K key, V value) {
        if(key == null) {
            if(table[0] == null) {
                size++;
            }
            table[0] = new Node<K, V>(key, value, null, 0);
        } else {
            int i = findIndex(key.hashCode());
            Node<K, V> node = table[i];
            if (node == null) {
                table[i] = new Node<K, V>(key, value, null, key.hashCode());
                size++;
            } else {
                boolean isAssigned = false;
                for(Node<K, V> n = node; n != null; n = n.next) {
                    if (n.key == key || n.value.equals(value)) {
                        n.value = value;
                        isAssigned = true;
                        break;
                    }
                }
                if (!isAssigned) {
                    table[i] = new Node<K, V>(key, value, node, key.hashCode());
                    size++;
                }
            }
        }

        if (size >= loadFactor * capacity)
            resize();
    }

    public V get(K key) {
        if (key == null)
            return table[0].value;
        else {
            int i = findIndex(key.hashCode());
            for (Node<K, V> n = table[i]; n != null; n = n.next) {
                if (key == n.key || key.equals(n.key))
                    return n.value;
            }
        }

        return null;
    }

    public void remove(K key) {
        if (key != null) {
            Node<K, V> prev;
            int i = findIndex(key.hashCode());
            Node<K, V> n = table[i];
            if (n.key == key || n.key.equals(key)) {
                table[i] = n.next;
                n = null;
                size--;
            } else {
                prev = n;
                for (Node<K, V> node = n.next; node != null; node = node.next) {
                    if (node.key == key || node.key.equals(key)) {
                        prev.next = node.next;
                        node = null;
                        size--;
                    }
                    prev = node;
                }
            }
        }
    }

    public int getCapacity() {
        return capacity;
    }

    private int findIndex(int hash) {
        int index = hash % capacity;
        return index == 0 ? index + 1 : index;
    }

    private void resize() {
        capacity *= 2;
        @SuppressWarnings({"rawtypes","unchecked"})
        MyHashMap<K, V> newTable = (MyHashMap<K, V>) new MyHashMap(capacity);
        for (int c = 1; c < capacity / 2; c++) {
            for(Node<K, V> n = table[c]; n != null; n = n.next)
                newTable.put(n.key, n.value);
        }

        table = newTable.table;
    }
}
