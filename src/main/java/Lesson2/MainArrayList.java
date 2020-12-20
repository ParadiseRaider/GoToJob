package Lesson2;

public class MainArrayList {
    public static void main(String[] args) {
        MyArrayList<Integer> mal = new MyArrayList<>(20);

        for (int i = 0; i < 20; i++) {
            mal.add(i);
        }

        mal.add(15,77);

        for (int i = 0; i < mal.size(); i++) {
            System.out.println(mal.get(i));
        }
    }
}
