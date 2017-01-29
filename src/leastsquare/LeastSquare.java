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
    Function leastSquareCreatedFunction = new FunctionImpl() {
        @Override
        public double function(double x) {
            double result = 0;
            for(int i = 0; i < coefficients.size(); i++)
                result += coefficients.get(i) * pow(x, i);
            return result;
        }
    };

    public Function getLeastSquareCreatedFunction() {
        return leastSquareCreatedFunction;
    }

    public LeastSquare(Sample sample) {
        this.sample = sample;
        double summ = 0;
        double mist = 0;
        ArrayList<Double> minMistCoeffs = new ArrayList<>();
        double minSumm = Double.MAX_VALUE;
        for(int power = 3; power < 13; power++) {
            this.power = power;
            Sample copy = sample.getCopy();
            summ = 0;
            for(int i = 0; i < copy.getSample().size(); i++) {
                RealPoint point = copy.getSample().get(i);
                copy.removeElem(point);
//                sample.getSample().remove(point);
                coefficients = getCoefficients(copy, power);

                mist = point.getY() - leastSquareCreatedFunction.function(point.getX());
                summ+=mist*mist;
                copy.getSample().add(i, point);
            }
            if(summ < minSumm) {
                minSumm = summ;
                minMistCoeffs = coefficients;
                System.out.println(power);
            }

        }
        coefficients = minMistCoeffs;
        leastSquareCreatedFunction.createFunction();
    }



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
            for(int k = i+1; k < matrix.length; k++) {
                double mult = getMult(matrix, i, k);
                multRow(matrix, mult, k);
                multVect(vector, mult, k);
            }
            for(int k = i+1; k < matrix.length; k++) {
                minusRows(matrix, i, k);
                minusVect(vector, i, k);
            }
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

    private ArrayList<Double> getCoefficients(Sample sample, int polynomPower) {
        double[][] matrixA = createMatrix(sample,polynomPower);
        double[] vectorB = createVect(sample, polynomPower);
        gauss(matrixA, vectorB);
        double [] coeffs = createCoefVect(matrixA, vectorB);
        ArrayList<Double> coefficients = new ArrayList<>();
        for(Double coeff:coeffs)
            coefficients.add(coeff);
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
                sum += coeffs[k]* matrix[i][k];
            }
            coeff = (vector[i] - sum)/matrix[i][i];
            coeffs[i] = coeff;
        }
        return coeffs;
    }

    private double errorFunc(Sample sample) {
        double error = 0;
        double summ = 0;
        for(int i = 0; i < sample.getSample().size(); i++) {
            error = sample.getSample().get(i).getY() - leastSquareCreatedFunction.function(sample.getSample().get(i).getX());
            summ += error * error;
        }
        return summ;
    }


}
