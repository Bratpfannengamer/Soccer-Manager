package de.szut.soccer;

public abstract class Person {
    String name;
    int age;
    public Person(String name,int age){
        this.name=name;
        this.age=age;
    }
    public String getName(){
        return this.name;
    }
}
