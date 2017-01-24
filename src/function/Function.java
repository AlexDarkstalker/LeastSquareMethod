package function;

import sample.RealPoint;

import java.util.ArrayList;

/**
 * Created by Ringo on 17.01.2017.
 */
public interface Function {
    void createFunction();
    double function(double x);
    double getXInterval();
    double getYInterval();
    ArrayList<RealPoint> getFunction();
}
