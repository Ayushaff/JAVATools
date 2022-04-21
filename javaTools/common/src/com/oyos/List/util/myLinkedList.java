package com.oyos.list.util;

public class myLinkedList implements list {
    class myNode {
        public int data;
        public myNode next;

        myNode() {
            this.data = 0;
            this.next = null;
        }
    }

    private myNode start, end;
    private int size;

    public myLinkedList() {
        this.start = null;
        this.end = null;
        this.size = 0;
    }

    public class myLinkedListIterator implements myiterator {
        private myNode ptr;

        public myLinkedListIterator(myNode ptr) {
            this.ptr = ptr;
        }

        public boolean hasNext() {
            return this.ptr != null;
        }

        public int next() {
            if (ptr == null)
                throw new invalidIteratorException("iterator has no more elements");
            int data=this.ptr.data;
            this.ptr=this.ptr.next;
            return data;
        } 
         
    public myiterator iterator() {
        return new myLinkedListIterator(this.start);
    }

    public void add(int data) {
        myNode t = new myNode();
        t.data = data;
        if (this.start == null) {// first node
            this.start = t;
            this.end = t;
        } else {
            this.end.next = t;
            this.end = t;
        }
        this.size++;
    }

    public void add(int index, int data) {
        insert(index, data);
    }

    public void insert(int index, int data) {
        if (index < 0)
            throw new ArrayIndexOutOfBoundsException("invalid index : " + index);
        if (index >= size) {
            add(data);// add at end
            return;
        }
        myNode node = new myNode();
        node.data = data;
        if (index == 0) {// add at top
            node.next = this.start;
            this.start = node;
        } else {// or add between
            myNode j = new myNode();
            myNode k = new myNode();
            for (int i = 0; i < index; i++) {
                k = j;
                j = j.next;
            }
            k.next = node;
            node.next = j;
        }
        this.size++;
    }

    public int removeAt(int index) {
        int data;
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("invalid index " + index);
        if (start == end) {// only single node remaining
            data = this.start.data;
            this.start = null;
            this.end = null;
            this.size = 0;
            System.err.print("removed ");
            return data;
        }
        if (index == 0) {// many but first
            data = this.start.data;
            this.start.next = this.start;
            this.size--;
            System.err.print("removed ");
            return data;
        }
        myNode j = new myNode();
        myNode k = new myNode();
        j = this.start;
        for (int i = 0; i < index; i++) {
            k = j;
            j = j.next;
        }
        data = j.data;
        k.next = j.next;
        if (this.end == j)
            this.end = k;
        this.size--;
        System.err.print("removed ");
        return data;
    }

    public void removeAll() {
        this.clear();
    }

    public void clear() {
        this.size = 0;
        this.start = null;
        this.end = null;
    }

    public int getSize() {
        if (this.size == 0) {
            System.out.println("list is empty");
            return 0;
        }
        return this.size;
    }

    public int get(int index) {
        if (getSize() == 0) {
            System.out.println("list is empty");
            return 0;
        } else if (index < 0 || index >= this.size)
            throw new IndexOutOfBoundsException("invalid index " + index);
        myNode t;
        t = start;
        for (int x = 0; x < index; x++) {
            t = t.next;
        }
        return t.data;
    }

    public void update(int index, int data) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("invalid index " + index);
        }
        if (index == 0) {// top
            this.start.data = data;
            return;
        }
        if (index == this.size - 1) {// end
            this.end.data = data;
            return;
        }
        myNode j = new myNode();
        j = this.start;
        for (int i = 0; i < index; i++)
            j = j.next;
        j.data = data;
    }

    public void copyTo(list other) {
        other.clear();
        for (int i = 0; i < this.size; i++)
            other.add(this.get(i));

    }

    public void copyFrom(list other) {
        this.clear();
        for (int i = 0; i < other.getSize(); i++) {
            this.add(other.get(i));
        }
    }

    public void appendTo(list other) {
        for (int i = 0; i < this.size; i++)
            other.add(this.get(i));
    }

    public void appendFrom(list other) {
        for (int i = 0; i < other.getSize(); i++)
            this.add(other.get(i));
    }
    public void forEach(myiterator a){
        
    }

}
