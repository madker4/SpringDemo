package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "XX_SALOID_JAVA_USERS")
@Getter
@Setter
public class User {
    @Id
    private Integer id;

    private String name;

    private String username;

    private String email;

    private String street;

    private String suite;

    private String city;

    private String zipcode;

    private String phone;

    private String website;

    private String gender;

    public User() {
    }


    public User(Integer id, String username, String name, String email, String street, String suite, String city, String zipcode,
                String phone, String website) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.street = street;
        this.suite = suite;
        this.city = city;
        this.zipcode = zipcode;
        this.phone = phone;
        this.website = website;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", street='" + street + '\'' +
                ", suite='" + suite + '\'' +
                ", city='" + city + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", phone='" + phone + '\'' +
                ", website='" + website + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
