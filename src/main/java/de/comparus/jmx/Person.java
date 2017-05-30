package de.comparus.jmx;

import java.io.Serializable;

/**
 * Created by ibolshak on 5/24/17.
 */
public class Person implements Serializable{
    private String name = "Not yet set name";
    private int age = 0;

    Person(){

    }

    Person(String name, int age){
        this.name = name;
        this.age = age;
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

    public Person returnPerson(){
        return this;
    }
}
