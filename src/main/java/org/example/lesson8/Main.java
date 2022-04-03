package org.example.lesson8;

import org.example.lesson8.homework.HashTableWithChainImpl;

public class Main {

    public static void main(String[] args) {
        testHashTable(new HashTableImpl<>(5));
        testHashTable(new HashTableWithChainImpl<>(5));
    }

    private static void testHashTable(HashTable<Product, Integer> hashTable) {
        hashTable.put(new Product(1, "Orange"), 150); //1
        hashTable.put(new Product(77, "Banana"), 100); //7
        hashTable.put(new Product(67, "Carrot"), 228); //8
        hashTable.put(new Product(60, "Lemon"), 250);  //0
        hashTable.put(new Product(51, "Milk"), 120);   //2
        hashTable.put(new Product(21, "Potato"), 67); //3

        System.out.println("Size is " + hashTable.size());
        hashTable.display();
        System.out.println("Cost potato is " + hashTable.get(new Product(21, "Potato")));
        System.out.println("Cost banana is " + hashTable.get(new Product(77, "Banana")));
        System.out.println("Cost carrot is " + hashTable.get(new Product(67, "Carrot")));

        //hashTable.remove(new Product(21, "Potato"));
        hashTable.remove(new Product(77, "Banana"));
        hashTable.remove(new Product(1, "Orange"));

        System.out.println("Cost potato is " + hashTable.get(new Product(21, "Potato")));
        System.out.println("Cost banana is " + hashTable.get(new Product(77, "Banana")));
        System.out.println("Cost carrot is " + hashTable.get(new Product(67, "Carrot")));
        System.out.println("Cost orange is " + hashTable.get(new Product(1, "Orange")));

        hashTable.put(new Product(47, "Pineapple"), 228);

        hashTable.display();

        System.out.println("Size is " + hashTable.size());
        System.out.println("--------------------------------------------------------\n");
    }
}
