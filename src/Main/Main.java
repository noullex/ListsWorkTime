package Main;

import Main.Lists.MyArrayList;
import Main.Lists.MyLinkedList;

import java.util.Random;

public class Main {

    public static final int SIZE = 1000;

    public static void main(String[] args) {
        Random rnd = new Random();
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        MyArrayList<Integer> arrayList = new MyArrayList<>();

        for (int i = 0; i < SIZE; i++) {
            linkedList.add(rnd.nextInt(SIZE * 2));
            arrayList.add(rnd.nextInt(SIZE * 2));
        }

        System.out.print(new TestWorkTime(linkedList).getTimeInfo());
        System.out.print(new TestWorkTime(arrayList).getTimeInfo());
    }
}
