package com.example.diseasetracker;

public class UserInfo {
    String name,email,age,gender;

    UserInfo(){

    }


    UserInfo(String n,String e,String g,String a)
    {
        name=n;
        email=e;
        gender=g;

        age=a;

    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  String getEmail(){return  email;}

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
