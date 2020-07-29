package com.company;

import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Task1 task1 = new Task1();
        task1.run();

        Task2 task2 = new Task2();
        task2.subtask_1();
        task2.subtask_2();
        task2.subtask_3();
        task2.subtask_4();
        task2.subtask_5();
        task2.subtask_6();

        task2.getTimeExecution()
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));

        Task3 task3 = new Task3();
        task3.subtask_1();
    }
}


