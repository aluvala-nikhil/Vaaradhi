package com.example.luvphoto;

public class User {
   String Name;
   String Phone;
   String Role;

    public User(String name, String phone, String role) {
        Name = name;
        Phone = phone;
        Role = role;
    }
    public String getName() {
        return Name;
    }

    public String getPhone() {
        return Phone;
    }

    public String getRole() {
        return Role;
    }
}
