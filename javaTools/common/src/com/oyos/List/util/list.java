package com.oyos.list.util;

public interface list {
    // implement linked and arraylist
    public void add(int data);
    public void add(int data, int index);
    public void insert(int index, int data);

    public int removeAt(int index);
    public void removeAll();
    public void clear();

    public int getSize();
    public int get(int index);

    public void update(int index, int data);

    public void copyTo(list other);
    public void copyFrom(list other);
    public void appendTo(list other);
    public void appendFrom(list other);

    public myiterator iterator();
    public void forEach(mylistAcceptor a);

}
