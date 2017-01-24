package function;

import sample.RealPoint;

import java.util.ArrayList;

/**
 * Created by Ringo on 17.01.2017.
 */
public abstract class FunctionImpl implements Function {
    ArrayList<RealPoint> functionPoints;


    private double getMinElem(ArrayList<Double> data){
        double min = data.get(0);
        for(double elem: data) {
            if (elem < min)
                min = elem;
        }
        return min;
    }

    private double getMaxElem(ArrayList<Double> data){
        double max = data.get(0);
        for(double elem: data) {
            if (elem > max)
                max = elem;
        }
        return max;
    }

    private double getInterval(ArrayList<Double> data) {
        return getMaxElem(data) - getMinElem(data);
    }

    private ArrayList<Double> getX(){
        ArrayList<Double> sampleX = new ArrayList<>();
        for(RealPoint point: functionPoints)
            sampleX.add(point.getX());
        return sampleX;
    }

    private ArrayList<Double> getY(){
        ArrayList<Double> sampleY = new ArrayList<>();
        for(RealPoint point: functionPoints)
            sampleY.add(point.getY());
        return sampleY;
    }


    public double getXInterval(){
        return getInterval(getX());
    }

    public double getYInterval(){
        return getInterval(getY());
    }

    @Override
    public ArrayList<RealPoint> getFunction() {
        return functionPoints;
    }

    @Override
    public void createFunction() {
        functionPoints = new ArrayList<>();
        for(double x = -2*Math.PI; x < 2*Math.PI; x+=0.02) {
            functionPoints.add(new RealPoint(x, function(x)));
        }
    }
}
