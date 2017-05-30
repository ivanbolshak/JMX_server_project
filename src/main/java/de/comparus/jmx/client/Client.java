package de.comparus.jmx.client;

import de.comparus.jmx.HelloMBean;

import javax.management.*;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.io.IOException;
import java.net.MalformedURLException;

/**
 * Created by ibolshak on 5/24/17.
 */
public class Client {
    public static void main(String[] args) throws IOException, MalformedObjectNameException, InterruptedException, InstanceNotFoundException {
        JMXServiceURL jmxServiceURL = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:9999/jmxrmi");
        JMXConnector jmxConnector = JMXConnectorFactory.connect(jmxServiceURL, null);

        MBeanServerConnection mBeanServerConnection = jmxConnector.getMBeanServerConnection();

        ObjectName objectNameBean = new ObjectName("de.comparus.jmx:type=Hello");
        HelloMBean helloMBeanProxy = JMX.newMBeanProxy(mBeanServerConnection, objectNameBean, HelloMBean.class, true);
        //--------------  <--- create proxy to our HelloMBean.class
        //Add listener

        mBeanServerConnection.addNotificationListener(objectNameBean, new ClientListener(), null, null);



        helloMBeanProxy.sayHello();

        Thread.sleep(111); // give time for ClientListener

        System.out.println(helloMBeanProxy.addInteger(2, 3));
        helloMBeanProxy.setName("IvanProxy");
        System.out.println(helloMBeanProxy.getName());
        helloMBeanProxy.sayHello();

        System.out.println(helloMBeanProxy.returnPerson().getName());


        jmxConnector.close();
    }
}
