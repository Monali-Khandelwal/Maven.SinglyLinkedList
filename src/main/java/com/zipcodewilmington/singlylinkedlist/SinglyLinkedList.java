package com.zipcodewilmington.singlylinkedlist;

/**
 * Created by leon on 1/10/18.
 */
    public class SinglyLinkedList<T extends Comparable<T>>  {

        private Node headNode;
        private Node tailNode;
        private Integer size;

        public SinglyLinkedList() {
            this.size = 0;
        }

        private class Node {
            private T data;
            private Node nextNode;

            public Node(T d) {
                data = d;
                nextNode = null;
            }
            public void setNextNode(Node nextNode) {
                this.nextNode = nextNode;
            }
        }

    public void add(T data) {
        Node newNode = new Node(data);

        // empty list then make newNode the head & the tail
        if (headNode == null) {
            headNode = newNode;
            tailNode = newNode;
            // not empty list then add newNode to the end
        } else {
            tailNode.nextNode = newNode;    // the tail has to point to newNode (since it's not the tail anymore!)
            tailNode = newNode;         // newNode is added to the end - so it's now the tail!
        }

        this.size++;
    }

        public void remove(int index) {
            Node temp = headNode;
            Node newNext;

            // deleting the head
            if (index == 0) {
                headNode = headNode.nextNode;       // head is now next item in the list
                return;
            }
            // deleting any other node
            for (int i = 0; i < index - 1; i++) {
                temp = temp.nextNode;               // temp now is the item before the one to be deleted
                newNext = temp.nextNode.nextNode;       // get new next item after deletion
                temp.nextNode = newNext;            // link temp to the item after the one to be deleted
            }

            this.size--;
        }

        public Boolean contains(T elementToFind) {

            Node current = headNode;
            Integer index = 0;
            while (current != null) {
                if (current.data.equals(elementToFind)) {
                    return true;
                }
                current = current.nextNode;
                index++;
            }
            return false;
        }

        public Integer find(T elementToFind) {

            Node current = headNode;
            Integer index = 0;
            while (current != null) {
                if (current.data.equals(elementToFind)) {
                    return index;
                }
                current = current.nextNode;
                index++;
            }
            return -1;
        }

        public Integer size(){
            return this.size;
        }

        public T get(int index) {
            Node current = headNode;
            for (int i = 0; i <= index; i++) {
                if (i == index) {
                    return current.data;
                }
                current = current.nextNode;
            }
            return null;
        }

        public SinglyLinkedList<T> copy(){
            SinglyLinkedList<T> copyOfList = new SinglyLinkedList<T>();

            Node curr = headNode;
            for (int i = 0; i <= this.size; i++) {
                copyOfList.add(curr.data);
                curr = headNode.nextNode;
            }

            return copyOfList;
        }

        public void sort() {
            T temp = null;
            for (int i = 0; i <= this.size; i++) {
                Node prev = headNode;
                Node curr = headNode.nextNode;
                while (curr != null) {
                    if (prev.data.compareTo(curr.data) > 0) {
                        temp = prev.data;
                        prev.data = curr.data;
                        curr.data = temp;
                    }
                    prev = prev.nextNode;
                    curr = curr.nextNode;
                }
            }
        }

}
