package sensors;

public class StandardSensor implements Sensor{

    private boolean state;
    private int degrees;

    public StandardSensor(int degree) {
        this.state = true;
        this.degrees = degree;

    }
    @Override
    public boolean isOn() {
        return true;
    }

    @Override
    public void setOn() {
    }

    @Override
    public void setOff() {
    }

    @Override
    public int read() throws IllegalStateException{
        if (!this.state) {
            throw new IllegalStateException("You cannot read the sensor when it is off");
        }
        return this.degrees;
    }
}



