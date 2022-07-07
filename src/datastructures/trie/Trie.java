package datastructures.trie;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    class Node {
        Map<Character, Node> children;
        boolean end;

        Node() {
            children = new HashMap<>();
            end = false;
        }
    }

    private Node root;

    public Trie() {
        this.root = new Node();
    }

    public void insert(String word) {

        Node current = this.root;

        // insert string char by char
        for (char w : word.toCharArray()) {
            current = current.children.computeIfAbsent(w, k -> new Node());
        }

        // set end marker of last node to true
        current.end = true;
    }

    public boolean find(String word) {

        Node current = this.root;

        for (char w : word.toCharArray()) {

            Node tempNode = current.children.get(w);

            if (tempNode == null) {
                return false;
            }

            current = tempNode;
        }

        return current.end;
    }


    public boolean delete(String word) {

        Node current = this.root;

        /*
            iterate over word to find the last node of it,
            if word does not exist, then return false
        */
        for (char w : word.toCharArray()) {

            Node tempNode = current.children.get(w);

            if (tempNode == null) {
                return false;
            }

            current = tempNode;
        }

        // if end is true make set it to false so that the word doesn't exist anymore
        if (current.end) {
            current.end = false;
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("Hello World");
        trie.insert("Banana");
        trie.insert("Apple");

        System.out.println(trie.find("Banana")); // true
        System.out.println("Delete: " + trie.delete("Banana")); // true

        System.out.println(trie.find("Hello")); // false
        System.out.println(trie.find("A")); // false
        System.out.println("Delete: " + trie.delete("A")); // false

        System.out.println(trie.find("Banana")); // false

    }

}
