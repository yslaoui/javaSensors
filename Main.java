package sensors;

import abc.A;
import com.sun.security.jgss.GSSUtil;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        AverageSensor sensor = new AverageSensor();

        Sensor sensor1 = new StandardSensor(25);
        Sensor sensor2 = new TemperatureSensor();
        Sensor sensor3 = new StandardSensor(6);
        sensor.addSensor(sensor1);
        sensor.addSensor(sensor2);
        sensor.addSensor(sensor3);

        System.out.println("Initially temperature sensors are off while standard sensors are on");
        System.out.println(sensor.printSensorStates());
        System.out.println("We turn all sensors on to be able to read them");
        sensor.setOn();
        System.out.println(sensor);
        System.out.println(sensor.read());
        System.out.println("Since read() in TemperatureSensor generates a new random number evrytime it gets called, the average returned will not be the one of the numbers printed above");
//        System.out.println(sensor.read());

    }
}


