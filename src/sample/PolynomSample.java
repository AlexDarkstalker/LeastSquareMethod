package sample;

import function.Function;
import function.PolynomFunction;

/**
 * Created by Ringo on 17.01.2017.
 */
public class PolynomSample extends SampleImpl {
    Function polynomFunc = new PolynomFunction();
    @Override
    protected double function(double x) {
        return polynomFunc.function(x);
    }
}
