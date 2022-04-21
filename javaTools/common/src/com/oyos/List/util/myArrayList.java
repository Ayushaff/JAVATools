package com.oyos.list.util;
public class myArrayList implements list {
    private int collection[];
    private int size;

    public class myArrayListIterator implements myiterator{
        private int index;
        public myArrayListIterator(){
            this.index=0;
        }

        public boolean hasNext(){
            return index!=size;
        }
        public int next(){
            if(index==size)throw new invalidIteratorException("iterator has no more elements");
            int data=get(index);
            index++;
            return data;
        }
    }
    public myiterator iterator(){
        return new myArrayListIterator();
        
    }
    public myArrayList() {
        this.collection = new int[10];
        this.size = 0;
    }

    public void add(int data) {
        if (this.size == collection.length) {
            // logic to resize
            int tmp[] = new int[this.size + 10];
            for (int i = 0; i < collection.length; i++) {
                tmp[i] = collection[i];
            }
            this.collection = tmp;
        }
        // add
        this.collection[this.size] = data;
        this.size++;
    }

    public void add(int index, int data) {
        if (this.size == collection.length) {
            // logic to resize
            int tmp[] = new int[this.size + 10];
            for (int i = 0; i < collection.length; i++) {
                tmp[i] = collection[i];
            }
            this.collection = tmp;
        }
        // add to index
        for (int e = this.size; e > index; e--) {
            this.collection[e] = this.collection[e - 1];
        }
        this.collection[index] = data;
        this.size++;
    }

    public int removeAt(int index) {
        if (index < 0 || index >= this.size)
            throw new IndexOutOfBoundsException("invalid index" + index);
        int data = this.collection[index];
        int ep = size - 2;
        for (int i = index; i <= ep; i++) {
            this.collection[i] = this.collection[i + 1];
        }
        this.size--;
        System.err.print("Data removed of index "+ index+", ");
        return data;
    }

    public int get(int index) {
        if (index == this.size) {
            System.err.println("data NULL");
        }
        if (index < 0 || index > this.size) {
            System.out.println("invlad index ");
            return index;
        } else {
            return this.collection[index];
        }
    }

    public int getSize() {
        return this.size;
    }

    public void clear() {
        this.size = 0;
    }

    public void insert(int index, int data) {
        add(index, data);
    }


    public void removeAll() {
        clear();
    }

    public void update(int index, int data) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("invalid index" + index);
        }
        this.collection[index] = data;
    }

    public void copyTo(list other) {
        other.clear();
        for (int i = 0; i < this.size; i++)
            other.add(this.get(i));
    }

    public void copyFrom(list other) {
        this.clear();
        for (int i = 0; i < other.getSize(); i++)
            this.add(other.get(i));
    }

    public void appendTo(list other) {
        for (int i = 0; i < this.size; i++)
            other.add(this.get(i));
    }

    public void appendFrom(list other) {
        for(int i=0;i<other.getSize();i++)
            this.add(other.get(i));
    }
}
/*class psp{
    public static void main(String[] args) {
        myArrayList al=new myArrayList();
        myArrayList al2=new myArrayList();
        al.add(10);
        al.add(2);
        al.appendTo(al2);
        System.err.println(al2.get(0));
        System.err.println(al2.get(1));
    }
}*/