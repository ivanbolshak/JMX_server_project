package de.comparus.jmx;

import javax.management.AttributeChangeNotification;
import javax.management.MBeanNotificationInfo;
import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;

/**
 * Created by ibolshak on 5/24/17.
 */
//public class Hello implements HelloMBean {
public class Hello extends NotificationBroadcasterSupport implements HelloMBean {
//public class Hello extends NotificationBroadcasterSupport implements HelloMBean {

    private String name;
    private static int sequenceNumber = 0;

    NotificationBroadcasterSupport notificationBroadcasterSupport = new NotificationBroadcasterSupport();

    public void sayHello() {
        System.out.println("Hi " + name + "!");
        Notification notification = new AttributeChangeNotification(this, sequenceNumber++, System.currentTimeMillis(),
                "get sayHallo and change sequenceNumber", "sequenceNumber", "int", sequenceNumber-1, sequenceNumber);
        sendNotification(notification);
    }

    public int addInteger(int x, int y) {

        int res = x+y;
        System.out.println("addInteger sum: " + x + " + " + y + " = " + res);


        Notification notification = new AttributeChangeNotification(this, sequenceNumber++, System.currentTimeMillis(),
                x + " + " + y + " = " +res, "res", "int", null, res);
        sendNotification(notification);


        return res;
    }

    public Person returnPerson() {
        return new Person();
    }

    public String getName() {
        return name;
    }

    public String returnName(){
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //// ----- set notification for remote server ():
    //   1. extends NotificationBroadcasterSupport
    //    2. public MBeanNotificationInfo[] getNotificationInfo() .... - not need

//    public MBeanNotificationInfo[] getNotificationInfo() {
//
//        String [] types = new String[]{
//                AttributeChangeNotification.ATTRIBUTE_CHANGE
//        };
//
//        String name = AttributeChangeNotification.class.getName();
//        String description = "Attribute in HelloMBen has changed";
//        MBeanNotificationInfo info = new MBeanNotificationInfo(types, name, description);
//
//        return new MBeanNotificationInfo[]{info};
//
//
//    }



}
