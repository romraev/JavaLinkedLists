package ru.gb.lesson3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MyLinkedListTest {

    @Test
    void testToString() {
        MyLinkedList list = new MyLinkedList();
        Assertions.assertEquals("[]", list.toString());

        list.add(1);
        list.add(2);
        list.add(3);
        Assertions.assertEquals("[1 -> 2 -> 3]", list.toString());
    }

    @Test
    void testPop() {
        MyLinkedList list = new MyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);

        Assertions.assertEquals(1, list.popFirst());
        Assertions.assertEquals(3, list.pop(1));

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.pop(-1));
        Assertions.assertEquals(2, list.pop(0));
        Assertions.assertThrows(IllegalStateException.class, () -> list.pop(0));
    }
  
}