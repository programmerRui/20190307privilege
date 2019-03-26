package com.privilege.po;

public class Privileges {
    private int id;
    private String name;
    private String fnpath;
    private String description;

    public Privileges() {
    }

    @Override
    public String toString() {
        return "Privileges{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fnpath='" + fnpath + '\'' +
                ", description='" + description + '\'' +
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

    public String getFnpath() {
        return fnpath;
    }

    public void setFnpath(String fnpath) {
        this.fnpath = fnpath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Privileges(int id, String name, String fnpath, String description) {
        this.id = id;
        this.name = name;
        this.fnpath = fnpath;
        this.description = description;
    }
}
