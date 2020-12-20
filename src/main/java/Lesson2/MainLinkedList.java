package Lesson2;

import java.util.ListIterator;

public class MainLinkedList {
    public static void main(String[] args) {
        MyLinkedList<Integer> mll = new MyLinkedList<>();

        for (int i = 0; i < 10; i++) {
            mll.insert(i, i);
        }

        ListIterator<Integer> li = mll.iterator();
        while (li.hasNext()) {
            if (li.next()==5) {
                li.remove();
                li.add(777);
            }
        }
        while (li.hasPrevious()) {
            if (li.previous()==0) {
                li.remove();
                li.add(999);
            }
        }

        System.out.println(mll.toString());
    }
}
