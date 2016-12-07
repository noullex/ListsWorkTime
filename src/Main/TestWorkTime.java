package Main;

import Main.Lists.MyList;

import java.util.Iterator;
import java.util.Random;

public class TestWorkTime {

    private long startTime;
    private long finishTime;
    private MyList list;
    private Random rnd;

    public TestWorkTime(MyList list) {
        startTime = 0;
        finishTime = 0;
        this.list = list;
        rnd = new Random();
    }

    public String getTimeInfo() {
        String str = "Для коллекции " + list.getClass().getSimpleName() + ":\n" +
                "вставка элемента в конец: " + testAdd() + " нс\n" +
                "вставка элемента в середину: " + testInsert() + " нс\n" +
                "удаление элемента: " + testDelete() + " нс\n" +
                "цикл for: " + testCycle() + " нс\n" +
                "итеративный цикл: " + testIterator() + " нс\n\n";
        return str;
    }

    private long testAdd() {
        startTime = System.nanoTime();
        list.add(rnd.nextInt(Main.SIZE * 2));
        finishTime = System.nanoTime();
        return finishTime - startTime;
    }

    private long testInsert() {
        startTime = System.nanoTime();
        list.insert(list.size() / 2, rnd.nextInt(Main.SIZE * 2));
        finishTime = System.nanoTime();
        return finishTime - startTime;
    }

    private long testDelete() {
        startTime = System.nanoTime();
        list.remove(list.size() / 2);
        finishTime = System.nanoTime();
        return finishTime - startTime;
    }

    private long testCycle() {
        startTime = System.nanoTime();
        for (int i = 0; i < list.size(); ) {
            i++;
        }
        finishTime = System.nanoTime();
        return finishTime - startTime;
    }

    private long testIterator() {
        Iterator iterator = list.getIterator();
        startTime = System.nanoTime();
        while (iterator.hasNext()) {
            iterator.next();
        }
        finishTime = System.nanoTime();
        return finishTime - startTime;
    }
}
