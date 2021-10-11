package application;

import java.util.LinkedList;
import java.util.Comparator;
import java.util.Iterator;
import javafx.collections.ModifiableObservableListBase;

public class LinkedQueue<E> extends ModifiableObservableListBase<E> 
        implements Iterable<E>, SimpleQueue<E> {
    
    private Node head;
    private int size;
    
    private class Node {
        E data;
        Node next;
        
        public Node(E data) {
            this.data = data;
            next = null;
        }

        public Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
    
    public LinkedQueue(){
        head = null;
        size = 0;
    }

    @Override
    public void enqueue(E element) {
        if(size > 0) {
            Node cur = head;
            while(cur.next != null) {
                cur = cur.next;
            }
            cur.next = new Node(element);
        } else {
            head = new Node(element);
        }
        
        size++;
    }

    @Override
    public E dequeue() {
        
        if (size == 0) {
            return null;
        } else if (size==1) {
            Node temp = head;
            head = null;
            size--;
            return temp.data;
            
                       
        } else {
            Node cur = head;
            while(cur.next.next != null) {
                cur = cur.next;
            }
            Node temp = cur.next;
            cur.next = cur.next.next;
            size--;
            return temp.data;
        }
    }

    @Override
    protected void doAdd(int index, E obj) {
        if(index < 0 || index > size) throw new IllegalArgumentException();
        
        if(size > 0) {
            Node cur = head;
            
            for(int i = 0; i<index-1; i++) {
                cur = cur.next;
            }
            
            Node temp = cur.next;
            
            cur.next = new Node(obj, temp);
        } else {
            head = new Node(obj);
        }
        
        size++;
        
    }

    @Override
    protected E doRemove(int index) {
        if(index < 0 || index >= size) throw new IllegalArgumentException();
        
        if(size > 1) {
            Node cur = head;
            
            for(int i = 0; i<index-1; i++) {
                cur = cur.next;
            }
            
            Node temp = cur.next;
            
            cur.next = cur.next.next;
            
            size--;
            
            return temp.data;
        } else {
            Node temp = head;
            head = null;
            size--;
            return temp.data;
        }
        
        
    }

    @Override
    protected E doSet(int index, E obj) {
        throw new UnsupportedOperationException();
    }

    @Override
    public E get(int index) {
        if(index < 0 || index >= size) throw new IllegalArgumentException();
        Node cur = head;
        for(int i = 0; i<index; i++) {
            cur = cur.next;
        }
        return cur.data;
    }

    @Override
    public int size() {
        return size;
    }
    
    public void clear(){
        head = null;
        size = 0;
        
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    

    
    public Iterator<E> iterator(){
        return new Iterator<E>() {
            private Node cur;
            public E next() {
                Node temp = cur;
                cur = cur.next;
                return temp.data;
            }
            
            public boolean hasNext() {
                return cur!=null;
            }
            
        };
    }
    

   
}
