package de.comparus.jmx;

/**
 * Created by ibolshak on 5/24/17.
 */
public interface HelloMBean {

    void sayHello();
    int addInteger(int x, int y);

    Person returnPerson();

    String getName();
    void setName(String name);

    String returnName();
//
//
////    int getCacheSize();
////    void setCacheSize(int size);

}
