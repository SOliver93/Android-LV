package com.example.arcus.laboratorijskevjezbe_android.model;

public final class Student {
    private String Name;
    private String Surname;
    public Student(String name, String surname){
        this.Name = name;
        this.Surname = surname;
    }
    public String getName() {
        return Name;
    }

    public String getSurname() {
        return Surname;
    }
}
