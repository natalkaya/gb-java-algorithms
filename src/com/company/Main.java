package com.company;

import com.company.recurison.Task5;

import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Task1 task1 = new Task1();
        Task2 task2 = new Task2();
        Task3 task3 = new Task3();
        Task4 task4 = new Task4();
        Task5 task5 = new Task5();

        task1.run();

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


        task3.subtask_1();
        task3.subtask_2();
        task3.subtask_3();
        task3.subtask_4();
        task3.subtask_5();

        task4.subtask_1();
        task4.subtask_2();
        task4.subtasj_3();
        task4.subtask_4();
        task4.subtask_5();

        task5.subtask_5();
        task5.subtask_6();

    }
}


