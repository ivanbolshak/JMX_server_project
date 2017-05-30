package de.comparus.jmx.client;

import javax.management.AttributeChangeNotification;
import javax.management.Notification;
import javax.management.NotificationListener;
import java.util.Date;

/**
 * Created by ibolshak on 5/24/17.
 */
public class ClientListener implements NotificationListener {
    public void handleNotification(Notification notification, Object handback) {
        System.out.println("ClientListener message: " + notification.getMessage());
        System.out.println("ClientListener type: " + notification.getType());
        System.out.println("ClientListener time:" + new Date(notification.getTimeStamp()));

        if (notification instanceof AttributeChangeNotification){
            AttributeChangeNotification attributeChangeNotification = (AttributeChangeNotification) notification;

            System.out.println("ClientListener attribute name: " + attributeChangeNotification.getAttributeName());
            System.out.println("ClientListener attribute type: " + attributeChangeNotification.getAttributeType());
            System.out.println("ClientListener old value: " + attributeChangeNotification.getOldValue());
            System.out.println("ClientListener new value: " + attributeChangeNotification.getNewValue());
        }
    }
}
