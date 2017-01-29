package graphics;

import leastsquare.LeastSquare;
import sample.RealPoint;
import function.Function;
import sample.Sample;


import java.awt.*;
import java.util.ArrayList;

import static java.lang.Double.max;

/**
 *
 * Created by Ringo on 18.01.2017.
 */
public class DrawPanel extends Panel {
    private ArrayList<Point> func;
    private Function function;
    private Function createdFunction;
    private ArrayList<Point> createdFuncPoints;
    private ArrayList<Point> samplePoints;
    private Sample sample;

    public void setFunction(Function function, Sample sample, Function newFunction) {
        this.function = function;
        this.sample = sample;
        this.createdFunction = newFunction;
        this.createdFuncPoints = realToScreen(newFunction);
        this.func = realToScreen(function);
        this.samplePoints = realToScreen(sample);
    }

//    public void setCreatedFunction(Function createdFunction) {
//        this.createdFunction = createdFunction;
//    }

    public void paint(Graphics g) {
        this.setBackground(Color.WHITE);
        g.setColor(Color.BLACK);
        this.func = realToScreen(function);
        g.drawPolyline(getXPoint(func), getYPoint(func), func.size());
        g.setColor(Color.RED);
        this.createdFuncPoints = realToScreen(createdFunction);
        g.drawPolyline(getXPoint(createdFuncPoints), getYPoint(createdFuncPoints), createdFuncPoints.size());
        this.samplePoints = realToScreen(sample);
        g.setColor(Color.RED);
        for(Point point:samplePoints)
            g.fillOval(point.x, point.y, 3,3);
        //setVisible(true);
    }

//    @Override
//    public void repaint() {
//        paint(this.getGraphics());
//    }

    private int[] getXPoint(ArrayList<Point> func){
        int[] xPoint = new int[func.size()];
        for(int i = 0; i < func.size(); i++)
            xPoint[i] = func.get(i).x;
        return xPoint;
    }

    private int[] getYPoint(ArrayList<Point> func){
        int[] yPoint = new int[func.size()];
        for(int i = 0; i < func.size(); i++)
            yPoint[i] = func.get(i).y;
        return yPoint;
    }


    private ArrayList<Point> realToScreen(Function func) {
        ArrayList<Point> screenPoints = new ArrayList<>();
        for(RealPoint realPoint:func.getFunction())
            screenPoints.add(makePoint(realPoint, function.getXInterval(), function.getYInterval()));
        return screenPoints;
    }

    private ArrayList<Point> realToScreen(Sample sample) {
        ArrayList<Point> screenPoints = new ArrayList<>();
        for(RealPoint realPoint:sample.getSample())
            screenPoints.add(makePoint(realPoint, function.getXInterval(), function.getYInterval()));
        return screenPoints;
    }

    private Point makePoint(RealPoint realPoint, double width, double height) {
        int screenWidth = this.getWidth();
        int screenHeight = this.getHeight();
        double partX = 0.9*(realPoint.getX()/width*screenWidth +screenWidth*0.5) + screenWidth*0.05;
        double partY = (0.9*(realPoint.getY()/height*screenHeight + screenHeight*0.5) + screenHeight*0.05);
        int pointX = (int) partX;
        int pointY = (int) partY;
        return new Point(pointX, pointY);
    }
}
