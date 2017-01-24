package sample;

import java.util.ArrayList;

/**
 * Created bY_Sample Ringo on 13.12.2016.
 */
public interface Sample {
    void createSample(int numElem, double distortion, boolean normal);

    ArrayList<RealPoint> getRightSample();
    ArrayList<RealPoint> getSample();
//    public final int NUM_ELEMS = 20;
//    List<Double> X_Sample = new ArrayList<>();
//    List<Double> Y_Sample = new ArrayList<>();
//    List<Double> X_func = new ArrayList<>();
//    List<Double> Y_func = new ArrayList<>();
//
//    public List<Double> getX_Sample() {
//        return X_Sample;
//    }
//
//    public void setX_Sample(List<Double> X_Sample) {
//        this.X_Sample = X_Sample;
//    }
//
//    public List<Double> getY_Sample() {
//        return Y_Sample;
//    }
//
//    public void setY_Sample(List<Double> Y_Sample) {
//        this.Y_Sample = Y_Sample;
//    }
//
//
//
//
//
//    private double functionPolynom(double x) {
//
//    }
//    private double functionSin(double x) {
//
//    }
//
//    public void createCosSample() {
//
//        }
//
//    }
//
//    public void createPolynomSample() {
//        for(int i = 0; i < NUM_ELEMS; ++i) {
//            X_Sample.add(2 * Math.PI * random());
//            Y_Sample.add(functionPolynom(X_Sample.get(i)));
//        }
//
//    }
//
//    public void createSinSample() {
//        for(int i = 0; i < NUM_ELEMS; ++i) {
//            X_Sample.add(2 * Math.PI * random());
//            Y_Sample.add(functionSin(X_Sample.get(i)));
//        }
//    }
//
//    public void createCosFunc() {
//        for(double i = 0.; i < 2*Math.PI; i+=0.01) {
//            X_func.add(i);
//            Y_func.add(functionCos(i));
//        }
//    }
//
//    public void createSinFunc() {
//        for(double i = 0.; i < 2*Math.PI; i+=0.01) {
//            X_func.add(i);
//            Y_func.add(functionSin(i));
//        }
//    }
//
//    public void createPolynomFunc() {
//        for(double i = 0.; i < 2*Math.PI; i+=0.01) {
//            X_func.add(i);
//            Y_func.add(functionPolynom(i));
//        }
//    }
}
