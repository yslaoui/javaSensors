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
        return this.sensors
                .stream()
                .map(sensor->sensor.read())
                .reduce(0,  (a, b)-> a+b) / this.sensors.size();
    }
}

