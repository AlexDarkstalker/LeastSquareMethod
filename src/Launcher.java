import graphics.Graphic;
import leastsquare.LeastSquare;
import sample.CosSample;
import sample.Sample;

import java.awt.*;
import java.util.Random;

/**
 * Created by Ringo on 12.12.2016.
 */
public class Launcher {
    public static void main(String[] args) {
        Graphic graphic = new Graphic();
        graphic.setSize(new Dimension(600, 400));
        graphic.setVisible(true);
//        Random rand = new Random();
//        double sum = 0;
//        for(int i = 0; i < 1000; i++) {
//            double dist = rand.nextGaussian()*0.33;
//            sum+=dist;
//            System.out.println(dist);
//        }
//        System.out.println(sum+"!");
//
//        Sample cos = new CosSample();
//        cos.createSample(10, 0.2, true);
//        LeastSquare ls = new LeastSquare(cos);
//        double[] vect = {3,2,5};
//        double[][] matr = {
//                {1,2,4},
//                {6,3,4},
//                {7,4,2}
//        };
//        ls.gauss(matr, vect);
//        for(int i = 0; i < matr.length; i++) {
//            for (int j = 0; j < matr[i].length; j++)
//                System.out.print(matr[i][j] + " ");
//            System.out.print(vect[i]);
//            System.out.println();
//        }
//        double[] coeffs = ls.createCoefVect(matr, vect);
//        for(int i = 0; i < matr.length; i++)
//            System.out.println(coeffs[i] + " ");


    }
}
