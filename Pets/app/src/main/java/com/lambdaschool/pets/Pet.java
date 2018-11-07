package com.lambdaschool.pets;

import java.io.Serializable;

public class Pet implements Serializable {

    public static final int NO_ID = -1;

    String name;
    String type;
    int id;

    public Pet(String name, String type, int id) {
        this.name = name;
        this.type = type;
        this.id = id;
    }

    public Pet(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
