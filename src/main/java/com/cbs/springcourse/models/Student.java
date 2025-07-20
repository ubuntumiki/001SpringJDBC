package com.cbs.springcourse.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Student {
    private int id;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 50, message = "Name should be between 2 and 50 characters")
    private String name;

    @NotEmpty(message = "Lastname should not be empty")
    @Size(min = 2, max = 50, message = "Lastname should be between 2 and 50 characters")
    private String lastname;

    @Min(value = 0, message = "Age should be greater than 0")
    private int age;

    @NotEmpty(message = "Phone should not be empty")
    @Size(min = 13, max = 13, message = "Phone name should be 15 characters long")
    private String phone;

    @NotEmpty(message = "Email should not be empty")
    @Email(message = "Email should be valid")
    private String email;

    public Student(){

    }

    public Student(int id, String name, String lastname, int age, String phone, String email) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.phone = phone;
        this.email = email;
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
