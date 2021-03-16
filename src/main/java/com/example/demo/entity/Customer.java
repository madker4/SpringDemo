package com.example.demo.entity;

public class Customer  extends Person{

    private Integer customerId;
    private String email;

    public Customer(){
        super();
        this.email = "";
    }

    public Customer(String name, Integer age, Gender gender) {
        super(name, age, gender);
    }

    public Customer(Integer id,String name, Integer age, Gender gender) {
        super(name, age, gender);
        this.customerId = id;
    }

    public Customer(String name, String surname, Integer age, Gender gender) {
        super(name,surname,age,gender);
    }

    public Customer(Integer id,String name, String surname, Integer age, Gender gender, String email) {
        super(name,surname,age,gender);
        this.email = email;
        this.customerId = id;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName()
    {
        return this.getName() + " " + this.getSurname();
    }

    @Override
    public String toString()
    {
        return "Id: " + this.customerId + " "+ super.toString() + " email:" + this.email;
    }
}
