package org.example.lesson8.homework;

import org.example.lesson4.LinkedList;
import org.example.lesson4.SimpleLinkedListImpl;
import org.example.lesson8.HashTable;


public class HashTableWithChainImpl<K, V> implements HashTable<K, V> {

    private final LinkedList<Entry<K, V>>[] data;
    private int size;

    static class Item<K, V> implements Entry<K, V> {

        private final K key;
        private V value;

        public Item(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    public HashTableWithChainImpl(int InitialCapacity) {
        this.data = new LinkedList[InitialCapacity * 2];
    }

    public HashTableWithChainImpl() {
        this(16);
    }

    @Override
    public boolean put(K key, V value) {

        Entry<K, V> entry = getEntry(key);
        if (entry != null) {
            entry.setValue(value);
            return true;
        }

        int index = hashFunction(key);

        if (data[index] == null) {
            data[index] = new SimpleLinkedListImpl<>();
        }
        data[index].add(new Item<>(key, value));
        size++;
        return true;
    }

    @Override
    public V get(K key) {
        Entry<K, V> foundEnt = getEntry(key);
        if (foundEnt == null) return null;
        return foundEnt.getValue();
    }

    @Override
    public V remove(K key) {
        Entry<K, V> entryToRemove = getEntry(key);
        if (entryToRemove == null) {
            return null;
        }
        V value = entryToRemove.getValue();
        int index = hashFunction(key);
        data[index].remove(entryToRemove);
        size--;
        return value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            sb.append(String.format("%s = [%s]%n", i, data[i]));
        }
        return sb.toString();
    }

    private Entry<K, V> findEntity(K key, LinkedList<Entry<K, V>> currentData) {
        for (Entry<K, V> currentEntry: currentData)  {
            if (currentEntry.getKey().equals(key)) {
                return currentEntry;
            }
        }
        return null;
    }

    private int hashFunction(K key) {
        return Math.abs(key.hashCode() % data.length);
    }

    private Entry<K, V> getEntry(K key) {
        if (isEmpty()) {
            return null;
        }
        LinkedList<Entry<K, V>> currentLinkedList = data[hashFunction(key)];
        if (currentLinkedList == null || currentLinkedList.isEmpty()) {
            return null;
        }
        return findEntity(key, currentLinkedList);
    }
}
