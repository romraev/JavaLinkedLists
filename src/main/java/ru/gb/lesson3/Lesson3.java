package ru.gb.lesson3;

import java.util.LinkedList;

public class Lesson3 {

    public static void main(String[] args) {
//        LinkedList<Integer> javaLinkedList = new LinkedList();
//        javaLinkedList.add(1);
//        javaLinkedList.add(2);
//        javaLinkedList.add(3);

        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);

//        System.out.println(myLinkedList.getSize());

//        System.out.println(myLinkedList.popLast());

//        System.out.println(myLinkedList.contains(1));

//        System.out.println(myLinkedList); // [1 -> 2 -> 3]
//        MyLinkedList reversed = myLinkedList.reversed();
//        System.out.println(reversed); // [3 -> 2 -> 1]
//        System.out.println(myLinkedList); // [1 -> 2 -> 3]

    }

    private static void annoDemo() {
        boolean s = MyLinkedList.class.isAnnotationPresent(MyAnno.class);
    }

    private static void objectsDemo() {
        // p -> link -> Person
        // p.name -> link -> "abcde"

        MyArrayList list = new MyArrayList();
        list.add(2);
        list.add(new Person("Igor"));
        // ...

        Object o = list.get(1);
        if (o instanceof Person p) {
            System.out.println(p);
        }
    }

}
