package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.function.IntSupplier;

public class Task2 extends BaseClass implements IntSupplier {
    /**
     * Задание 2.1
     * На основе программного кода из домашнего задания №1 реализуйте
     * массив на основе существующих примитивных или ссылочных типов
     * данных.
     * Выполните обращение к массиву и базовые операции класса Arrays.
     * Оценить выполненные методы с помощью базового класса
     * System.nanoTime().
     * <p>
     * Задание 2.2
     * На основе написанного кода в задании 2.1 реализуйте линейный и
     * двоичный поиск.
     * Оценить алгоритмы линейного и двоичного поиска с помощью
     * базового класса System.nanoTime(), при необходимости расширьте уже
     * существующий массив данных.
     * <p>
     * Задание 2.3
     * Создайте массив размером 400 элементов.
     * Выполните сортировку с помощью метода sort().
     * Оцените сортировку с помощью базового класса System.nanoTime().
     * <p>
     * Задание 2.4
     * На основе существующего массива данных из задания 2.3 реализуйте
     * алгоритм сортировки пузырьком.
     * Оцените сортировку с помощью базового класса System.nanoTime().
     * Сравните время выполнения алгоритмы сортировки методом sort() из
     * задания 2.1 и сортировку пузырьком.
     * <p>
     * Задание 2.5
     * На основе массива данных из задания 2.3 реализуйте алгоритм
     * сортировки методом выбора.
     * <p>
     * Оцените сортировку с помощью базового класса System.nanoTime().
     * Сравните с временем выполнения алгоритмов сортировки из прошлых
     * заданий 2.3 и 2.4.
     * <p>
     * Задание 2.6
     * На основе массива данных из задания 2.3 реализуйте алгоритм
     * сортировки методом вставки.
     * Оцените сортировку с помощью базового класса System.nanoTime().
     * Сравните с временем выполнения алгоритмов сортировки из прошлых
     * заданий 2.3, 2.4 и 2.5.
     */

    private final Random random = new Random();
    private Map<String, Long> timeExecution = new HashMap<>();

    public Map<String, Long> getTimeExecution() {
        return timeExecution;
    }

    public int[] getArray400() {
        return array400;
    }

    private final int[] array400 = getArrayOfRandomIntegers(400);

    private void swap(int[] arr, int first, int last) {
        int m = arr[first];
        arr[first] = arr[last];
        arr[last] = m;
    }

    public int[] getArrayOfRandomIntegers(Integer length) {
        startTime = System.nanoTime();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = random.nextInt(length);
        }
        endTime = System.nanoTime();
        printTimeExecution("getArrayOfRandomIntegers", startTime, endTime);
        return arr;
    }

    private Integer linearSearch(int[] arr, int left, int right, int key) {
        int foundIndex = 0;
        startTime = System.nanoTime();
        try {
            for (int i = left; i <= right; i++) {
                if (arr[i] == key) foundIndex = i;
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println(String.format("Element is not found in [%d, %d]", left, right));
        }
        endTime = System.nanoTime();
        printTimeExecution("linearSearch", startTime, endTime);
        return foundIndex;
    }

    private Integer binarySearch(int[] arr, int key) {
        String name = "binarySearch";
        startTime = System.nanoTime();
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;
        int m;
        while (true) {
            if (left > right) {
                endTime = System.nanoTime();
                printTimeExecution(name, startTime, endTime);
                return -1;
            }
            m = left + (right - left) / 2;
            if (arr[m] < key) left = m + 1;
            if (arr[m] > key) right = m - 1;
            if (arr[m] == key) {
                endTime = System.nanoTime();
                printTimeExecution(name, startTime, endTime);
                return m;
            }
        }
    }

    private void bubbleSort(int[] arr) {
        startTime = System.nanoTime();
        for (int i = arr.length - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
        endTime = System.nanoTime();
        printTimeExecution("bubbleSort", startTime, endTime);
    }

    private void sortByChooseMethod(int[] arr) {
        startTime = System.nanoTime();
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] <= arr[min]) {
                    min = j;
                }
            }
            swap(arr, i, min);
        }
        endTime = System.nanoTime();
        printTimeExecution("sortByChooseMethod", startTime, endTime);
    }

    private void sortByInsertMethod(int[] arr) {
        startTime = System.nanoTime();
        int index;
        int buff;
        for (int i = 1; i < arr.length; i++) {
            buff = arr[i];
            index = i;
            while (index > 0 && arr[index - 1] >= buff) {
                arr[index] = arr[index - 1];
                --index;
            }
            arr[index] = buff;
        }
        endTime = System.nanoTime();
        printTimeExecution("sortByInsertMethod", startTime, endTime);
    }

    public void subtask_1() {
        System.out.println("Задание 2.1\n" +
                "     * На основе программного кода из домашнего задания №1 реализуйте\n" +
                "     * массив на основе существующих примитивных или ссылочных типов\n" +
                "     * данных.");
        int[] array = getArrayOfRandomIntegers(5);
        System.out.println("Initialized Array: " + Arrays.toString(array));

        startTime = System.nanoTime();
        System.out.println("First element: " + array[0]);
        endTime = System.nanoTime();

        startTime = System.nanoTime();
        Arrays.sort(array);
        endTime = System.nanoTime();
    }

    public void subtask_2() {
        System.out.println("Задание 2.2\n" +
                "     * На основе написанного кода в задании 2.1 реализуйте линейный и\n" +
                "     * двоичный поиск.");
        System.out.println("Linear search: " + linearSearch(array400, 1, 4, array400[random.nextInt(array400.length)]));
        System.out.println("Binary search: " + binarySearch(array400, array400[random.nextInt(array400.length)]));
    }

    public void subtask_3() {
        System.out.println("Задание 2.3\n" +
                "     * Создайте массив размером 400 элементов.\n" +
                "     * Выполните сортировку с помощью метода sort().");
        startTime = System.nanoTime();
        Arrays.sort(array400);
        endTime = System.nanoTime();
        printTimeExecution("Arrays.sort()", startTime, endTime);
    }

    public void subtask_4() {
        System.out.println("Задание 2.4\n" +
                "     * На основе существующего массива данных из задания 2.3 реализуйте\n" +
                "     * алгоритм сортировки пузырьком.");
        bubbleSort(array400);
        System.out.println("Bubble sort: " + Arrays.toString(array400));
    }

    public void subtask_5() {
        System.out.println("Задание 2.5\n" +
                "     * На основе массива данных из задания 2.3 реализуйте алгоритм\n" +
                "     * сортировки методом выбора.");
        sortByChooseMethod(array400);
        System.out.println("Sort by insert method: " + Arrays.toString(array400));
    }

    public void subtask_6() {
        System.out.println("Задание 2.6\n" +
                "     * На основе массива данных из задания 2.3 реализуйте алгоритм\n" +
                "     * сортировки методом вставки.");
        sortByInsertMethod(array400);
        System.out.println("Sort by : " + Arrays.toString(array400));
    }

    @Override
    public int getAsInt() {
        return random.nextInt();
    }
}
