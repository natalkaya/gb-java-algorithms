package com.company;

import com.company.linkedList.LinkedList;
import com.company.linkedList.SingleLinkedList;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * Задание 3.1
 * На основе массива из домашнего задания 2.1 реализуйте простой
 * список и коллекцию.
 * Оцените время выполнения преобразования.
 * Задание 3.2
 * На основе списка из задания 3.1 реализуйте основные методы
 * добавления, удаления и получения объекта или элемента из списка.
 * Оценить выполненные методы с помощью базового класса
 * System.nanoTime().
 * Задание 3.3
 * Реализуйте простой односвязный список и его базовые методы.
 * Задание 3.4
 * На основе списка из задания 3.1 реализуйте простой двусторонний
 * список и его базовые методы.
 * Реализуйте список заполненный объектами из вашего класса из задания
 * 1.3
 * Задание 3.5
 * Реализуйте итератор на основе связанных списков из задания 3.4 и
 * выполните базовые операции итератора.
 * Оцените время выполнения операций с помощью базового метода
 * System.nanoTime()
 */
public class Task3 extends BaseClass {
    final Task2 task2 = new Task2();
    private ArrayList<ArrayObj> arrayObjs;

    private ArrayList<ArrayObj> initArrayList(int length) {
        int[] arrayOfInts = task2.getArrayOfRandomIntegers(length);
        ArrayList<ArrayObj> arrayObjs = new ArrayList<>();
        for (int el : arrayOfInts) {
            arrayObjs.add(new ArrayObj(el));
        }

        System.out.println("Задание 3.1\n" +
                " * На основе массива из домашнего задания 2.1 реализуйте простой\n" +
                " * список и коллекцию:\n" + arrayObjs.toString());
        return arrayObjs;
    }


    public void subtask_1() {
        this.arrayObjs = initArrayList(5);
    }

    public void subtask_2() {
        System.out.println("Задание 3.2\n" +
                " * На основе списка из задания 3.1 реализуйте основные методы\n" +
                " * добавления, удаления и получения объекта или элемента из списка.\n" +
                " * Оценить выполненные методы с помощью базового класса\n" +
                " * System.nanoTime().");
        startTime = System.nanoTime();
        this.arrayObjs.get(0);
        endTime = System.nanoTime();
        printTimeExecution("[ArrayList] get element during", startTime, endTime);

        startTime = System.nanoTime();
        this.arrayObjs.add(0, new ArrayObj(11));
        endTime = System.nanoTime();
        printTimeExecution("[ArrayList] add new element during", startTime, endTime);

        startTime = System.nanoTime();
        this.arrayObjs.remove(0);
        endTime = System.nanoTime();
        printTimeExecution("[ArrayList] remove element during", startTime, endTime);
    }

    public void subtask_3() {
        System.out.println("Задание 3.3\n" +
                " * Реализуйте простой односвязный список и его базовые методы.");
        SingleLinkedList<ArrayObj> arrayObjSingleLinkedList = new SingleLinkedList<>();
        arrayObjSingleLinkedList.insert(new ArrayObj(1));
        arrayObjSingleLinkedList.insert(new ArrayObj(2));
        arrayObjSingleLinkedList.insert(new ArrayObj(3));
        arrayObjSingleLinkedList.print();
        arrayObjSingleLinkedList.delete();
        System.out.println("Print elements after deletion:");
        arrayObjSingleLinkedList.print();
    }

    public void subtask_4() {
        System.out.println("Задание 3.4\n" +
                " * На основе списка из задания 3.1 реализуйте простой двусторонний\n" +
                " * список и его базовые методы.\n" +
                " * Реализуйте список заполненный объектами из вашего класса из задания");
        LinkedList<ArrayObj> javaUtilLinkedList = new LinkedList<>();
        javaUtilLinkedList.add(new ArrayObj(1));
        javaUtilLinkedList.add(new ArrayObj(2));
        javaUtilLinkedList.add(new ArrayObj(3));
        System.out.println("java.util.LinkedList: " + javaUtilLinkedList.toString());
        javaUtilLinkedList.addFirst(new ArrayObj(1));
        System.out.println("java.util.LinkedList after addFirst(...):" + javaUtilLinkedList.toString());
        System.out.println("java.util.LinkedList -> peekLast(): " + javaUtilLinkedList.peekLast());
        System.out.println("java.util.LinkedList after peekLast():" + javaUtilLinkedList.toString());
        System.out.println("java.util.LinkedList -> contains(): " + javaUtilLinkedList.contains(new ArrayObj(3)));
        System.out.println("java.util.LinkedList -> pollLast(): " + javaUtilLinkedList.pollLast());
        System.out.println("java.util.LinkedList after pollLast():" + javaUtilLinkedList.toString());
    }

    public void subtask_5() {
        System.out.println("Задание 3.5\n" +
                " * Реализуйте итератор на основе связанных списков из задания 3.4 и\n" +
                " * выполните базовые операции итератора.\n" +
                " * Оцените время выполнения операций с помощью базового метода\n" +
                " * System.nanoTime()");
        LinkedList<ArrayObj> javaUtilLinkedList = new LinkedList<>();
        javaUtilLinkedList.add(new ArrayObj(1));
        javaUtilLinkedList.add(new ArrayObj(2));
        javaUtilLinkedList.add(new ArrayObj(3));
        javaUtilLinkedList.print();
        System.out.println("Size: " + javaUtilLinkedList.size());
        ListIterator<ArrayObj> itr = javaUtilLinkedList.listIterator();
        while (itr.hasNext()) {
            System.out.println("Iterator:nextIndex() value: " + itr.nextIndex());
        }
    }
}

class ArrayObj {
    private final int el;

    public int getEl() {
        return el;
    }

    @Override
    public String toString() {
        return "ArrayObj{" +
                "el=" + el +
                '}';
    }

    public ArrayObj(int el) {
        this.el = el;
    }
}