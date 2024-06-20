package sensors;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AverageSensor implements Sensor{

    boolean state;
    List<Sensor> sensors;

    public AverageSensor() {
        this.sensors = new ArrayList<>();
    }

    public void addSensor(Sensor sensorToAdd) {
        this.sensors.add(sensorToAdd);
    }

    @Override
    public boolean isOn() {
        for (Sensor sensor: this.sensors) {
            if (!sensor.isOn()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void setOn() {
        for (Sensor sensor: this.sensors) {
            sensor.setOn();
        }
    }

    @Override
    public void setOff() {
        Random random = new Random();
        int turnOff;
        for (Sensor sensor: this.sensors) {
            turnOff = random.nextInt(2);
            if (turnOff == 1) {
                sensor.setOn();
            }
            else if (turnOff == 0) {
                sensor.setOff();
            }
        }
    }

    @Override
    public int read() throws IllegalStateException {
        if (!(this.isOn())) {
            throw new IllegalStateException("Turn all sensors on to read them");
        }
        if (this.sensors.size() == 0) {
            throw new IllegalStateException("Add a sensor to the Average sensor");
        }

        return this.sensors
                .stream()
                .map(sensor->sensor.read())
                .reduce(0,  (a, b)-> a+b) / this.sensors.size();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[ ");
        for (Sensor sensor: this.sensors) {
            builder.append(sensor.isOn()).append(": ");
            builder.append(sensor.read()).append(" ,");
        }
        builder.append("] ");
        return builder.toString();
    }

    public String printSensorStates() {
        StringBuilder builder = new StringBuilder("[ ");
        for (Sensor sensor: this.sensors) {
            builder.append(sensor.isOn()).append(" ,");
        }
        builder.append(" ]");
        return builder.toString();
    }
}

