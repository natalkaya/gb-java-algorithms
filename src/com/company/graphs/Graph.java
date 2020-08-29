package com.company.graphs;

import com.company.BaseClass;

/**
 * Задание 7.1
 * Приведите пример графа.
 * Задание 7.2
 * Реализуйте базовые методы графа.
 * Задание 7.3
 * В программный код из задания 7.2 добавьте реализацию метода обхода
 * в глубину.
 * Выполните оценку времени с помощью System.nanoTime().
 * Задание 7.4
 * В базовом графе из задания 7.2 реализуйте метод обхода в ширину.
 * Выполните оценку времени с помощью System.nanoTime().
 */

public class Graph extends BaseClass {
    /*
     * Задание 7.1
     * Приведите пример графа.
     * Любой переход состояний можно описать графом, например, найти оптимальный маршрут или описать состояния дверного замка.
     * Возьмем последний пример: состония дверного замка - это связый граф.
     * Начальное состояние (1 вершина) - замок закрыт, следующее состояния - замок открыт (2 вершина)
     * (1 - открыто) -->
     *               <-- (2 - закрыто)
     *
     */

    private final int MAX_VERTS = 32;
    private Vertex[] vertices;
    private int[][] adjMat;
    private int size;
    private Stack stack;

    public Graph() {
        this.vertices = new Vertex[MAX_VERTS];
        this.adjMat = new int[MAX_VERTS][MAX_VERTS];
        this.size = 0;
        this.stack = new Stack(MAX_VERTS);

        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                this.adjMat[i][j] = 0;
            }
        }
    }

    public void addVertex(char label) {
        vertices[size++] = new Vertex(label);
    }

    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void displayVertex(int label) {
        System.out.println(vertices[label].getLabel());
    }

    private int getAdjUnvisitedVerts(int vert) {
        for (int i = 0; i < size; i++) {
            if (this.adjMat[vert][i] == 1 && !vertices[i].isWasVisited()) return i;
        }
        return -1;
    }

    public void dfs() {
        vertices[0].setWasVisited(true);
        displayVertex(0);
        stack.push(0);
        while (!stack.isEmpty()) {
            int v = getAdjUnvisitedVerts(stack.peek());
            if (v == -1) {
                stack.pop();
            } else {
                vertices[v].setWasVisited(true);
                displayVertex(v);
                stack.push(v);
            }
        }
        clearFlags();
    }

    private void clearFlags() {
        for (int i = 0; i < size; i++) {
            vertices[i].setWasVisited(false);
        }
    }

    /**
     * Поиск в глубину
     * @param f - индекс веришны
     */
    public void DFS(int f) {
        vertices[f].setWasVisited(true);
        for (int i = 0; i < size; i ++) {
            int v = getAdjUnvisitedVerts(f);
            if (!vertices[i].isWasVisited() && v != -1) {
                fullDisplayVerts(f, v);
                DFS(i);
            }
        }
    }

    public void fullDisplayVerts(int vert1, int vert2) {
        System.out.println(String.format("Vertices: %s-%s ", vertices[vert1].getLabel(), vertices[vert2].getLabel()));
    }

    /**
     * Поиск в ширину
     * @param v - индекс вершины
     */
    public void bfs(int v) {
        startTime = System.nanoTime();
        int[] queue = new int[size];
        int qHead = 0;
        int qTail = 0;

        vertices[0].setWasVisited(true);
        queue[qTail++] = v;
        displayVertex(0);

        int v2; //смежные вершины
        while (qHead < qTail) {
            v = queue[qHead++];
            for (int i = 0; i < size; i++) {
                v2 = getAdjUnvisitedVerts(v);
                if (!vertices[i].isWasVisited() && v2 != -1) {
                    vertices[i].setWasVisited(true);
                    displayVertex(v2);
                    queue[qTail++] = i;
                }
            }
        }

        clearFlags();
        endTime = System.nanoTime();
        printTimeExecution("BFS", startTime, endTime);
    }

    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(0, 3);
        graph.addEdge(3, 4);

//        graph.displayVertex(3);
//        graph.dfs();

        long start = System.nanoTime();
        graph.DFS(1);
        long end = System.nanoTime();
        System.out.println(String.format("DFS: %d", end - start));

        graph.bfs(1);

    }


    public class Stack {
        private int size;
        private int[] stackArr;
        private int top;

        public Stack(int size) {
            this.size = size;
            this.stackArr = new int[size];
            this.top = -1;
        }

        public void push(int i) {
            stackArr[++top] = i;
        }

        public int pop() {
            return stackArr[top--];
        }

        public int peek() {
            return stackArr[top];
        }

        public boolean isEmpty() {
            return top == -1;
        }
    }

}
