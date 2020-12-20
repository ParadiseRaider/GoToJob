package Lesson2;

public class MyArrayList<T extends Comparable> {
    private T[] list;
    private int size = 0;
    private int capacity = 10;

    public MyArrayList(int capacity) {
        this.capacity = capacity;
        if (capacity<=0) {
            throw  new IllegalArgumentException("capacity "+capacity);
        }
        list = (T[]) new Comparable[capacity];
    }

    public MyArrayList() {
        list = (T[]) new Comparable[capacity];
    }

    public void checkCapacity() {
        if (size>=capacity) {
            capacity+=10;
            T[] copylist = (T[]) new Comparable[capacity];;
            System.arraycopy(list,0,copylist,0,size);
            list = copylist;
        }
    }

    public final int indexOf(T item) {
        for (int i = 0; i < size; i++) {
            if (list[i].equals(item)) return i;
        }
        return -1;
    }

    public void add(T item) {
        list[size]=item;
        size++;
        checkCapacity();
    }

    public void add(int index, T item) {
        for (int i = size; i > index ; i--) {
            list[i] = list[i-1];
        }
        list[index] = item;
        size++;
        checkCapacity();
    }

    public void remove(int index) {
        for (int i = 0; i < size; i++) {
            list[i] = list[i+1];
        }
        size--;
        list[size]=null;
    }

    public boolean remove(T item) {
        int index = indexOf(item);
        if (index==-1) return false;
        remove(index);
        return true;
    }

    public T get(int index) {
        return list[index];
    }

    public void set(int index, T item) {
        if (index<0) throw new IllegalArgumentException("Error type index");
        list[index] = item;
    }

    public boolean isEmpty() {
        return size==0;
    }

    public int size() {
        return size;
    }
}
