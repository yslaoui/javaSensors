package sensors;

import java.util.Random;

public class TemperatureSensor implements Sensor{

    boolean state;
    int degree;

    public TemperatureSensor() {
        this.state = false;
    }

    @Override
    public boolean isOn() {
        return this.state;
    }

    @Override
    public void setOn() {
        this.state = true;
    }

    @Override
    public void setOff() {
        this.state = false;
    }

    @Override
    public int read() throws IllegalStateException {
        if (!this.state) {
            throw new IllegalStateException("You cannot read the sensor when it is turned off");
        }
        else {
            Random random = new Random();
            return random.nextInt(61) - 31;
        }
    }

}
