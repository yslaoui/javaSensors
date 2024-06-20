package sensors;

import abc.A;
import com.sun.security.jgss.GSSUtil;

public class Main {
    public static void main(String[] args) {
//        TemperatureSensor tempSensor = new TemperatureSensor();
//        tempSensor.setOn();
//        System.out.println(tempSensor.read());
//        tempSensor.setOff();
//        System.out.println(tempSensor.read());

        AverageSensor sensor = new AverageSensor();
        Sensor sensor1 = new StandardSensor(25);
        Sensor sensor2 = new TemperatureSensor();
        Sensor sensor3 = new StandardSensor(6);
        sensor.addSensor(sensor1);
        sensor.addSensor(sensor2);
        sensor.addSensor(sensor3);

        System.out.println(sensor1.read());
        sensor2.setOn(); // Temperature sensors are off by default nd cannot be read
        System.out.println(sensor2.read());
        System.out.println(sensor3.read());

    }
}


