package com.zhehao.pojo;

/*
大多数情况下，Java 实体类（也称为 POJO，Plain Old Java Object）通常需要和数据库中的表结构一一对应，
尤其是在使用对象关系映射（ORM）框架如Hibernate、JPA等时。这个一一对应的关系通常被称为对象-关系映射（ORM）
*/
public class People {

    private int id;
    private String name;
    private int age;
    private String address;

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

    public People() {
    }

    public People(int id, String name, int age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
