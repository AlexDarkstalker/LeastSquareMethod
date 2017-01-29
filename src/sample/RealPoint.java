package sample;

/**
 * Created by Ringo on 17.01.2017.
 */
public class RealPoint {
    private double x;
    private double y;


    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public RealPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public boolean equals(RealPoint rp) {
        if(this == rp)
            return true;
        if((Double.valueOf(x).equals(rp.getX()))&&(Double.valueOf(y).equals(rp.getY())))
            return true;
        else
            return false;
    }
}
