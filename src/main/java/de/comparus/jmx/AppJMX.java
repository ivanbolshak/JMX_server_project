package de.comparus.jmx;

import javax.management.*;
import java.lang.management.ManagementFactory;

/**
 * Created by ibolshak on 5/24/17.
 */
public class AppJMX {
    public static void main(String[] args) throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException, InterruptedException {
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer(); //create server
        ObjectName objectName = new ObjectName("de.comparus.jmx:type=Hello"); //create objet mBean
        Hello helloBean = new Hello(); // craet object which implement MBeam interface
        mBeanServer.registerMBean(helloBean, objectName); //register MBean object in mBeanServer

        System.out.println("Start Thread.sleep forever.... ");
        Thread.sleep(Long.MAX_VALUE);



    }
}
