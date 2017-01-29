package sample;

import java.util.ArrayList;

/**
 * Created bY_Sample Ringo on 13.12.2016.
 */
public interface Sample {
    void createSample(int numElem, double distortion, boolean normal);

    void createSample(Sample sample);
    ArrayList<RealPoint> getRightSample();
    ArrayList<RealPoint> getSample();
    void removeElem(RealPoint realPoint);

    void addElem(RealPoint point);
    Sample getCopy();
}
