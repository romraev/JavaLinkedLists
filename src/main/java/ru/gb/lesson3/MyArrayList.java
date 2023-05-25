package ru.gb.lesson3;

public class MyArrayList {

    private Object[] data;
    private int cursor;

    public MyArrayList() {
        this.data = new Object[10];
        cursor = 0;
    }

    public void add(Object t) {
        data[cursor] = t;
        cursor++;
    }

    public Object get(int index) {
        // TODO: 25.05.2023 Сделать проверки на валидность индекса
        return data[index];
    }

}
