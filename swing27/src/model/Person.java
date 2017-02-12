package model;

import enums.AgeCategory;

public class Person {
    private static int count = 0;

    private int id;
    private String name;
    private AgeCategory ageCategory;

    public Person(String name, AgeCategory ageCategory) {
        this.name = name;
        this.ageCategory = ageCategory;
        id = count++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AgeCategory getAgeCategory() {
        return ageCategory;
    }

    public void setAgeCategory(AgeCategory ageCategory) {
        this.ageCategory = ageCategory;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ageCategory=" + ageCategory +
                '}';
    }
}
