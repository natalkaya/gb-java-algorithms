package com.company;

import java.util.*;

public class BaseClass {
    private final Map<String, Long> timeExecution = new HashMap<>();
    protected long startTime = System.nanoTime();
    protected long endTime = System.nanoTime();
    protected Random random = new Random();

    public void printTimeExecution(String algorithmName, long startTime, long endTime) {
        long execTime = endTime - startTime;
        timeExecution.put(algorithmName, execTime);
        System.out.println(String.format("Time:%s - %d", algorithmName, execTime));
    }

    public ArrayList<ArrayObj> initList(int size) {
        ArrayList<ArrayObj> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add(new ArrayObj(random.nextInt(size)));
        }
        return list;
    }

    public int[] initArray(int arrSize) {
        int[] arr = new int[arrSize];
        for (int i = 0; i < arrSize; i++) {
            arr[i] = random.nextInt(arrSize);
        }
        return arr;
    }
}
