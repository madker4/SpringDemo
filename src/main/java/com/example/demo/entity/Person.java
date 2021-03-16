package com.example.demo.entity;

public abstract class Person {

    private String name;
    private String surname;
    private Integer age;

    private Gender gender;

    public Person(String name, String surname, Integer age, Gender gender) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
    }

    public Person(String name, Integer age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Person() {
        this.age = 0;
        this.gender = Gender.UNKNOWN;
        this.name = "";
        this.surname = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getSurname() { return surname; }

    public void setSurname(String surname) { this.surname = surname; }

    @Override
    public String toString()
    {
        String s = "Name: " + this.name + " Age: " + this.age.toString() + " Gen: " + this.gender.toString();
        return s;
    }
}
