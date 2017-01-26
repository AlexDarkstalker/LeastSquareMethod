package leastsquare;

import function.CosFunction;
import function.Function;
import function.FunctionImpl;
import sample.RealPoint;
import sample.Sample;

import java.util.ArrayList;

import static java.lang.Math.pow;

/**
 *
 * Created by Ringo on 18.01.2017.
 */
public class LeastSquare {
    ArrayList<Double> coefficients;
    Sample sample;
    int power;

    public Function getLeastSquareCreatedFunction() {
        return leastSquareCreatedFunction;
    }

    public LeastSquare(Sample sample) {
        power = 9;
        this.sample = sample;
//        coefficients = getCoefficients(power);
        getCoefficients(power);
        leastSquareCreatedFunction.createFunction();
    }

    Function leastSquareCreatedFunction = new FunctionImpl() {
        @Override
        public double function(double x) {
            double result = 0;
            for(int i = 0; i < coefficients.size(); i++)
                result += coefficients.get(i) * pow(x, i);
            return result;
        }
    };

    private double sumX(Sample sample, int power) {
        double sum = 0;
        for(RealPoint point:sample.getSample())
            sum+=pow(point.getX(), power);
        return sum;
    }

    public double[][] createMatrix(Sample sample, int power) {
        double[][] matrix = new double[power+1][power+1];
        for(int i = 0; i <= power; i++)
            for (int j = 0; j <= power; j++)
                matrix[i][j] = sumX(sample, i+j);
        return matrix;
    }

    private double vectSum(Sample sample, int power) {
        double sum = 0;
        for(RealPoint point:sample.getSample())
            sum+=point.getY()*pow(point.getX(), power);
        return sum;
    }

    public double[] createVect(Sample sample, int power) {
        double[] vector = new double[power+1];
        for(int i = 0; i <= power; i++)
            vector[i] = vectSum(sample, i);
        return vector;
    }

    public void gauss(double[][] matrix, double[] vector) {
        for(int i = 0; i < matrix.length; i++)
            nullColumn(matrix, vector, i);
    }

    private void nullColumn(double[][] matrix, double[] vector, int i) {
        //for(int j = i+1; j < matrix.length; j++) {

            for(int k = i+1; k < matrix.length; k++) {
                double mult = getMult(matrix, i, k);
                multRow(matrix, mult, k);
                multVect(vector, mult, k);
            }
            for(int k = i+1; k < matrix.length; k++) {
                minusRows(matrix, i, k);
                minusVect(vector, i, k);
            }
        //}
    }

    private void minusVect(double[] vector, int i, int k) {
        vector[k]-=vector[i];
    }

    private void multVect(double[] vector, double mult, int k) {
        vector[k] *= mult;
    }

    private void multRow(double[][] matrix, double mult, int k) {
        for(int i = 0; i < matrix.length; i++)
            matrix[k][i]*=mult;
    }

    private double getMult(double[][] matrix, int i, int j) {
        return matrix[i][i]/matrix[j][i];
    }


    private void minusRows(double[][] matrix, int i, int j) {
        for(int k = i; k < matrix.length; k++)
            matrix[j][k]-=matrix[i][k];
    }

    private ArrayList<Double> getCoefficients(int polinomDegree) {
//        double[][]A = createMatrix(sample, polinomDegree);
//        double[]B = createVect(sample, polinomDegree);
//            double[]w = new double[polinomDegree+1];
//            //решение полинома
//            double d = 0, s = 0;
//
//            for (int k = 0; k < polinomDegree+1; k++) {// прямой ход
//                for (int j = k + 1; j < polinomDegree+1; j++) {
//                    d = A[j][k] / A[k][k];
//                    for (int i = k; i < polinomDegree +1; i++) {
//                        A[j][i] = A[j][i] - d * A[k][i];
//                    }
//                    B[j] = B[j] - d * B[k];
//                }
//            }
//            // обратный ход
//            w[polinomDegree] = B[polinomDegree]/A[polinomDegree][polinomDegree];
//            for (int k = polinomDegree-1; k >= 0; k--) {
//                d = 0;
//                for (int j = k + 1; j < polinomDegree+1; j++) {
//                    s = A[k][j] * w[j];
//                    d = d + s;
//                }
//                w[k] = (B[k] - d) / A[k][k];
//            }
        double[][] matrixA = createMatrix(sample,power);
        double[] vectorB = createVect(sample, power);
        gauss(matrixA, vectorB);
        double [] coeffs = createCoefVect(matrixA, vectorB);
        ArrayList<Double> coefficients = new ArrayList<>();
        for(Double coeff:coeffs)
            coefficients.add(coeff);
        this.coefficients = coefficients;
        return coefficients;
    }

    public double[] createCoefVect(double[][] matrix, double[] vector) {
        double[] coeffs = new double[vector.length];
        double sum;
        double coeff;
        coeffs[vector.length-1] = vector[vector.length-1]/matrix[vector.length-1][vector.length-1];
        for(int i = coeffs.length-2; i >=0; --i) {
            sum = 0;
            for(int k = i+1; k < matrix.length;k++) {
                sum+=  coeffs[k]* matrix[i][k];
            }
            coeff = (vector[i] - sum)/matrix[i][i];
            coeffs[i] = coeff;
        }
        return coeffs;
    }

    private double errorFunc(Sample sample) {
        double error = 0;
        double summ = 0;
        for(int i = 0; i < sample.getRightSample().size(); i++) {
            error = sample.getRightSample().get(i).getY() - leastSquareCreatedFunction.function(sample.getSample().get(i).getX());
            summ += error * error;
        }
        return summ;
    }


}
