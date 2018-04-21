package com.botscrew.university.database.model;

import java.util.List;

public class Department {
    private int id;
    private String name;
    private Lector head;
    private List<Lector> lectors;
    public Department() {
    }

    public List<Lector> getLectors() {
        return lectors;
    }

    public void setLectors(List<Lector> lectors) {
        this.lectors = lectors;
    }

    public Department(int id, String name, Lector head,List<Lector> lectors) {
        this.id = id;
        this.name = name;
        this.head = head;
        this.lectors=lectors;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", head=" + head +
                ", lectors=" + lectors +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Lector getHead() {
        return head;
    }

    public void setHead(Lector head) {
        this.head = head;
    }
}
