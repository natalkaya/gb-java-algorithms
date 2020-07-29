package com.company;

import java.security.Timestamp;

/**
 * Задание 1.1
 * Приведите пример алгоритмов и структур данных из жизни.
 * Алгоритмы:
 * Нахождение квартиры по номеру: подъезд, этаж
 * Мрашрут из точки А в Б
 * Стркутуры данных: Оглавление в книге
 * <p>
 * Задание 1.2
 * Приведите пример алгоритмов и структур данных в
 * программировании.
 * Алгоритмы поиска(линейный, бинарный) или сортировки(сортировка вставкамиб методом пузырька)
 * Структуры данных:
 * Стэк, очереди, массивы, списки, таблицы, графы, дерево, префиксное дерево, хэш-таблицы
 * <p>
 * Задание 1.3
 * Напишите программный код, в котором все данные хранятся только в
 * переменных трех типов данных: Ссылочные, примитивные и своего класса
 * содержащего: конструктор и метод отображения данных.
 * Выведите написанные данные.
 * <p>
 * Задание 1.4
 * Дополните предыдущий код сравнением ваших данных с другой
 * переменной, данный код должен имитировать простейший поиск перебором.
 * Оцените время выполнения алгоритма с помощью базового метода
 * System.nanoTime()
 */

public class Task1 {

    private final Example example = new Example("Example#1", 1);

    public void run() {
        System.out.println("\nTASK 1.3: current variables as primitives, reference and abstract types");
        int primitiveDataTypeInt = 6;
        System.out.println(primitiveDataTypeInt);
        double primitiveDataTypeDouble = 6.0;
        System.out.println(primitiveDataTypeDouble);
        String nonPrimitiveDataType = "String - non primitive data type";
        System.out.println(nonPrimitiveDataType);
        System.out.println(example.toString());

        System.out.println("\nTASK 1.4: compare current values");
        printComparisonResult(equalValue(primitiveDataTypeInt, 6));
        printComparisonResult(equalValue(primitiveDataTypeInt, primitiveDataTypeDouble));
        printComparisonResult(equalValue(example, new Example("Example#1", 1)));
    }

    private static void printComparisonResult(Boolean expression) {
        if (expression)
            System.out.println("Seems the same");
        else System.out.println("Totally different");
    }

    /**
     * Намерено не добавила сравнение:
     * - структу данных как Arrays
     * - сравнение двух абстрактных объектов по всем полям
     * - BigDecimal
     * - т.д.
     *
     * @param obj1 -
     * @param obj2 -
     * @return -
     */
    public static boolean equalValue(Object obj1, Object obj2) {
        long startTime = System.nanoTime();

        if (obj1 == null)
            return (obj2 == null);
        if (obj2 == null)
            return false;

        Class<?> class1 = obj1.getClass();
        Class<?> class2 = obj2.getClass();

        if (class1 == class2)
            return obj1.equals(obj2);

        if ((class1 == Long.class || class1 == Integer.class || class1 == Short.class) &&
                (class2 == Long.class || class2 == Integer.class || class2 == Short.class)) {
            return ((Number) obj1).longValue() == ((Number) obj2).longValue();
        }

        if ((class1 == String.class || obj1 instanceof Timestamp) &&
                (class2 == String.class || obj2 instanceof Timestamp)) {
            return obj1.toString().equals(obj2.toString());
        }

        long finishTime = System.nanoTime();
        System.out.println("Produced time: " + (finishTime - startTime));

        return false;
    }
}

class Example { //inner non-primitive data type
    private final String name;
    private final int count;

    public Example(String name, int count) {
        this.name = name;
        this.count = count;
    }

    @Override
    public String toString() {
        return "Example{" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }
}
