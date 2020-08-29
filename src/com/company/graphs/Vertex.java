package com.company.graphs;

public class Vertex {
    private char label;

    public char getLabel() {
        return label;
    }

    public void setWasVisited(boolean wasVisited) {
        this.wasVisited = wasVisited;
    }

    public boolean isWasVisited() {
        return wasVisited;
    }

    private boolean wasVisited;

    public Vertex(char label) {
        this.label = label;
        this.wasVisited = false;
    }
}
