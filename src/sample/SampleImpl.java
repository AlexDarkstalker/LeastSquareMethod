package sample;

import java.util.ArrayList;
import java.util.Random;

import static java.lang.Math.random;

/**
 *
 * Created by Ringo on 17.01.2017.
 */
public abstract class SampleImpl implements Sample {
//    static final int numElem = 20;
    protected ArrayList<RealPoint> sample;
    protected ArrayList<RealPoint> rightSample;

    public ArrayList<RealPoint> getRightSample() {
        return rightSample;
    }

    private double getNormalDistortion(double distortion) {
        Random rand = new Random();
        double dist = rand.nextGaussian();
        return 0.33*dist*distortion;
    }

    private double getDistortion(double distortion) {
        return distortion - 2*distortion*random();
    }

    @Override
    public void createSample(int numElem, double distortion, boolean normal){
        sample = new ArrayList<>();
        rightSample = new ArrayList<>();
        for(int i = 0; i < numElem; ++i) {
            double x = Math.PI * random();
            rightSample.add(new RealPoint(x, function(x)));
            if(normal)
                sample.add(new RealPoint(x, function(x)+getNormalDistortion(distortion)));
            else
                sample.add(new RealPoint(x, function(x)+getDistortion(distortion)));
        }
    }

    @Override
    public ArrayList<RealPoint> getSample() {
        return sample;
    }

    protected abstract double function(double x);
}
