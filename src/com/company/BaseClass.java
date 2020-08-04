package com.company;

import java.util.HashMap;
import java.util.Map;

public class BaseClass {
    protected long startTime = System.nanoTime();
    protected long endTime = System.nanoTime();
    private final Map<String, Long> timeExecution = new HashMap<>();

    public void printTimeExecution(String algorithmName, long startTime, long endTime) {
        long execTime = endTime - startTime;
        timeExecution.put(algorithmName, execTime);
        System.out.println(String.format("Time:%s - %d", algorithmName, execTime));
    }
}
