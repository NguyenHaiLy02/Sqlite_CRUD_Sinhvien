package com.example.sqlite_crud_slide5.model;

public class Employee {
    private String id,name;
    private float diem;

    public Employee() {

    }

    public Employee(String id, String name, float diem) {
        this.id = id;
        this.name = name;
        this.diem = diem;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getDiem() {
        return diem;
    }

    public void setDiem(float diem) {
        this.diem = diem;
    }
}
